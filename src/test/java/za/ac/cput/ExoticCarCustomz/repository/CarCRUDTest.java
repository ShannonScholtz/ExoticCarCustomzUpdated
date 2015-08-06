package za.ac.cput.ExoticCarCustomz.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ExoticCarCustomz.App;
import za.ac.cput.ExoticCarCustomz.domain.Car;
import za.ac.cput.ExoticCarCustomz.domain.SalesInvoice;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
@SpringApplicationConfiguration(
        classes = {App.class}
)
@WebAppConfiguration
public class CarCRUDTest extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    CarRepository repository;

    public CarCRUDTest() {
    }

    @Test
    public void create() throws Exception {
        ArrayList invoice = new ArrayList();
        ArrayList service = new ArrayList();

        SalesInvoice SalInvoice = (new SalesInvoice.Builder("22-04-2015").amount(12000.00).build());
        invoice.add(SalInvoice);

        ServiceSheet servSheet = (new ServiceSheet.Builder("14231").PeriodWorkedOn(8).partsUsed(null).build());
        service.add(servSheet);

        Car car = new Car.Builder("VW456034").Make("VW").Model("Golf 6").Colour("White").year("2010").salesInvoice(invoice).serviceSheet(service).build();
        this.repository.save(car);
        this.id = car.getId();
        Assert.assertNotNull(car.getId());
    }

    @Test(
            dependsOnMethods = {"create"}
    )
    public void read() throws Exception {
        Car car = (Car)this.repository.findOne(this.id);
        Assert.assertNotNull(car);
        Assert.assertEquals("White", car.getColour());
        Assert.assertEquals("VW", car.getMake());
    }

    @Test(
            dependsOnMethods = {"read"}
    )
    public void update() throws Exception {
        Car car = (Car)this.repository.findOne(this.id);
        Car newCar =  new Car.Builder(car.getSerialNumber()).copy(car).Model("Golf 5").build();
        this.repository.save(newCar);
        Car updatedCar = (Car)this.repository.findOne(this.id);
        Assert.assertEquals("Golf 5", updatedCar.getModel());
    }

    @Test(
            dependsOnMethods = {"update"}
    )
    public void delete() throws Exception {
        Car car = (Car)this.repository.findOne(this.id);
        this.repository.delete(car);
        Car deletedCar = (Car)this.repository.findOne(this.id);
        Assert.assertNull(deletedCar);
    }
}
