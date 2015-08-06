package za.ac.cput.ExoticCarCustomz.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.ExoticCarCustomz.config.factory.CustomerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/31.
 */
public class CustomerTest {

    @Test
    public void testCreate() throws Exception
    {
        List<SalesInvoice> salesInvoice = new ArrayList();
        List<ServiceSheet> serviceSheet = new ArrayList();
        List<Storage> storage = new ArrayList();

        Customer customer = CustomerFactory.createCustomer("Jabaar", "Faizel", "0813534214", "23 bb street Woodstock", "9932", salesInvoice,serviceSheet, storage);

        Assert.assertEquals("Jabaar", customer.getFirstName());
        Assert.assertEquals("Faizel", customer.getLastName());
        Assert.assertEquals("0813534214", customer.getPhoneNumber());
        Assert.assertEquals("23 bb street Woodstock", customer.getAddress());
        Assert.assertEquals("9932", customer.getPostalCode());
    }

    @Test
    public void testUpdate() throws Exception
    {
        List<SalesInvoice> salesInvoice = new ArrayList();
        List<ServiceSheet> serviceSheet = new ArrayList();
        List<Storage> storage = new ArrayList();

        Customer customer = CustomerFactory.createCustomer("Jabaar", "Faizel", "0813534214", "23 bb street Woodstock", "9932", salesInvoice,serviceSheet, storage);

        Customer newCustomer = new Customer.Builder(customer.getAddress()).copy(customer).postalCode("9459").build();

        Assert.assertEquals("9459", newCustomer.getPostalCode());
        Assert.assertEquals("9932", customer.getPostalCode());
    }
}
