package wang.yanjiong.beaker.combi.cubes.basic.api;

import wang.yanjiong.beaker.combi.cubes.basic.Action;
import wang.yanjiong.beaker.combi.cubes.basic.Process;

/**
 * Created by WangYanJiong on 11/11/16.
 */
public class Response extends Action {

    private Object result;

    public Response(Process process, Object result) {
        super(process);
        this.result = result;
    }

    public <T> T getResult() {
        return (T) result;
    }
}
