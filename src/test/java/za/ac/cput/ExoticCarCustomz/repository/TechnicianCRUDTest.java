package za.ac.cput.ExoticCarCustomz.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ExoticCarCustomz.App;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.domain.Technician;

import java.util.ArrayList;

/**
 * Created by student on 2015/07/30.
 */
@SpringApplicationConfiguration(
        classes = {App.class}
)
@WebAppConfiguration
public class TechnicianCRUDTest extends AbstractTestNGSpringContextTests {


    private Long id;
    @Autowired
    TechnicianRepository repository;

    public TechnicianCRUDTest() {
    }

    @Test
    public void create() throws Exception {
        ArrayList service = new ArrayList();

        ServiceSheet servSheet = (new ServiceSheet.Builder("20150407").PeriodWorkedOn(2).partsUsed(null).build());
        service.add(servSheet);

        Technician technician = new Technician.Builder("Faizel").firstName("Jabaar").hours(8).rate(112.00).soundInstalls("DVD Screen, 6x9s and subwoofer").serviceSheet(service).build();
        this.repository.save(technician);
        this.id = technician.getId();
        Assert.assertNotNull(technician.getId());
    }

    @Test(
            dependsOnMethods = {"create"}
    )
    public void read() throws Exception {
        Technician technician = (Technician)this.repository.findOne(this.id);
        Assert.assertNotNull(technician);
        Assert.assertEquals(112.00, technician.getRate(), 0.2f);
        Assert.assertEquals("DVD Screen, 6x9s and subwoofer", technician.getsoundInstalls());
    }

    @Test(
            dependsOnMethods = {"read"}
    )
    public void update() throws Exception {
        Technician technician = (Technician)this.repository.findOne(this.id);
        Technician newTechnician =  new Technician.Builder(technician.getLastName()).copy(technician).firstName("Riyaaz").build();
        this.repository.save(newTechnician);
        Technician updatedTechnician = (Technician)this.repository.findOne(this.id);
        Assert.assertEquals("Riyaaz", updatedTechnician.getFirstName());
    }

    @Test(
            dependsOnMethods = {"update"}
    )
    public void delete() throws Exception {
        Technician technician = (Technician)this.repository.findOne(this.id);
        this.repository.delete(technician);
        Technician deletedTechnician = (Technician)this.repository.findOne(this.id);
        Assert.assertNull(deletedTechnician);
    }
}
