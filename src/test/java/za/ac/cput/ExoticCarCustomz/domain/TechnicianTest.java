package za.ac.cput.ExoticCarCustomz.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.ExoticCarCustomz.config.factory.TechnicianFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/31.
 */
public class TechnicianTest {

    @Test
    public void testCreate() throws Exception
    {
        List<ServiceSheet> serviceSheet = new ArrayList();

        Technician technician = TechnicianFactory.createTechnician("Peter", "Jackson", 8, 150.000, "DVD Screen in Headrest", serviceSheet);

        Assert.assertEquals("Peter", technician.getFirstName());
        Assert.assertEquals("Jackson", technician.getLastName());
        Assert.assertEquals(8, technician.getHours());
        Assert.assertEquals(150.000, technician.getRate(), 0.2f);
        Assert.assertEquals("DVD Screen in Headrest", technician.getsoundInstalls());
    }

    @Test
    public void testUpdate() throws Exception
    {
        List<ServiceSheet> serviceSheet = new ArrayList();

        Technician technician = TechnicianFactory.createTechnician("Peters", "Jackson", 8, 150.000, "DVD Screen in Headrest", serviceSheet);

        Technician newTechnician = new Technician.Builder(technician.getLastName()).copy(technician).soundInstalls("Subwoofer and amplifier").build();

        Assert.assertEquals("Subwoofer and amplifier", newTechnician.getsoundInstalls());
        Assert.assertEquals("DVD Screen in Headrest", technician.getsoundInstalls());
    }
}
