package wang.yanjiong.beaker.combi.cubes.basic.api;

import wang.yanjiong.beaker.combi.cubes.basic.Action;
import wang.yanjiong.beaker.combi.cubes.basic.Process;

/**
 * Created by WangYanJiong on 11/11/16.
 */
public class Request extends Action {

    private String transactionId;

    private String requestId;

    public Request(Process process, String requestId, String transactionId) {
        super(process);
        this.requestId = requestId;
        this.transactionId = transactionId;
    }
}
