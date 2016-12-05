package org.smartea.beaker.example.regulation.frontdesk.core.dai;

import org.smartea.beaker.example.regulation.frontdesk.core.entity.Employee;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.Guest;

/**
 * Created by WangYanJiong on 13/11/2016.
 */
public interface FreshManRepository {

    boolean isFreshMan(Guest guest);

    Employee getFreshMan(Guest guest);
}
