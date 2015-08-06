package za.ac.cput.ExoticCarCustomz.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/07/29.
 */
@Entity
public class Salesperson implements Employee, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int hours;
    private double rate;
    private int DailySales;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="salesperson_id")
    private List<SalesInvoice> salesInvoice;

    public Salesperson()
    {

    }

    public List<SalesInvoice> getSalesInvoice() {
        return salesInvoice;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public double getRate() {
        return rate;
    }

    @Override
    public int getHours() {
        return hours;
    }

    public int getDailySales() {
        return DailySales;
    }

    @Override
    public Long getId() {
        return id;
    }


    public Salesperson (Builder builder)
    {
        this.id=builder.id;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.hours= builder.hours;
        this.rate=builder.rate;
        this.DailySales = builder.DailySales;
        this.salesInvoice=builder.salesInvoice;
    }

    public static class Builder
    {
        private Long id;
        private String firstName;
        private String lastName;
        private int hours;
        private double rate;
        private int DailySales;
        private List<SalesInvoice> salesInvoice;

        public Builder(String lastName)
        {
            this.lastName = lastName;
        }

        public Builder firstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Builder hours(int hours)
        {
            this.hours = hours;
            return this;
        }

        public Builder rate(double rate)
        {
            this.rate = rate;
            return this;
        }

        public Builder DailySales(int DailySales)
        {
            this.DailySales = DailySales;
            return this;
        }

        public Builder salesInvoice(List<SalesInvoice> salesInvoice)
        {
            this.salesInvoice = salesInvoice;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Salesperson salesperson)
        {
            this.id = salesperson.id;
            this.firstName = salesperson.firstName;
            this.lastName = salesperson.lastName;
            this.hours = salesperson.hours;
            this.rate = salesperson.rate;
            this.DailySales=salesperson.DailySales;
            this.salesInvoice = salesperson.salesInvoice;

            return this;
        }

        public Salesperson build()
        {
            return new Salesperson(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Salesperson salesperson = (Salesperson) o;

        return id.equals(salesperson.id);
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
