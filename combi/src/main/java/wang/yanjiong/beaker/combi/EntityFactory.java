package wang.yanjiong.beaker.combi;

/**
 * Created by WangYanJiong on 10/11/2016.
 */
public class EntityFactory {

    public <T> T build(Class<T> target, Object... objects) {
        try {
            T t = target.newInstance();
            return t;
        } catch (InstantiationException e) {
            throw new RuntimeException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException();
        }
    }
}
