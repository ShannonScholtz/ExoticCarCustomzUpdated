package za.ac.cput.ExoticCarCustomz.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.ExoticCarCustomz.config.factory.SprayPainterFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/31.
 */
public class SprayPainterTest {

    @Test
    public void testCreate() throws Exception
    {
        List<ServiceSheet> serviceSheet = new ArrayList();

        SprayPainter sprayPainter = SprayPainterFactory.createSprayPainter("Jenna", "Jackson", 8, 200.000, "Customer Spray painter", serviceSheet);

        Assert.assertEquals("Jenna", sprayPainter.getFirstName());
        Assert.assertEquals("Jackson", sprayPainter.getLastName());
        Assert.assertEquals(8, sprayPainter.getHours());
        Assert.assertEquals(200.000, sprayPainter.getRate(), 0.2f);
        Assert.assertEquals("Customer Spray painter", sprayPainter.PainterType());
    }

    @Test
    public void testUpdate() throws Exception
    {
        List<ServiceSheet> serviceSheet = new ArrayList();

        SprayPainter sprayPainter = SprayPainterFactory.createSprayPainter("Jenna", "Jackson", 8, 200.000, "Customer Spray painter", serviceSheet);

        SprayPainter newSprayPainter = new SprayPainter.Builder(sprayPainter.getLastName()).copy(sprayPainter).firstName("Jenny").build();

        Assert.assertEquals("Jenny", newSprayPainter.getFirstName());
        Assert.assertEquals("Jenna", sprayPainter.getFirstName());
    }
}
