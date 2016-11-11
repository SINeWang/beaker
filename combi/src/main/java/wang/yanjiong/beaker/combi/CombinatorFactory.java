package wang.yanjiong.beaker.combi;

import wang.yanjiong.beaker.combi.cubes.basic.exception.FailedReason;

/**
 * Created by WangYanJiong on 11/11/16.
 */
public class CombinatorFactory<T extends Combinator> {

    public T buildCombinator(Class<T> klass) throws FailedReason {
        try {
            T t = klass.newInstance();
            return t;
        } catch (InstantiationException e) {
            throw new FailedReason();
        } catch (IllegalAccessException e) {
            throw new FailedReason();
        }
    }
}
