package org.smartea.example.beaker.fr;

import org.smartea.example.beaker.fr.entity.Order;
import org.smartea.example.beaker.fr.dict.OrderStatus;
import org.smartea.example.beaker.fr.form.OrderForm;
import org.smartea.example.beaker.fr.reciept.OrderReceipt;
import wang.yanjiong.beaker.cubes.sync.SyncCube;
import wang.yanjiong.beaker.cubes.basic.api.Query;
import wang.yanjiong.beaker.cubes.basic.api.Status;
import wang.yanjiong.beaker.cubes.sync.api.pr.Process;
import wang.yanjiong.beaker.cubes.sync.api.pr.Recall;

/**
 * Created by WangYanJiong on 11/10/16.
 */
@SyncCube
public interface CreateOrder {

    @Process
    OrderReceipt method1(OrderForm orderForm);

    @Recall
    Object method2(Object object);

    @Query
    Order method3(Object object);

    @Status
    OrderStatus method4(Object object);

}
