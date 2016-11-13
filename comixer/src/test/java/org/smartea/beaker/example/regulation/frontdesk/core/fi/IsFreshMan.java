package org.smartea.beaker.example.regulation.frontdesk.core.fi;


import org.smartea.beaker.example.regulation.frontdesk.dict.BuildAccessCardFailedReason;
import org.smartea.beaker.example.regulation.frontdesk.entity.AccessCard;

/**
 * Created by WangYanJiong on 10/11/2016.
 */
public interface IsFreshMan {

    AccessCard build(Object... objects) throws BuildAccessCardFailedReason;
}
