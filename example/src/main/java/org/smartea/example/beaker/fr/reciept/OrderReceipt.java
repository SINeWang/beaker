package org.smartea.example.beaker.fr.reciept;


import wang.yanjiong.beaker.cube.api.id.RequestID;
import wang.yanjiong.beaker.cube.api.id.ResponseID;
import wang.yanjiong.beaker.cube.api.id.TransactionID;

/**
 * Created by WangYanJiong on 11/10/16.
 */
public class OrderReceipt {

    @RequestID
    private String id1;

    @TransactionID
    private String id2;

    @ResponseID
    private String id3;
}
