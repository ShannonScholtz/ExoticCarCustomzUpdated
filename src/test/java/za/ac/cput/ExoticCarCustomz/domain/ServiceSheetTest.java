package za.ac.cput.ExoticCarCustomz.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.ExoticCarCustomz.config.factory.ServiceSheetFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/31.
 */
public class ServiceSheetTest {

    @Test
    public void testCreate() throws Exception
    {
        List<PartsUsed> partsUsed = new ArrayList();

        ServiceSheet serviceSheet = ServiceSheetFactory.createServiceSheet("1334", 8, partsUsed);

        Assert.assertEquals("1334", serviceSheet.getServiceNumber());
        Assert.assertEquals(8, serviceSheet.getPeriodWorkedOn());
    }

    @Test
    public void testUpdate() throws Exception
    {
        List<PartsUsed> partsUsed = new ArrayList();

        ServiceSheet serviceSheet = ServiceSheetFactory.createServiceSheet("1334", 8, partsUsed);

        ServiceSheet newServiceSheet = new ServiceSheet.Builder(serviceSheet.getServiceNumber()).copy(serviceSheet).PeriodWorkedOn(6).build();

        Assert.assertEquals(6, newServiceSheet.getPeriodWorkedOn());
        Assert.assertEquals(8, serviceSheet.getPeriodWorkedOn());
    }
}
