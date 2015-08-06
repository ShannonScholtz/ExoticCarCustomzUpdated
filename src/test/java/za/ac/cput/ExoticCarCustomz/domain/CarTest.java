package za.ac.cput.ExoticCarCustomz.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.ExoticCarCustomz.config.factory.CarFactory;

/**
 * Created by student on 2015/07/31.
 */
public class CarTest {

    @Test
    public void testCreate() throws Exception
    {

        Car car = CarFactory.createCar("123345VW", "VW", "Golf 1", "Gun Metal Grey", "2009", null, null);

        Assert.assertEquals("123345VW", car.getSerialNumber());
        Assert.assertEquals("VW", car.getMake());
        Assert.assertEquals("Golf 1", car.getModel());
        Assert.assertEquals("Gun Metal Grey", car.getColour());
        Assert.assertEquals("2009", car.getYear());
    }

    @Test
    public void testUpdate() throws Exception
    {
        Car car = CarFactory.createCar("123345VW", "VW", "Golf 1", "Gun Metal Grey", "2009", null, null);

        Car newCar = new Car.Builder(car.getSerialNumber()).copy(car).Colour("Red").build();

        Assert.assertEquals("Red", newCar.getColour());
        Assert.assertEquals("Gun Metal Grey", car.getColour());
    }
}
