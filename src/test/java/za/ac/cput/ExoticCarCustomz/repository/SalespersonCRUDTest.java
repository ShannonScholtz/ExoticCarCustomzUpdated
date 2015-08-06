package za.ac.cput.ExoticCarCustomz.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ExoticCarCustomz.App;
import za.ac.cput.ExoticCarCustomz.domain.SalesInvoice;
import za.ac.cput.ExoticCarCustomz.domain.Salesperson;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;

import java.util.ArrayList;

/**
 * Created by student on 2015/07/30.
 */
@SpringApplicationConfiguration(
        classes = {App.class}
)
@WebAppConfiguration
public class SalespersonCRUDTest extends AbstractTestNGSpringContextTests {


    private Long id;
    @Autowired
    SalespersonRepository repository;

    public SalespersonCRUDTest() {
    }

    @Test
    public void create() throws Exception {

        ArrayList invoice = new ArrayList();

        SalesInvoice SalInvoice = (new SalesInvoice.Builder("22-04-2015").amount(12000.00).build());
        invoice.add(SalInvoice);

        Salesperson salesperson = new Salesperson.Builder("James").firstName("Joubert").hours(8).rate(120.00).DailySales(25).salesInvoice(invoice).build();
        this.repository.save(salesperson);
        this.id = salesperson.getId();
        Assert.assertNotNull(salesperson.getId());
    }

    @Test(
            dependsOnMethods = {"create"}
    )
    public void read() throws Exception {
        Salesperson salesperson = (Salesperson)this.repository.findOne(this.id);
        Assert.assertNotNull(salesperson);
        Assert.assertEquals(8, salesperson.getHours());
    }

    @Test(
            dependsOnMethods = {"read"}
    )
    public void update() throws Exception {
        Salesperson salesperson = (Salesperson)this.repository.findOne(this.id);
        Salesperson newSalesperson =  new Salesperson.Builder(salesperson.getLastName()).copy(salesperson).DailySales(50).build();
        this.repository.save(newSalesperson);
        Salesperson updatedSalesperson = (Salesperson)this.repository.findOne(this.id);
        Assert.assertEquals(50, updatedSalesperson.getDailySales());
    }

    @Test(
            dependsOnMethods = {"update"}
    )
    public void delete() throws Exception {
        Salesperson salesperson = (Salesperson)this.repository.findOne(this.id);
        this.repository.delete(salesperson);
        Salesperson deletedSalesperson = (Salesperson)this.repository.findOne(this.id);
        Assert.assertNull(deletedSalesperson);
    }
}
