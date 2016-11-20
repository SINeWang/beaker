package wang.yanjiong.beaker.combi.cubes.basic.api;

import wang.yanjiong.beaker.combi.cubes.basic.Action;
import wang.yanjiong.beaker.combi.cubes.basic.Commit;

/**
 * Created by WangYanJiong on 11/11/16.
 */
public class Transaction extends Action {

    private String id;

    public Transaction(Commit process, String id) {
        super(process);
        this.id = id;
    }
}
