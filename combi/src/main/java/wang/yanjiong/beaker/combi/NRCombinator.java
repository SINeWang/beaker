package wang.yanjiong.beaker.combi;

import wang.yanjiong.beaker.combi.cubes.basic.Process;
import wang.yanjiong.beaker.combi.cubes.basic.api.Request;
import wang.yanjiong.beaker.combi.cubes.basic.api.Response;
import wang.yanjiong.beaker.combi.cubes.basic.api.Transaction;
import wang.yanjiong.beaker.combi.cubes.basic.api.id.RequestId;
import wang.yanjiong.beaker.combi.cubes.basic.api.id.TransactionId;
import wang.yanjiong.beaker.combi.cubes.basic.spi.Forward;
import wang.yanjiong.beaker.combi.cubes.basic.spi.Reply;
import wang.yanjiong.beaker.combi.cubes.sync.api.nr.Normal;
import wang.yanjiong.beaker.combi.droplets.Concept;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WangYanJiong on 11/10/16.
 */
public class NRCombinator implements Combinator {

    public NRCombinator() {
    }

    private Object[] droplets;

    private List<Class> cubes = new ArrayList<Class>();

    private Transaction transaction;

    private Request request;

    private Response response;

    private Process process;

    public NRCombinator addDroplets(Object... droplets) {
        this.droplets = droplets;
        return this;
    }

    public NRCombinator addCubes(Class intfs, Object instance) {
        this.cubes.add(intfs);
        cubeInstances.put(intfs.getName(), instance);
        return this;
    }

    private Map<String, Object> cubeInstances = new HashMap<String, Object>();


    public Response call() {
        this.process = new Process();
        for (Class cube : cubes) {
            Method method = getMethodAnnotatedWith(cube, Normal.class);

            Class[] parameterTypes = method.getParameterTypes();
            List parameters = new ArrayList();
            for (Class parameterType : parameterTypes) {
                try {
                    parameters.add(parameterType.newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            final Object actualInstance = cubeInstances.get(cube.getName());

            Object proxy = Proxy.newProxyInstance(cube.getClassLoader(), new Class[]{cube}, new InvocationHandler() {

                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    for (Object requireArg : args) {

                        List<Field> requireFields = getAllFieldsAnnotated(requireArg.getClass(), Concept.class);
                        for (Field field : requireFields) {
                            Object value = getValueFromDropletsWithAnnotation(field);
                            field.setAccessible(true);
                            field.set(requireArg, value);
                        }
                    }

                    Object value = method.invoke(actualInstance, args);

                    return value;
                }
            });

            try {
                Object result = method.invoke(proxy, parameters.toArray());
                this.response = new Response(process, result);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return this.response;
    }

    private Object getValueFromDropletsWithAnnotation(Field field) {
        Concept concept = field.getAnnotation(Concept.class);
        String namespace = concept.namespace();
        String name = concept.name();
        for (Object droplet : droplets) {
            Object value =  getOneFieldsAnnotatedWithConcept(droplet.getClass(), namespace, name, droplet);
            return value;
        }
        throw new IllegalArgumentException();
    }


    public <T> T getResult(Class<T> klass) {
        return EntityFactory.newInstance(klass, droplets);
    }

    private void buildTransaction() {
        for (Object droplet : droplets) {
            Field field = getOneFieldAnnotatedWith(droplet.getClass(), TransactionId.class);
            try {
                Object value = field.get(droplet);
                String transactionId = (String) value;
                transaction = new Transaction(this.process, transactionId);
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void buildRequest() {
        for (Object droplet : droplets) {
            Field field = getOneFieldAnnotatedWith(droplet.getClass(), RequestId.class);
            try {
                Object value = field.get(droplet);
                String transactionId = (String) value;
                transaction = new Transaction(this.process, transactionId);
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException();
            }
        }
    }


    public Transaction getTransaction() {
        return transaction;
    }

    public Request getRequest() {
        return request;
    }

    public Response getResponse() {
        return response;
    }

    public Forward[] getForwards() {
        for (Class cube : cubes) {

        }
        return new Forward[0];
    }

    public Reply[] getReplies() {
        return new Reply[0];
    }

    public CombineStatus getStatus() {
        return CombineStatus.UNKNOWN;
    }

    public FailedStrategy getStrategy() {
        return null;
    }

    public static Method getMethodAnnotatedWith(final Class<?> klass, final Class<? extends Annotation> annotation) {
        if (klass != Object.class) {
            try {
                Method[] methods = klass.getDeclaredMethods();
                for (final Method method : methods) {
                    Annotation annotationExists = method.getAnnotation(annotation);
                    if (annotationExists != null) {
                        return method;
                    }
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }

        }
        throw new IllegalArgumentException();
    }

    public static Object getOneFieldsAnnotatedWithConcept(final Class<?> klass, String namespace, String name, final Object droplet) {
        for (Class<?> type = klass; type != Object.class; ) { //type = klass.getSuperclass()
            final Field[] allFields = klass.getDeclaredFields();
            for (final Field field : allFields) {
                if (field.isAnnotationPresent(Concept.class)) {
                    Concept concept = field.getAnnotation(Concept.class);
                    if (concept.namespace().equalsIgnoreCase(namespace) && concept.name().equalsIgnoreCase(name)) {
                        field.setAccessible(true);
                        try {
                            return field.get(droplet);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            for (final Field field : allFields) {
                try {
                    field.setAccessible(true);
                    Object subDroplet = field.get(droplet);
                    return getOneFieldsAnnotatedWithConcept(field.getType(), namespace, name, subDroplet);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        throw new IllegalArgumentException();
    }

    public static List<Field> getAllFieldsAnnotated(final Class<?> klass, final Class<? extends Annotation> annotation) {
        final List<Field> fields = new ArrayList<Field>();
        for (Class<?> type = klass; type != Object.class; type = klass.getSuperclass()) {
            final Field[] allFields = klass.getDeclaredFields();
            for (final Field field : allFields) {
                if (field.isAnnotationPresent(annotation)) {
                    fields.add(field);
                }
            }
        }
        return fields;
    }

    public static Field getOneFieldAnnotatedWith(final Class<?> klass, final Class<? extends Annotation> annotation) {
        for (Class<?> type = klass; type != Object.class; type = klass.getSuperclass()) {
            final Field[] allFields = klass.getDeclaredFields();
            if (allFields.length > 1) {
                throw new IllegalArgumentException();
            }
            if (allFields.length == 0) {
                throw new IllegalArgumentException();
            }
            return allFields[0];
        }
        throw new IllegalArgumentException();
    }
}
