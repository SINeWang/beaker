package wang.yanjiong.beaker.combi;

import wang.yanjiong.beaker.combi.cubes.sync.api.nr.Normal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by WangYanJiong on 11/10/16.
 */
public class Combinator<T> implements Runnable {

    public Combinator() {
    }

    private Object[] droplets;

    private Class[] cubes;

    public Combinator addDroplets(Object... droplets) {
        this.droplets = droplets;
        return this;
    }

    public Combinator addCubes(Class... cubes) {
        this.cubes = cubes;
        return this;
    }

    public <T> T run(Class<T> clazz) {
        try {
            T t = clazz.newInstance();
            return t;
        } catch (InstantiationException e) {
            throw new RuntimeException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException();
        }
    }

    public void run() {
        for (Class cube : cubes) {
            List<Method> methods = getMethodsAnnotatedWith(cube, Normal.class);
            for (Method method : methods) {
                Class[] parameterTypes = method.getParameterTypes();
            }
        }
    }

    public static List<Method> getMethodsAnnotatedWith(final Class<?> klass, final Class<? extends Annotation> annotation) {
        final List<Method> methods = new ArrayList<Method>();
        if (klass != Object.class) {
            final List<Method> allMethods = new ArrayList<Method>(Arrays.asList(klass.getDeclaredMethods()));
            for (final Method method : allMethods) {
                if (method.isAnnotationPresent(annotation)) {
                    methods.add(method);
                }
            }
        }
        return methods;
    }

    public static List<Field> getFieldsAnnotatedWith(final Class<?> klass, final Class<? extends Annotation> annotation) {
        final List<Field> fields = new ArrayList<Field>();
        for (Class<?> type = klass; type != Object.class; type = klass.getSuperclass()) {
            final List<Field> allFields = new ArrayList<Method>(Arrays.asList(klass.getDeclaredFields());
            for (final Field field : allFields) {
                if (field.isAnnotationPresent(annotation)) {
                    fields.add(field);
                }
            }
        }
        return fields;
    }
}
