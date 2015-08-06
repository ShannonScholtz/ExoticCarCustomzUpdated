package za.ac.cput.ExoticCarCustomz.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/07/29.
 */
@Entity
public class SalesInvoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private double amount;

    public SalesInvoice(){

    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public SalesInvoice (Builder builder)
    {
        this.id=builder.id;
        this.date=builder.date;
        this.amount=builder.amount;
    }

    public static class Builder
    {
        private Long id;
        private String date;
        private double amount;

        public Builder (String date)
        {
            this.date = date;
        }

        public Builder amount(double amount)
        {
            this.amount = amount;
            return this;
        }

        public Builder id(long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(SalesInvoice salesInvoice) {

            this.id = salesInvoice.id;
            this.date = salesInvoice.date;
            this.amount = salesInvoice.amount;
            return this;
        }

        public SalesInvoice build()
        {
            return new SalesInvoice(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SalesInvoice salesInvoice = (SalesInvoice) o;

        return id.equals(salesInvoice.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Date: " + date;
    }
    }



