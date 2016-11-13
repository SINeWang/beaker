package org.smartea.beaker.example.regulation.frontdesk.core.entity;

import wang.yanjiong.beaker.combi.droplets.Concept;

/**
 * Created by WangYanJiong on 10/11/2016.
 */
public class Guest {

    @Concept(namespace = "default", name = "name", version = "1")
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
