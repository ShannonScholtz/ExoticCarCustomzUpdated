package za.ac.cput.ExoticCarCustomz.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ExoticCarCustomz.App;
import za.ac.cput.ExoticCarCustomz.domain.SalesInvoice;

import java.util.ArrayList;

/**
 * Created by student on 2015/07/30.
 */
@SpringApplicationConfiguration(
        classes = {App.class}
)
@WebAppConfiguration
public class SalesInvoiceCRUDTest extends AbstractTestNGSpringContextTests {


    private Long id;
    @Autowired
    SalesInvoiceRepository repository;

    public SalesInvoiceCRUDTest() {
    }

    @Test
    public void create() throws Exception {

        SalesInvoice salesInvoice = (new SalesInvoice.Builder("22-06-2015").amount(12000.00).build());
        this.repository.save(salesInvoice);
        this.id = salesInvoice.getId();
        Assert.assertNotNull(salesInvoice.getId());
    }

    @Test(
            dependsOnMethods = {"create"}
    )
    public void read() throws Exception {
        SalesInvoice salesInvoice = (SalesInvoice)this.repository.findOne(this.id);
        Assert.assertNotNull(salesInvoice);
        Assert.assertEquals("22-06-2015", salesInvoice.getDate());
    }

    @Test(
            dependsOnMethods = {"read"}
    )
    public void update() throws Exception {
        SalesInvoice salesInvoice = (SalesInvoice)this.repository.findOne(this.id);
        SalesInvoice newSalesInvoice =  new SalesInvoice.Builder(salesInvoice.getDate()).copy(salesInvoice).amount(13000.00).build();
        this.repository.save(newSalesInvoice);
        SalesInvoice updatedSalesInvoice = (SalesInvoice)this.repository.findOne(this.id);
        Assert.assertEquals(13000.00, updatedSalesInvoice.getAmount(), 0.2f);
    }

    @Test(
            dependsOnMethods = {"update"}
    )
    public void delete() throws Exception {
        SalesInvoice salesInvoice = (SalesInvoice)this.repository.findOne(this.id);
        this.repository.delete(salesInvoice);
        SalesInvoice deletedSalesInvoice = (SalesInvoice)this.repository.findOne(this.id);
        Assert.assertNull(deletedSalesInvoice);
    }
}
