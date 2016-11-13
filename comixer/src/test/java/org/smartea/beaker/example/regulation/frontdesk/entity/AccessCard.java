package org.smartea.beaker.example.regulation.frontdesk.entity;

import wang.yanjiong.beaker.combi.droplets.Droplets;

/**
 * Created by WangYanJiong on 10/11/2016.
 */
public class AccessCard extends Droplets {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isValid() {
        return false;
    }
}
