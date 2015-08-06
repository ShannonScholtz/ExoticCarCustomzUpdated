package za.ac.cput.ExoticCarCustomz.config.factory;

import za.ac.cput.ExoticCarCustomz.domain.PartsUsed;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;

import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
public class ServiceSheetFactory {


    public static ServiceSheet createServiceSheet(String ServiceNumber, int PeriodWorkedOn, List<PartsUsed> partsUsed)
    {
        ServiceSheet serviceSheet = new ServiceSheet.Builder(ServiceNumber).PeriodWorkedOn(PeriodWorkedOn).partsUsed(partsUsed).build();

        return serviceSheet;
    }
}
