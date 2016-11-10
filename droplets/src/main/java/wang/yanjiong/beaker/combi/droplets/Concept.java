package wang.yanjiong.beaker.combi.droplets;

/**
 * Created by WangYanJiong on 11/10/16.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface Concept {
    String namespace();

    String name();

    String version();
}
