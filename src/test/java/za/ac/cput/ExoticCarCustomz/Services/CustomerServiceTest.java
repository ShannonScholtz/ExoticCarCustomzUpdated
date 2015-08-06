package za.ac.cput.ExoticCarCustomz.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.ExoticCarCustomz.App;
import za.ac.cput.ExoticCarCustomz.config.factory.CustomerFactory;
import za.ac.cput.ExoticCarCustomz.config.factory.SalesInvoiceFactory;
import za.ac.cput.ExoticCarCustomz.config.factory.StorageFactory;
import za.ac.cput.ExoticCarCustomz.domain.Customer;
import za.ac.cput.ExoticCarCustomz.domain.SalesInvoice;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.domain.Storage;
import za.ac.cput.ExoticCarCustomz.repository.CustomerRepository;
import za.ac.cput.ExoticCarCustomz.services.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class CustomerServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private CustomerService service;
    private Long id;
    @Autowired
    private CustomerRepository repository;
    private List<SalesInvoice> salesInvoices;
    private List<ServiceSheet> serviceSheets;
    private List<Storage> storage;


    @BeforeMethod
    public void setUp() throws Exception {
        salesInvoices = new ArrayList();
        serviceSheets = new ArrayList();
        storage = new ArrayList();
    }

    @Test
    public void create() throws Exception {

        Storage storage1 = StorageFactory.createStorage("CA 1233453", "VW", "Golf 1", "Blue", "2009", 2, 2000.00, 4000.00);
        storage.add(storage1);

        SalesInvoice salesInvoices1 = SalesInvoiceFactory.createSalesInvoice("26-02-2015",3000.00);
        salesInvoices.add(salesInvoices1);
        SalesInvoice salesInvoices2 = SalesInvoiceFactory.createSalesInvoice("22-06-2014",1000.00);
        salesInvoices.add(salesInvoices2);

        Customer customer = CustomerFactory.createCustomer("Joubert", "Edmund", "0822483921", "2 sixth street Goodwood", "6738", salesInvoices, serviceSheets, storage);
        repository.save(customer);
        id = customer.getId();
        Assert.assertNotNull(id);

    }

    @Test
    public void testGetInvoices() throws Exception {
        List<SalesInvoice> salesInvoices = service.getInvoices(id);


        Assert.assertTrue(salesInvoices.size() == 2);
    }

    @Test
    public void testGetStorage() throws Exception {
        List<Storage> storages = service.getStorage(id);


        Assert.assertTrue(storages.size() == 2);
    }



}