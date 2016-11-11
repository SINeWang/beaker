package org.smartea.beaker.example.regulation.frontdesk.api;

import org.smartea.beaker.example.regulation.frontdesk.entity.AccessCard;
import org.smartea.beaker.example.regulation.frontdesk.entity.AccessDenied;
import org.smartea.beaker.example.regulation.frontdesk.entity.Guest;
import wang.yanjiong.beaker.combi.cubes.sync.SyncCube;
import wang.yanjiong.beaker.combi.cubes.sync.api.nr.Normal;

/**
 * Created by WangYanJiong on 11/10/16.
 */
@SyncCube
public interface WelcomeRegulation {

    @Normal
    AccessCard method1(Guest guest) throws AccessDenied;


}
