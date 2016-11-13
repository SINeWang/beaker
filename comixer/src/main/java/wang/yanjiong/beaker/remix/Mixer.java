package wang.yanjiong.beaker.remix;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by WangYanJiong on 12/11/2016.
 */
public interface Mixer {

    Method getMethodAnnotatedWith(final Class<?> klass, final Class<? extends Annotation> annotation);

    Object getOneFieldsAnnotatedWithConcept(final Class<?> klass, String namespace, String name, final Object droplet);

    List<Field> getAllFieldsAnnotated(final Class<?> klass, final Class<? extends Annotation> annotation);

    Field getOneFieldAnnotatedWith(final Class<?> klass, final Class<? extends Annotation> annotation);

    Object getValueFromDropletsWithAnnotation(Field field, Object[] droplets);

    <T> T fillWithConcepts(Object object, final Object[] droplets);
}