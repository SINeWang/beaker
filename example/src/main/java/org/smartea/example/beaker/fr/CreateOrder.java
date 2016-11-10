package org.smartea.example.beaker.fr;

import org.smartea.example.beaker.fr.entity.Order;
import org.smartea.example.beaker.fr.dict.OrderStatus;
import org.smartea.example.beaker.fr.form.OrderForm;
import org.smartea.example.beaker.fr.reciept.OrderReceipt;
import wang.yanjiong.beaker.cube.api.Cube;
import wang.yanjiong.beaker.cube.api.basic.Query;
import wang.yanjiong.beaker.cube.api.basic.Status;
import wang.yanjiong.beaker.cube.api.fr.Forward;
import wang.yanjiong.beaker.cube.api.fr.Reverse;

/**
 * Created by WangYanJiong on 11/10/16.
 */
@Cube
public interface CreateOrder {

    @Forward
    OrderReceipt process(OrderForm orderForm);

    @Reverse
    Object recall(Object object);

    @Query
    Order retrieve(Object object);

    @Status
    OrderStatus status(Object object);

}
