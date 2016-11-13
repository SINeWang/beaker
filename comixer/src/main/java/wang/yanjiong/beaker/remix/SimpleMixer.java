package wang.yanjiong.beaker.remix;

import wang.yanjiong.beaker.combi.droplets.Concept;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangYanJiong on 12/11/2016.
 */
public class SimpleMixer implements Mixer {

    public Method getMethodAnnotatedWith(final Class<?> klass, final Class<? extends Annotation> annotation) {
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

    public <T> T fillWithConcepts(Object object, final Object[] droplets) {
        if (object.getClass() == Object.class) {
            return (T) object;
        } else {
            if (object.getClass().isPrimitive()) {
                return (T) object;
            }
        }
        try {
            Object instance = object;
            Class clazz = object.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                if (field.getAnnotation(Concept.class) != null) {
                    field.setAccessible(true);
                    if (field.get(instance) == null) {
                        Object value = getValueFromDropletsWithAnnotation(field, droplets);
                        field.set(object, value);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (T) object;
    }

    public Object getOneFieldsAnnotatedWithConcept(final Class<?> klass, String namespace, String name, final Object droplet) {
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

    public List<Field> getAllFieldsAnnotated(final Class<?> klass, final Class<? extends Annotation> annotation) {
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

    public Field getOneFieldAnnotatedWith(final Class<?> klass, final Class<? extends Annotation> annotation) {
        for (Class<?> type = klass; type != Object.class; type = klass.getSuperclass()) {
            final Field[] allFields = klass.getDeclaredFields();
            if (allFields.length > 1) {
                throw new IllegalArgumentException();
            }
            if (allFields.length == 0) {
                throw new IllegalArgumentException();
            } else {
                if (allFields[0].getAnnotation(annotation) == null) {
                    throw new IllegalArgumentException();
                }
                return allFields[0];
            }
        }
        throw new IllegalArgumentException();
    }

    public Object getValueFromDropletsWithAnnotation(Field field, Object[] droplets) {
        Concept concept = field.getAnnotation(Concept.class);
        String namespace = concept.namespace();
        String name = concept.name();
        for (Object droplet : droplets) {
            Object value = getOneFieldsAnnotatedWithConcept(droplet.getClass(), namespace, name, droplet);
            return value;
        }
        throw new IllegalArgumentException();
    }

}
