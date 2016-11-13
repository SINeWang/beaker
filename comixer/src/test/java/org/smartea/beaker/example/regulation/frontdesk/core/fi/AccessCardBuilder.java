package org.smartea.beaker.example.regulation.frontdesk.core.fi;


import org.smartea.beaker.example.regulation.frontdesk.core.dict.MakeAccessCardFailedReason;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.AccessCard;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.Employee;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.Guest;

/**
 * Created by WangYanJiong on 10/11/2016.
 */
public interface AccessCardBuilder {

    AccessCard make(Guest guest) throws MakeAccessCardFailedReason;

    AccessCard make(Employee employee) throws MakeAccessCardFailedReason;
}
