package za.ac.cput.ExoticCarCustomz.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.ExoticCarCustomz.App;
import za.ac.cput.ExoticCarCustomz.domain.Customer;
import za.ac.cput.ExoticCarCustomz.domain.SalesInvoice;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.domain.Storage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
@SpringApplicationConfiguration(
        classes = {App.class}
)
@WebAppConfiguration
public class CustomerCRUDTest  extends AbstractTestNGSpringContextTests {


    private Long id;
    @Autowired
    CustomerRepository repository;

    public CustomerCRUDTest() {
    }

    @Test
    public void create() throws Exception {
        ArrayList invoice = new ArrayList();
        ArrayList service = new ArrayList();
        ArrayList storage = new ArrayList();

        SalesInvoice SalInvoice = (new SalesInvoice.Builder("12-04-2015").amount(12000.00).build());
        invoice.add(SalInvoice);

        ServiceSheet servSheet = (new ServiceSheet.Builder("14221").PeriodWorkedOn(8).partsUsed(null).build());
        service.add(servSheet);

        Storage storages = new Storage.Builder("Mr-BMW-WP").Make("BMW").Model("135i").Colour("White").year("2015").StoragePeriodInMonths(6).MonthlyStorageCost(2000.00).totalStorageCost(12000.00).build();
        storage.add(storages);

        Customer customer = new Customer.Builder("Scholtz").firstName("Shannon").phoneNumber("0834539586").Address("5 pet weg Mitchells Plain").postalCode("7785").salesInvoice(invoice).serviceSheet(service).storage(storage).build();
        this.repository.save(customer);
        this.id = customer.getId();
        Assert.assertNotNull(customer.getId());
    }

    @Test(
            dependsOnMethods = {"create"}
    )
    public void read() throws Exception {
        Customer customer = (Customer)this.repository.findOne(this.id);
        Assert.assertNotNull(customer);
        Assert.assertEquals("Shannon", customer.getFirstName());
        Assert.assertEquals("Scholtz", customer.getLastName());
    }

    @Test(
            dependsOnMethods = {"read"}
    )
    public void update() throws Exception {
        Customer customer = (Customer)this.repository.findOne(this.id);
        Customer newCustomer =  new Customer.Builder(customer.getLastName()).copy(customer).Address("5 Constantia way Durbanville").build();
        this.repository.save(newCustomer);
        Customer updatedCustomer = (Customer)this.repository.findOne(this.id);
        Assert.assertEquals("5 Constantia way Durbanville", updatedCustomer.getAddress());
    }

    @Test(
            dependsOnMethods = {"update"}
    )
    public void delete() throws Exception {
        Customer customer = (Customer)this.repository.findOne(this.id);
        this.repository.delete(customer);
        Customer deletedCustomer = (Customer)this.repository.findOne(this.id);
        Assert.assertNull(deletedCustomer);
    }
}
