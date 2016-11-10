package org.smartea.example.beaker.fr.team.form;

import wang.yanjiong.beaker.combi.cubes.basic.api.id.RequestID;
import wang.yanjiong.beaker.combi.cubes.basic.api.id.TransactionID;

/**
 * Created by WangYanJiong on 11/10/16.
 */
public class NewMate {

    @RequestID
    private String orderId;

    @TransactionID
    private String sessionId;
}
