package org.smartea.beaker.example.regulation.frontdesk.api;

import org.smartea.beaker.example.regulation.frontdesk.core.entity.AccessCard;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.Guest;
import wang.yanjiong.beaker.combi.cubes.sync.CCCube;
import wang.yanjiong.beaker.combi.cubes.sync.api.cc.Commit;

/**
 * Created by WangYanJiong on 11/10/16.
 */
@CCCube
public interface Welcome {

    @Commit
    AccessCard method1(Guest guest);


}
