package wang.yanjiong.beaker.combi;

import wang.yanjiong.beaker.combi.cubes.basic.api.Response;
import wang.yanjiong.beaker.combi.cubes.sync.api.cc.Commit;
import wang.yanjiong.beaker.combi.droplets.Concept;
import wang.yanjiong.beaker.remix.Mixer;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WangYanJiong on 11/10/16.
 */
public class SerialCombinator extends CombinatorBoundary implements Combinator {

    private Mixer mixer;

    public SerialCombinator(Mixer mixer) {
        this.mixer = mixer;
    }

    private Object[] droplets;

    private List<Class> cubes = new ArrayList<Class>();


    public SerialCombinator addDroplets(Object... droplets) {
        this.droplets = droplets;
        return this;
    }

    public SerialCombinator addCubes(Class intfs, Object instance) {
        this.cubes.add(intfs);
        cubeInstances.put(intfs.getName(), instance);
        return this;
    }

    private Map<String, Object> cubeInstances = new HashMap<String, Object>();


    public Response call() {
        for (Class cube : cubes) {

            final Object actualInstance = cubeInstances.get(cube.getName());

            Object proxy = Proxy.newProxyInstance(cube.getClassLoader(), new Class[]{cube}, new InvocationHandler() {

                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    for (Object requireArg : args) {
                        List<Field> requireFields = mixer.getAllFieldsAnnotated(requireArg.getClass(), Concept.class);
                        for (Field field : requireFields) {
                            Object value = mixer.getValueFromDropletsWithAnnotation(field, droplets);
                            field.setAccessible(true);
                            field.set(requireArg, value);
                        }
                    }
                    Object value = method.invoke(actualInstance, args);

                    return value;
                }
            });

            Method method = mixer.getMethodAnnotatedWith(cube, Commit.class);

            Class[] parameterTypes = method.getParameterTypes();
            List proxyArgs = new ArrayList();
            for (Class parameterType : parameterTypes) {
                try {
                    proxyArgs.add(parameterType.newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            try {
                Object result = method.invoke(proxy, proxyArgs.toArray());
                this.response = new Response(process, true, result);
            } catch (IllegalAccessException e) {
                this.response = new Response(process, false, e);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                this.response = new Response(process, false, e);
            }
        }
        return this.response;
    }


    public CombineStatus getStatus() {
        return CombineStatus.UNKNOWN;
    }

    public FailedStrategy getStrategy() {
        return null;
    }


}
