package org.smartea.example.beaker.fr;

import org.smartea.example.beaker.fr.entity.Order;
import org.smartea.example.beaker.fr.dict.OrderStatus;
import org.smartea.example.beaker.fr.form.OrderForm;
import org.smartea.example.beaker.fr.reciept.OrderReceipt;
import wang.yanjiong.beaker.cube.Cube;
import wang.yanjiong.beaker.cube.api.basic.Query;
import wang.yanjiong.beaker.cube.api.basic.Status;
import wang.yanjiong.beaker.cube.api.pr.Process;
import wang.yanjiong.beaker.cube.api.pr.Recall;

/**
 * Created by WangYanJiong on 11/10/16.
 */
@Cube
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
