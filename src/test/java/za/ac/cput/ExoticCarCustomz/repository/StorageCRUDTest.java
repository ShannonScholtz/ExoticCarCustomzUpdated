package za.ac.cput.ExoticCarCustomz.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ExoticCarCustomz.App;
import za.ac.cput.ExoticCarCustomz.domain.Storage;

import java.util.ArrayList;

/**
 * Created by student on 2015/08/04.
 */
@SpringApplicationConfiguration(
        classes = {App.class}
)
@WebAppConfiguration
public class StorageCRUDTest extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    StorageRepository repository;

    public StorageCRUDTest() {
    }

    @Test
    public void create() throws Exception {

        Storage storage = new Storage.Builder("Shannon-WP").Make("VW").Model("Golf 6").Colour("Blue").year("2013").StoragePeriodInMonths(5).MonthlyStorageCost(2000.00).totalStorageCost(10000.00).build();
        this.repository.save(storage);
        this.id = storage.getId();
        Assert.assertNotNull(storage.getId());
    }

    @Test(
            dependsOnMethods = {"create"}
    )
    public void read() throws Exception {
        Storage storage = (Storage)this.repository.findOne(this.id);
        Assert.assertNotNull(storage);
        Assert.assertEquals("Blue", storage.getColour());
        Assert.assertEquals("VW", storage.getMake());
    }

    @Test(
            dependsOnMethods = {"read"}
    )
    public void update() throws Exception {
        Storage storage = (Storage)this.repository.findOne(this.id);
        Storage newStorage =  new Storage.Builder(storage.getRegistrationNumber()).copy(storage).Model("Golf 7").build();
        this.repository.save(newStorage);
        Storage updatedStorage = (Storage)this.repository.findOne(this.id);
        Assert.assertEquals("Golf 7", updatedStorage.getModel());
    }

    @Test(
            dependsOnMethods = {"update"}
    )
    public void delete() throws Exception {
        Storage storage = (Storage)this.repository.findOne(this.id);
        this.repository.delete(storage);
        Storage deletedCar = (Storage)this.repository.findOne(this.id);
        Assert.assertNull(deletedCar);
    }
}
