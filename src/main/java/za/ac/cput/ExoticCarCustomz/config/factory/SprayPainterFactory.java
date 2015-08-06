package za.ac.cput.ExoticCarCustomz.config.factory;

import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.domain.SprayPainter;

import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
public class SprayPainterFactory {

    public static SprayPainter createSprayPainter(String firstName, String lastName, int hours, double rate, String PainterType, List<ServiceSheet> serviceSheet)
    {
        SprayPainter sprayPainter = new SprayPainter.Builder(lastName).firstName(firstName).hours(hours).rate(rate).PainterType(PainterType).serviceSheet(serviceSheet).build();

        return sprayPainter;
    }
}
