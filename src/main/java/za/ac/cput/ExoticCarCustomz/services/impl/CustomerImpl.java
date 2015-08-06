package za.ac.cput.ExoticCarCustomz.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ExoticCarCustomz.domain.Customer;
import za.ac.cput.ExoticCarCustomz.domain.SalesInvoice;
import za.ac.cput.ExoticCarCustomz.domain.Storage;
import za.ac.cput.ExoticCarCustomz.repository.CustomerRepository;
import za.ac.cput.ExoticCarCustomz.services.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
@Service
public class CustomerImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepo;

    @Override
    public List<Customer> getCustomer()
    {
        java.util.List<Customer> allCars = new ArrayList<Customer>();

        Iterable<Customer> customers = customerRepo.findAll();

        for (Customer cust : customers)
        {
            allCars.add(cust);
        }

        return allCars;
    }

    @Override
    public List<SalesInvoice> getInvoices(Long id)
    {
        return customerRepo.findOne(id).getSalesInvoice();
    }

    @Override
    public List<Storage> getStorage(Long id)
    {
        return customerRepo.findOne(id).getStorage();
    }
}
