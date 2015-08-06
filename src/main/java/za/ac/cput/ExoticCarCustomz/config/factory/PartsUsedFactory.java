package za.ac.cput.ExoticCarCustomz.config.factory;

import za.ac.cput.ExoticCarCustomz.domain.PartsUsed;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;

import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
public class PartsUsedFactory {


    public static PartsUsed createPartsUsed(String partNumber, String description, double price)
    {
        PartsUsed partsUsed = new PartsUsed.Builder(partNumber).description(description).price(price).build();

        return partsUsed;
    }
}
