package za.ac.cput.ExoticCarCustomz.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ExoticCarCustomz.App;
import za.ac.cput.ExoticCarCustomz.domain.PartsUsed;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;

import java.util.ArrayList;

/**
 * Created by student on 2015/07/30.
 */
@SpringApplicationConfiguration(
        classes = {App.class}
)
@WebAppConfiguration
public class ServiceSheetCRUDTest extends AbstractTestNGSpringContextTests {


    private Long id;
    @Autowired
    ServiceSheetRepository repository;

    public ServiceSheetCRUDTest() {
    }

    @Test
    public void create() throws Exception {

        ArrayList parts = new ArrayList();

      PartsUsed partsUsed =(new PartsUsed.Builder("NOS23444").description("NOS").price(20000.00).build());
        parts.add(partsUsed);

        ServiceSheet serviceSheet = new ServiceSheet.Builder("233421").PeriodWorkedOn(8).partsUsed(parts).build();
        this.repository.save(serviceSheet);
        this.id = serviceSheet.getId();
        Assert.assertNotNull(serviceSheet.getId());
    }

    @Test(
            dependsOnMethods = {"create"}
    )
    public void read() throws Exception {
        ServiceSheet serviceSheet = (ServiceSheet)this.repository.findOne(this.id);
        Assert.assertNotNull(serviceSheet);
        Assert.assertEquals("233421", serviceSheet.getServiceNumber());
    }

    @Test(
            dependsOnMethods = {"read"}
    )
    public void update() throws Exception {
        ServiceSheet serviceSheet = (ServiceSheet)this.repository.findOne(this.id);
        ServiceSheet newServiceSheet =  new ServiceSheet.Builder(serviceSheet.getServiceNumber()).copy(serviceSheet).PeriodWorkedOn(5).build();
        this.repository.save(newServiceSheet);
        ServiceSheet updatedServiceSheet = (ServiceSheet)this.repository.findOne(this.id);
        Assert.assertEquals(5, updatedServiceSheet.getPeriodWorkedOn());
    }

    @Test(
            dependsOnMethods = {"update"}
    )
    public void delete() throws Exception {
        ServiceSheet serviceSheet = (ServiceSheet)this.repository.findOne(this.id);
        this.repository.delete(serviceSheet);
        ServiceSheet deletedServiceSheet = (ServiceSheet)this.repository.findOne(this.id);
        Assert.assertNull(deletedServiceSheet);
    }
}
