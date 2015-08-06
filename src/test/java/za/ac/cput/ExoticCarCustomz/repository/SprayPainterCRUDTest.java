package za.ac.cput.ExoticCarCustomz.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ExoticCarCustomz.App;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.domain.SprayPainter;

import java.util.ArrayList;

/**
 * Created by student on 2015/07/30.
 */
@SpringApplicationConfiguration(
        classes = {App.class}
)
@WebAppConfiguration
public class SprayPainterCRUDTest extends AbstractTestNGSpringContextTests {


    private Long id;
    @Autowired
    SprayPainterRepository repository;

    public SprayPainterCRUDTest() {
    }

    @Test
    public void create() throws Exception {
        ArrayList service = new ArrayList();

        ServiceSheet servSheet = (new ServiceSheet.Builder("20150407").PeriodWorkedOn(2).partsUsed(null).build());
        service.add(servSheet);

        SprayPainter sprayPainter = new SprayPainter.Builder("Jackal").firstName("John").hours(8).rate(150.00).PainterType("Custom Air-Brush Car Art").serviceSheet(service).build();
        this.repository.save(sprayPainter);
        this.id = sprayPainter.getId();
        Assert.assertNotNull(sprayPainter.getId());
    }

    @Test(
            dependsOnMethods = {"create"}
    )
    public void read() throws Exception {
        SprayPainter sprayPainter  = (SprayPainter)this.repository.findOne(this.id);
        Assert.assertNotNull(sprayPainter);
        Assert.assertEquals("John", sprayPainter.getFirstName());
        Assert.assertEquals("Custom Air-Brush Car Art", sprayPainter.PainterType());
    }

    @Test(
            dependsOnMethods = {"read"}
    )
    public void update() throws Exception {
        SprayPainter sprayPainter  = (SprayPainter)this.repository.findOne(this.id);
        SprayPainter newSprayPainter =  new SprayPainter.Builder(sprayPainter.getLastName()).copy(sprayPainter).PainterType("Full Body Blast Over").build();
        this.repository.save(newSprayPainter);
        SprayPainter updatedSprayPainter = (SprayPainter)this.repository.findOne(this.id);
        Assert.assertEquals("Full Body Blast Over", updatedSprayPainter.PainterType());
    }

    @Test(
            dependsOnMethods = {"update"}
    )
    public void delete() throws Exception {
        SprayPainter sprayPainter  = (SprayPainter)this.repository.findOne(this.id);
        this.repository.delete(sprayPainter);
        SprayPainter deletedSprayPainter = (SprayPainter)this.repository.findOne(this.id);
        Assert.assertNull(deletedSprayPainter);
    }
}
