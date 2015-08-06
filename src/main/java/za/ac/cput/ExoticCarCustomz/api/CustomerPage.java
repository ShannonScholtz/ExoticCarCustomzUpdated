package za.ac.cput.ExoticCarCustomz.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.ExoticCarCustomz.domain.Customer;
import za.ac.cput.ExoticCarCustomz.domain.SalesInvoice;
import za.ac.cput.ExoticCarCustomz.module.CustomerResource;
import za.ac.cput.ExoticCarCustomz.services.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/31.
 */
@RestController
@RequestMapping(value="/customer/**")
public class CustomerPage {

    @Autowired
    private CustomerService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<SalesInvoice> getInvoice(@PathVariable Long id)
    {
        return service.getInvoices(id);
    }

    @RequestMapping(value="/customers", method=RequestMethod.GET)

    public List<CustomerResource> getCustomers()
    {
        List<CustomerResource> hateoas = new ArrayList();
        List<Customer> customers = service.getCustomer();

        for (Customer c: customers)
        {
            CustomerResource res = new CustomerResource.Builder(c.getLastName())
                    .firstName(c.getFirstName())
                    .phoneNumber(c.getPhoneNumber())
                    .postalCode(c.getPostalCode())
                    .Address(c.getAddress())
                    .salesInvoices(c.getSalesInvoice())
                    .serviceSheet(c.getServiceSheet())
                    .storage(c.getStorage())
                    .resid(c.getId()).build();

            Link invoice = new Link("http://localhost:8081/customer" + res.getResid().toString())
                    .withRel("Invoice");
            res.add(invoice);
            hateoas.add(res);
        }

        return hateoas;
    }
}





