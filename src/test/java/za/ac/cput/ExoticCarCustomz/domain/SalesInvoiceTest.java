package za.ac.cput.ExoticCarCustomz.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.ExoticCarCustomz.config.factory.SalesInvoiceFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/31.
 */
public class SalesInvoiceTest {

    @Test
    public void testCreate() throws Exception
    {
        SalesInvoice salesInvoice = SalesInvoiceFactory.createSalesInvoice("23-07-2015", 12000.000);

        Assert.assertEquals("23-07-2015", salesInvoice.getDate());
        Assert.assertEquals(12000.000, salesInvoice.getAmount(), 0.2f);
    }

    @Test
    public void testUpdate() throws Exception
    {
        SalesInvoice salesInvoice = SalesInvoiceFactory.createSalesInvoice("23-07-2015", 12000.000);

        SalesInvoice newSalesInvoice = new SalesInvoice.Builder(salesInvoice.getDate()).copy(salesInvoice).amount(13000.000).build();

        Assert.assertEquals(13000.000, newSalesInvoice.getAmount(), 0.2f);
        Assert.assertEquals(12000.000, salesInvoice.getAmount(), 0.2f);
    }
}
