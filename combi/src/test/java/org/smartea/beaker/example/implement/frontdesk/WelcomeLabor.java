package org.smartea.beaker.example.implement.frontdesk;

import org.smartea.beaker.example.regulation.frontdesk.api.WelcomeRegulation;
import org.smartea.beaker.example.regulation.frontdesk.entity.AccessCard;
import org.smartea.beaker.example.regulation.frontdesk.entity.AccessDenied;
import org.smartea.beaker.example.regulation.frontdesk.entity.Guest;

/**
 * Created by WangYanJiong on 10/11/2016.
 */
public class WelcomeLabor implements WelcomeRegulation {

    public Object method2(Object object) {
        return null;
    }

    public AccessCard method1(Guest guest) throws AccessDenied {
        AccessCard accessCard = new AccessCard();
        accessCard.setUserName(guest.getFullName());
        return accessCard;
    }
}
