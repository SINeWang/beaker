package org.smartea.beaker.example.regulation.finance.api;

import org.smartea.beaker.example.regulation.finance.dict.BindAccountReceipt;
import org.smartea.beaker.example.regulation.frontdesk.entity.AccessDenied;
import org.smartea.beaker.example.regulation.frontdesk.entity.Guest;
import wang.yanjiong.beaker.combi.cubes.sync.SyncCube;
import wang.yanjiong.beaker.combi.cubes.sync.api.nc.Normal;

/**
 * Created by WangYanJiong on 13/11/2016.
 */
@SyncCube
public interface BindAccountRecept {

    @Normal
    BindAccountReceipt  method1(Guest guest) throws AccessDenied;

}
