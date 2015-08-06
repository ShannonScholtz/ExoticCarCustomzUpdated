package za.ac.cput.ExoticCarCustomz.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/07/29.
 */
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String Address;
    private String postalCode;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private List<SalesInvoice> salesInvoice;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private List<ServiceSheet> serviceSheet;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private List<Storage> storage;

    public Customer() {

    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public List<SalesInvoice> getSalesInvoice() {
        return salesInvoice;
    }

    public List<ServiceSheet> getServiceSheet() {
        return serviceSheet;
    }

    public List<Storage> getStorage() {
        return storage;
    }


    public Customer(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.Address = builder.Address;
        this.postalCode = builder.postalCode;
        this.salesInvoice = builder.salesInvoice;
        this.serviceSheet = builder.serviceSheet;
        this.storage = builder.storage;
    }

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String Address;
        private String postalCode;
        private List<SalesInvoice> salesInvoice;
        private List<ServiceSheet> serviceSheet;
        private List<Storage> storage;

        public Builder(String lastName) {
            this.lastName = lastName;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder Address(String Address) {
            this.Address = Address;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder serviceSheet(List<ServiceSheet> serviceSheet) {
            this.serviceSheet = serviceSheet;
            return this;
        }

        public Builder salesInvoice(List<SalesInvoice> salesInvoice) {
            this.salesInvoice = salesInvoice;
            return this;
        }

        public Builder storage(List<Storage> storage) {
            this.storage = storage;
            return this;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder copy(Customer customer) {
            this.id = customer.id;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.phoneNumber = customer.phoneNumber;
            this.Address = customer.Address;
            this.postalCode = customer.postalCode;
            this.salesInvoice = customer.salesInvoice;
            this.serviceSheet = customer.serviceSheet;
            this.storage = customer.storage;

            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return id.equals(customer.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Name: " + firstName + "" + "Surname: " + lastName;
    }

}
