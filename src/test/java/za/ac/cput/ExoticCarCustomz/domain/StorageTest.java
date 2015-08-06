package za.ac.cput.ExoticCarCustomz.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.ExoticCarCustomz.config.factory.StorageFactory;

/**
 * Created by student on 2015/08/04.
 */
public class StorageTest {

    @Test
    public void testCreate() throws Exception
    {

        Storage storage = StorageFactory.createStorage("CA 1233453", "VW", "Golf 1", "Gun Metal Grey", "2009", 2, 2000.00, 4000.00);

        Assert.assertEquals("CA 1233453", storage.getRegistrationNumber());
        Assert.assertEquals("VW", storage.getMake());
        Assert.assertEquals("Golf 1", storage.getModel());
        Assert.assertEquals("Gun Metal Grey", storage.getColour());
        Assert.assertEquals("2009", storage.getYear());
        Assert.assertEquals(2, storage.getStoragePeriodInMonths(), .0f);
        Assert.assertEquals(2000.00, storage.getMonthlyStorageCost(), 0.2f);
        Assert.assertEquals(4000.00, storage.getTotalStorageCost(), 0.2f);
    }

    @Test
    public void testUpdate() throws Exception
    {
        Storage storage = StorageFactory.createStorage("CA 1233453", "VW", "Golf 1", "Gun Metal Grey", "2009", 2, 2000.00, 4000.00);

        Storage newStorage = new Storage.Builder(storage.getRegistrationNumber()).copy(storage).Model("Golf 2 GTI").build();

        Assert.assertEquals("Golf 2 GTI", newStorage.getModel());
        Assert.assertEquals("Gun Metal Grey", storage.getColour());
    }
}
