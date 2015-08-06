package za.ac.cput.ExoticCarCustomz.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.ExoticCarCustomz.config.factory.SalespersonFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/31.
 */
public class SalespersonTest {

    @Test
    public void testCreate() throws Exception
    {
        List<SalesInvoice> salesInvoices = new ArrayList();

        Salesperson salesperson = SalespersonFactory.createSalesperson("James", "Penner", 8, 120.000, 26 , salesInvoices);

        Assert.assertEquals("James", salesperson.getFirstName());
        Assert.assertEquals("Penner", salesperson.getLastName());
        Assert.assertEquals(8, salesperson.getHours());
        Assert.assertEquals(120.000, salesperson.getRate(), 0.2f);
        Assert.assertEquals(26, salesperson.getDailySales());
    }

    @Test
    public void testUpdate() throws Exception
    {
        List<SalesInvoice> salesInvoices = new ArrayList();

        Salesperson salesperson = SalespersonFactory.createSalesperson("James", "Penner", 8, 120.000, 26, salesInvoices);

        Salesperson newSalesperson = new Salesperson.Builder(salesperson.getLastName()).copy(salesperson).firstName("Jack").build();

        Assert.assertEquals("Jack", newSalesperson.getFirstName());
        Assert.assertEquals("James", salesperson.getFirstName());
    }
}
