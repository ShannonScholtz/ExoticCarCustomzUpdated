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
public class PartsUsedCRUDTest extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    PartsUsedRepository repository;

    public PartsUsedCRUDTest() {
    }

    @Test
    public void create() throws Exception {

        PartsUsed partsUsed = new PartsUsed.Builder("TBOK0400").description("turbo k04").price(12499.99).build();
        this.repository.save(partsUsed);
        this.id = partsUsed.getId();
        Assert.assertNotNull(partsUsed.getId());
    }

    @Test(
            dependsOnMethods = {"create"}
    )
    public void read() throws Exception {
        PartsUsed partsUsed = (PartsUsed)this.repository.findOne(this.id);
        Assert.assertNotNull(partsUsed);
        Assert.assertEquals("TBOK0400", partsUsed.getPartNumber());
        Assert.assertEquals("turbo k04", partsUsed.getDescription());
    }

    @Test(
            dependsOnMethods = {"read"}
    )
    public void update() throws Exception {
        PartsUsed partsUsed = (PartsUsed)this.repository.findOne(this.id);
        PartsUsed newPartsUsed =  new PartsUsed.Builder(partsUsed.getPartNumber()).copy(partsUsed).price(20000.00).build();
        this.repository.save(newPartsUsed);
        PartsUsed updatedPartsUsed = (PartsUsed)this.repository.findOne(this.id);
        Assert.assertEquals(20000.00, updatedPartsUsed.getPrice(),0.2f);
    }

    @Test(
            dependsOnMethods = {"update"}
    )
    public void delete() throws Exception {
        PartsUsed partsUsed = (PartsUsed)this.repository.findOne(this.id);
        this.repository.delete(partsUsed);
        PartsUsed deletedPartsUsed = (PartsUsed)this.repository.findOne(this.id);
        Assert.assertNull(deletedPartsUsed);
    }
}
