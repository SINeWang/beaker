package org.smartea.beaker.example.frontdesk.api;

import org.smartea.beaker.example.frontdesk.api.dai.FreshManStorage;
import org.smartea.beaker.example.frontdesk.core.fi.AccessCardBuilderProcess;
import org.smartea.beaker.example.regulation.frontdesk.api.Welcome;
import org.smartea.beaker.example.regulation.frontdesk.core.dai.FreshManRepository;
import org.smartea.beaker.example.regulation.frontdesk.core.dict.MakeAccessCardFailedReason;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.AccessCard;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.AccessDenied;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.Employee;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.Guest;
import org.smartea.beaker.example.regulation.frontdesk.core.fi.AccessCardBuilder;

/**
 * Created by WangYanJiong on 10/11/2016.
 */
public class WelcomeProcess implements Welcome {

    private FreshManRepository freshManRepository = new FreshManStorage();

    private AccessCardBuilder accessCardBuilder = new AccessCardBuilderProcess();

    public AccessCard method1(Guest guest) throws AccessDenied {
        if (freshManRepository.isFreshMan(guest)) {
            try {
                Employee employee = freshManRepository.getFreshMan(guest);
                return accessCardBuilder.make(employee);
            } catch (MakeAccessCardFailedReason buildAccessCardFailedReason) {
                throw new AccessDenied();
            }
        } else {
            try {
                return accessCardBuilder.make(guest);
            } catch (MakeAccessCardFailedReason makeAccessCardFailedReason) {
                throw new AccessDenied();
            }
        }

    }
}
