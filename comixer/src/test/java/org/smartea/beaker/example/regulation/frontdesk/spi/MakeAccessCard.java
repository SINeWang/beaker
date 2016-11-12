package org.smartea.beaker.example.regulation.frontdesk.spi;


import org.smartea.beaker.example.regulation.frontdesk.dict.BuildAccessCardFailedReason;
import org.smartea.beaker.example.regulation.frontdesk.entity.AccessCard;

/**
 * Created by WangYanJiong on 10/11/2016.
 */
public interface MakeAccessCard {

    AccessCard build(Object... objects) throws BuildAccessCardFailedReason;
}
