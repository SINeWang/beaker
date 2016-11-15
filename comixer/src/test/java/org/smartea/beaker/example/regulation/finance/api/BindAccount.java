package org.smartea.beaker.example.regulation.finance.api;

import org.smartea.beaker.example.regulation.finance.entity.BindAccountReceipt;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.AccessDenied;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.Guest;
import wang.yanjiong.beaker.combi.cubes.sync.SyncCube;
import wang.yanjiong.beaker.combi.cubes.sync.api.cc.Commit;

/**
 * Created by WangYanJiong on 13/11/2016.
 */
@SyncCube
public interface BindAccount {

    @Commit
    BindAccountReceipt  method1(Guest guest) throws AccessDenied;

}
