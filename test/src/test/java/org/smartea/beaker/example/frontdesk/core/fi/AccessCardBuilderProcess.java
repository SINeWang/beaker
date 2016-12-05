package org.smartea.beaker.example.frontdesk.core.fi;

import org.smartea.beaker.example.regulation.frontdesk.core.dict.MakeAccessCardFailedReason;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.AccessCard;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.Employee;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.Guest;
import org.smartea.beaker.example.regulation.frontdesk.core.fi.AccessCardBuilder;
import wang.yanjiong.beaker.remix.Mixer;
import wang.yanjiong.beaker.remix.SimpleMixer;

/**
 * Created by WangYanJiong on 13/11/2016.
 */
public class AccessCardBuilderProcess implements AccessCardBuilder {


    private Mixer mixer = new SimpleMixer();

    public AccessCard make(Guest guest) throws MakeAccessCardFailedReason {
        AccessCard accessCard = new AccessCard();
        accessCard.setUserName(guest.getFullName());
        return accessCard;
    }

    public AccessCard make(Employee employee) throws MakeAccessCardFailedReason {
        AccessCard accessCard = mixer.fillWithConcepts(new AccessCard(), new Object[]{employee});
        return accessCard;
    }
}
