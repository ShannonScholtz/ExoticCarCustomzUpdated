package za.ac.cput.ExoticCarCustomz.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.ExoticCarCustomz.config.factory.MechanicFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/31.
 */
public class MechanicTest {

    @Test
    public void testCreate() throws Exception
    {
        List<ServiceSheet> serviceSheet = new ArrayList();

        Mechanic mechanic = MechanicFactory.createMechanic("Rawoot", "Faizel", 8, 124.000, "Crankshaft specialist", serviceSheet);

        Assert.assertEquals("Faizel", mechanic.getLastName());
        Assert.assertEquals("Rawoot", mechanic.getFirstName());
        Assert.assertEquals(8, mechanic.getHours());
        Assert.assertEquals(124.000, mechanic.getRate(), 0.2f);
        Assert.assertEquals("Crankshaft specialist", mechanic.getMechanicType());
    }

    @Test
    public void testUpdate() throws Exception
    {
        List<ServiceSheet> serviceSheet = new ArrayList();

        Mechanic mechanic = MechanicFactory.createMechanic("Rawoot", "Faizel", 8, 124.000, "Crankshaft specialist", serviceSheet);

        Mechanic newMechanic = new Mechanic.Builder(mechanic.getLastName()).copy(mechanic).rate(500.00).build();

        Assert.assertEquals(500.00, newMechanic.getRate(), 0.2f);
        Assert.assertEquals(124.000, mechanic.getRate(), 0.2f);
    }
}
