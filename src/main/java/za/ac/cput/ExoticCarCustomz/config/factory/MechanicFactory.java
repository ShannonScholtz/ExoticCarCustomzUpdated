package za.ac.cput.ExoticCarCustomz.config.factory;

import za.ac.cput.ExoticCarCustomz.domain.Mechanic;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;

import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
public class MechanicFactory {


    public static Mechanic createMechanic(String firstName, String lastName, int hours, double rate, String mechanicType, List<ServiceSheet> serviceSheet)
    {
        Mechanic mechanic = new Mechanic.Builder(lastName).firstName(firstName).hours(hours).rate(rate).mechanicType(mechanicType).serviceSheet(serviceSheet).build();

        return mechanic;
    }
}


