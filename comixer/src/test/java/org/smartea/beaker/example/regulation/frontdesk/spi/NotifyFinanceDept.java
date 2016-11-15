package org.smartea.beaker.example.regulation.frontdesk.spi;

import wang.yanjiong.beaker.combi.cubes.sync.spi.Timeout;

/**
 * Created by WangYanJiong on 13/11/2016.
 */

public interface NotifyFinanceDept {

    @Timeout(seconds = 100)
    void tell();
}
