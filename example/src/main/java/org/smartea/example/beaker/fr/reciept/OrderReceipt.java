package org.smartea.example.beaker.fr.reciept;

import wang.yanjiong.beaker.cube.id.RequestID;
import wang.yanjiong.beaker.cube.id.ResponseID;
import wang.yanjiong.beaker.cube.id.TransactionID;

/**
 * Created by WangYanJiong on 11/10/16.
 */
public class OrderReceipt {

    @RequestID
    private String orderId;

    @TransactionID
    private String sessionId;

    @ResponseID
    private String responseId;
}
