package wang.yanjiong.beaker.combi;

import wang.yanjiong.beaker.combi.cubes.basic.Commit;
import wang.yanjiong.beaker.combi.cubes.basic.api.Request;
import wang.yanjiong.beaker.combi.cubes.basic.api.Response;
import wang.yanjiong.beaker.combi.cubes.basic.api.Transaction;
import wang.yanjiong.beaker.combi.cubes.basic.spi.Forward;
import wang.yanjiong.beaker.combi.cubes.basic.spi.Reply;
import wang.yanjiong.beaker.remix.Mixer;

/**
 * Created by WangYanJiong on 12/11/2016.
 */
public abstract class CombinatorBoundary {

    protected Transaction transaction;

    protected Request request;

    protected Response response;

    protected Commit process;

    protected Mixer mixer;

    protected Object[] droplets;

    public CombinatorBoundary() {
        this.process = new Commit();
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
        return new Forward[0];
    }

    public Reply[] getReplies() {
        return new Reply[0];
    }

}
