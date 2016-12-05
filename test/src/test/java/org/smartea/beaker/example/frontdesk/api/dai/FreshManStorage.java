package org.smartea.beaker.example.frontdesk.api.dai;

import org.smartea.beaker.example.regulation.frontdesk.core.dai.FreshManRepository;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.Employee;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.Guest;

/**
 * Created by WangYanJiong on 13/11/2016.
 */
public class FreshManStorage implements FreshManRepository {
    public boolean isFreshMan(Guest guest) {
        return true;
    }

    public Employee getFreshMan(Guest guest) {
        Employee employee = new Employee();
        employee.setFullName(guest.getFullName());
        return employee;
    }
}
