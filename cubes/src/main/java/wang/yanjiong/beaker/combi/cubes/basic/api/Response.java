package wang.yanjiong.beaker.combi.cubes.basic.api;

import wang.yanjiong.beaker.combi.cubes.basic.Action;
import wang.yanjiong.beaker.combi.cubes.basic.Commit;

/**
 * Created by WangYanJiong on 11/11/16.
 */
public class Response extends Action {

    private Object result;

    private boolean success;

    public Response(Commit commit, boolean success, Object result) {
        super(commit);
        this.result = result;
    }

    public <T> T getResult() {
        return (T) result;
    }

    public boolean isSuccess() {
        return success;
    }
}
