package org.smartea.beaker.example.regulation.frontdesk.entity;

import wang.yanjiong.beaker.combi.droplets.Concept;

/**
 * Created by WangYanJiong on 11/11/16.
 */
public class IdentityCard {

    @Concept(namespace = "default", name = "name", version = "1")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
