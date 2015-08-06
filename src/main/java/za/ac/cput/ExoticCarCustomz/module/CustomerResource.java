package za.ac.cput.ExoticCarCustomz.module;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.ExoticCarCustomz.domain.SalesInvoice;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.domain.Storage;

import java.util.List;

/**
 * Created by student on 2015/07/31.
 */
public class CustomerResource extends ResourceSupport {

    private Long resid;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String Address;
    private String postalCode;
    private List<SalesInvoice> salesInvoices;
    private List<ServiceSheet> serviceSheet;
    private  List<Storage> storage;

    public List<ServiceSheet> getServiceSheet() {
        return serviceSheet;
    }

    public List<SalesInvoice> getSalesInvoices() {
        return salesInvoices;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Storage> getStorage() {
        return storage;
    }


    public Long getResid() {
        return resid;
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private CustomerResource() {
    }

    public CustomerResource (Builder builder)
    {
        resid = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        phoneNumber = builder.phoneNumber;
        Address = builder.Address;
        postalCode = builder.postalCode;
        salesInvoices = builder.salesInvoices;
        serviceSheet = builder.serviceSheet;
        storage = builder.storage;
    }

    public static class Builder
    {
        private Long id;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String Address;
        private String postalCode;
        private List<SalesInvoice> salesInvoices;
        private List<ServiceSheet> serviceSheet;
        private  List<Storage> storage;

        public Builder(String lastName)
        {
            this.lastName = lastName;
        }

        public Builder firstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Builder phoneNumber(String phoneNumber)
        {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder Address(String Address)
        {
            this.Address = Address;
            return this;
        }

        public Builder postalCode(String postalCode)
        {
            this.postalCode = postalCode;
            return this;
        }

        public Builder salesInvoices(List<SalesInvoice> salesInvoices)
        {
            this.salesInvoices = salesInvoices;
            return this;
        }

        public Builder storage(List<Storage> storage)
        {
            this.storage = storage;
            return this;
        }

        public Builder serviceSheet(List<ServiceSheet> serviceSheet)
        {
            this.serviceSheet = serviceSheet;
            return this;
        }

        public Builder resid(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(CustomerResource customer)
        {
            this.id = customer.resid;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.phoneNumber = customer.phoneNumber;
            this.Address = customer.Address;
            this.postalCode = customer.postalCode;
            this.salesInvoices = customer.salesInvoices;
            this.serviceSheet = customer.serviceSheet;
            this.storage = customer.storage;

            return this;
        }

        public CustomerResource build()
        {
            return new CustomerResource(this);
        }
    }
}

