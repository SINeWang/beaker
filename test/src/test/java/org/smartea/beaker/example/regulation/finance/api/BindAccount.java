package org.smartea.beaker.example.regulation.finance.api;

import org.smartea.beaker.example.regulation.finance.entity.BindAccountReceipt;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.Guest;
import wang.yanjiong.beaker.combi.cubes.sync.CCCube;
import wang.yanjiong.beaker.combi.cubes.sync.api.cc.Commit;

/**
 * Created by WangYanJiong on 13/11/2016.
 */
@CCCube
public interface BindAccount {

    @Commit
    BindAccountReceipt  method1(Guest guest);

}
