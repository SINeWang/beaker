package org.smartea.example.beaker.fr.form;

import wang.yanjiong.beaker.cube.id.RequestID;
import wang.yanjiong.beaker.cube.id.TransactionID;

/**
 * Created by WangYanJiong on 11/10/16.
 */
public class OrderForm {

    @RequestID
    private String orderId;

    @TransactionID
    private String sessionId;
}
