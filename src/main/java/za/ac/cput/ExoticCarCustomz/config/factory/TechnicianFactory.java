package za.ac.cput.ExoticCarCustomz.config.factory;

import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.domain.Technician;

import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
public class TechnicianFactory {

    public static Technician createTechnician(String firstName, String lastName, int hours, double rate, String soundInstalls, List<ServiceSheet> serviceSheet)
    {
        Technician technician = new Technician.Builder(lastName).firstName(firstName).hours(hours).rate(rate).soundInstalls(soundInstalls).serviceSheet(serviceSheet).build();

        return technician;
    }
}
