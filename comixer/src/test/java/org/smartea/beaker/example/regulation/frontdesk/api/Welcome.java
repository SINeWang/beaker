package org.smartea.beaker.example.regulation.frontdesk.api;

import org.smartea.beaker.example.regulation.frontdesk.core.entity.AccessCard;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.AccessDenied;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.Guest;
import wang.yanjiong.beaker.combi.cubes.sync.SyncCube;
import wang.yanjiong.beaker.combi.cubes.sync.api.nc.Normal;

/**
 * Created by WangYanJiong on 11/10/16.
 */
@SyncCube
public interface Welcome {

    @Normal
    AccessCard method1(Guest guest) throws AccessDenied;


}
