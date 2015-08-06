package za.ac.cput.ExoticCarCustomz.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/07/29.
 */
@Entity
public class Car implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String SerialNumber;
    private String Make;
    private String Model;
    private String Colour;
    private String year;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="car_id")
    private List<SalesInvoice> salesInvoice;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="car_id")
    private List<ServiceSheet> serviceSheet;

    public Car(){}

    public List<ServiceSheet> getServiceSheet() {
        return serviceSheet;
    }

    public List<SalesInvoice> getSalesInvoice() {
        return salesInvoice;
    }

    public String getYear() {
        return year;
    }

    public String getColour() {
        return Colour;
    }

    public String getModel() {
        return Model;
    }

    public String getMake() {
        return Make;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public Long getId() {
        return id;
    }

    public Car(Builder builder)
    {
        this.id=builder.id;
        this.SerialNumber=builder.SerialNumber;
        this.Make=builder.Make;
        this.Model=builder.Model;
        this.Colour=builder.Colour;
        this.year=builder.year;
        this.salesInvoice=builder.salesInvoice;
        this.serviceSheet =builder.serviceSheet;
    }

    public static class Builder
    {
        private Long id;
        private String SerialNumber;
        private String Make;
        private String Model;
        private String Colour;
        private String year;
        private List<SalesInvoice> salesInvoice;
        private List<ServiceSheet> serviceSheet;

        public Builder (String SerialNumber)
        {
            this.SerialNumber = SerialNumber;
        }

        public Builder Make(String Make)
        {
            this.Make = Make;
            return this;
        }

        public Builder Model(String Model)
        {
            this.Model = Model;
            return this;
        }

        public Builder Colour(String Colour)
        {
            this.Colour = Colour;
            return this;
        }

        public Builder year(String year)
        {
            this.year = year;
            return this;
        }

        public Builder serviceSheet(List<ServiceSheet> serviceSheet)
        {
            this.serviceSheet = serviceSheet;
            return this;
        }

        public Builder salesInvoice(List<SalesInvoice> salesInvoices)
        {
            this.salesInvoice = salesInvoices;
            return this;
        }


        public Builder id(long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Car car) {

            this.id = car.id;
            this.SerialNumber = car.SerialNumber;
            this.Make=car.Make;
            this.Model=car.Model;
            this.Colour=car.Colour;
            this.year=car.year;
            this.salesInvoice=car.salesInvoice;
            this.serviceSheet =car.serviceSheet;

            return this;
        }

        public Car build()
        {
            return new Car(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return id.equals(car.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Make: " + Make;
    }

}

