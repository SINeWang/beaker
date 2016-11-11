package wang.yanjiong.beaker.combi;

import wang.yanjiong.beaker.combi.cubes.basic.api.Request;
import wang.yanjiong.beaker.combi.cubes.basic.api.Response;
import wang.yanjiong.beaker.combi.cubes.basic.api.Transaction;
import wang.yanjiong.beaker.combi.cubes.basic.spi.Forward;
import wang.yanjiong.beaker.combi.cubes.basic.spi.Reply;

import java.util.concurrent.Callable;

/**
 * Created by WangYanJiong on 11/11/16.
 */
public interface Combinator extends Callable{

    Transaction getTransaction();

    Request getRequest();

    Response getResponse();

    Forward[] getForwards();

    Reply[] getReplies();

    CombineStatus getStatus();

    FailedStrategy getStrategy();

}
