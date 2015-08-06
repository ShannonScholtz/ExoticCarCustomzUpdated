package za.ac.cput.ExoticCarCustomz.config.factory;

import za.ac.cput.ExoticCarCustomz.domain.Customer;
import za.ac.cput.ExoticCarCustomz.domain.SalesInvoice;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.domain.Storage;

import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
public class CustomerFactory {

    public static Customer createCustomer(String firstName, String lastName, String phoneNumber, String Address, String postalCode, List<SalesInvoice> salesInvoice, List<ServiceSheet> serviceSheet, List<Storage> storage)
    {
        Customer customer = new Customer.Builder(lastName).firstName(firstName).phoneNumber(phoneNumber).Address(Address).postalCode(postalCode).salesInvoice(salesInvoice).serviceSheet(serviceSheet).storage(storage).build();

        return customer;
    }
}
