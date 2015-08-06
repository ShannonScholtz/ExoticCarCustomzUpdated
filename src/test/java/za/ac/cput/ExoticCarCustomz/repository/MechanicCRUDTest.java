package za.ac.cput.ExoticCarCustomz.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ExoticCarCustomz.App;
import za.ac.cput.ExoticCarCustomz.domain.Mechanic;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;

import java.util.ArrayList;

/**
 * Created by student on 2015/07/30.
 */
@SpringApplicationConfiguration(
        classes = {App.class}
)
@WebAppConfiguration
public class MechanicCRUDTest  extends AbstractTestNGSpringContextTests {


    private Long id;
    @Autowired
    MechanicRepository repository;

    public MechanicCRUDTest() {
    }

    @Test
    public void create() throws Exception {
        ArrayList service = new ArrayList();

        ServiceSheet servSheet = (new ServiceSheet.Builder("14221").PeriodWorkedOn(8).partsUsed(null).build());
        service.add(servSheet);

        Mechanic mechanic = new Mechanic.Builder("Peters").firstName("Scott").hours(8).rate(100.00).mechanicType("Diesel").serviceSheet(service).build();
        this.repository.save(mechanic);
        this.id = mechanic.getId();
        Assert.assertNotNull(mechanic.getId());
    }

    @Test(
            dependsOnMethods = {"create"}
    )
    public void read() throws Exception {
        Mechanic mechanic = (Mechanic)this.repository.findOne(this.id);
        Assert.assertNotNull(mechanic);
        Assert.assertEquals("Scott", mechanic.getFirstName());
        Assert.assertEquals("Peters", mechanic.getLastName());
    }

    @Test(
            dependsOnMethods = {"read"}
    )
    public void update() throws Exception {
        Mechanic mechanic = (Mechanic)this.repository.findOne(this.id);
        Mechanic newMechanic =  new Mechanic.Builder(mechanic.getLastName()).copy(mechanic).rate(120.99).build();
        this.repository.save(newMechanic);
        Mechanic updatedMechanic = (Mechanic)this.repository.findOne(this.id);
        Assert.assertEquals(120.99, updatedMechanic.getRate(),0.2f);
    }

    @Test(
            dependsOnMethods = {"update"}
    )
    public void delete() throws Exception {
        Mechanic mechanic = (Mechanic)this.repository.findOne(this.id);
        this.repository.delete(mechanic);
        Mechanic deletedMechanic = (Mechanic)this.repository.findOne(this.id);
        Assert.assertNull(deletedMechanic);
    }
}
