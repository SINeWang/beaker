package wang.yanjiong.beaker.combi;

/**
 * Created by WangYanJiong on 11/11/16.
 */
public class CombinatorFactory<T extends Combinator> {

    public T buildCombinator(Class<T> klass)  {
        try {
            T t = klass.newInstance();
            return t;
        } catch (InstantiationException e) {
            throw new IllegalArgumentException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
