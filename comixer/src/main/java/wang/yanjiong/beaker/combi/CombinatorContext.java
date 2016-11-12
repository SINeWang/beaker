package wang.yanjiong.beaker.combi;

import wang.yanjiong.beaker.combi.cubes.basic.api.Request;
import wang.yanjiong.beaker.combi.cubes.basic.api.Response;
import wang.yanjiong.beaker.combi.cubes.basic.api.Transaction;
import wang.yanjiong.beaker.combi.cubes.basic.api.id.RequestId;
import wang.yanjiong.beaker.combi.cubes.basic.api.id.TransactionId;
import wang.yanjiong.beaker.combi.cubes.basic.spi.Forward;
import wang.yanjiong.beaker.combi.cubes.basic.spi.Reply;
import wang.yanjiong.beaker.remix.Mixer;
import wang.yanjiong.beaker.remix.SimpleMixer;

import java.lang.reflect.Field;

/**
 * Created by WangYanJiong on 12/11/2016.
 */
public abstract class CombinatorContext extends CombinatorBoundary{


    protected Mixer mixer;

    protected Object[] droplets;

    public CombinatorContext(Object[] droplets) {
        super();
        this.mixer = new SimpleMixer();
        this.droplets = droplets;
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

    private void buildIncomingContext() {
        String transactionId = null;
        for (Object droplet : droplets) {
            Field field = mixer.getOneFieldAnnotatedWith(droplet.getClass(), TransactionId.class);
            try {
                Object value = field.get(droplet);
                transactionId = (String) value;
                transaction = new Transaction(this.process, transactionId);
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException();
            }
        }

        for (Object droplet : droplets) {
            Field field = mixer.getOneFieldAnnotatedWith(droplet.getClass(), RequestId.class);
            try {
                Object value = field.get(droplet);
                String requestId = (String) value;
                request = new Request(this.process, requestId, transactionId);
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException();
            }
        }
    }




}
