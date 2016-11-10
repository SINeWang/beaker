package org.smartea.example.beaker.fr.frontdesk;

import org.smartea.example.beaker.fr.team.dict.OrderStatus;
import org.smartea.example.beaker.fr.team.entity.Order;
import org.smartea.example.beaker.fr.team.form.NewMate;
import org.smartea.example.beaker.fr.team.reciept.OrderReceipt;
import wang.yanjiong.beaker.combi.cubes.basic.api.Query;
import wang.yanjiong.beaker.combi.cubes.basic.api.Status;
import wang.yanjiong.beaker.combi.cubes.sync.SyncCube;
import wang.yanjiong.beaker.combi.cubes.sync.api.pr.Process;
import wang.yanjiong.beaker.combi.cubes.sync.api.pr.Recall;

/**
 * Created by WangYanJiong on 11/10/16.
 */
@SyncCube
public interface MateEntry {

    @Process
    OrderReceipt method1(NewMate orderForm);

    @Recall
    Object method2(Object object);

    @Query
    Order method3(Object object);

    @Status
    OrderStatus method4(Object object);

}
