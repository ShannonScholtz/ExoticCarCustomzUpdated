package za.ac.cput.ExoticCarCustomz.services;

import za.ac.cput.ExoticCarCustomz.domain.Customer;
import za.ac.cput.ExoticCarCustomz.domain.SalesInvoice;
import za.ac.cput.ExoticCarCustomz.domain.Storage;

import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
public interface CustomerService {

    List<Customer> getCustomer();

    List<SalesInvoice> getInvoices(Long id);

    List<Storage> getStorage(Long id);
}
