package za.ac.cput.ExoticCarCustomz.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/08/04.
 */
@Entity
public class Storage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Make;
    private String Model;
    private String Colour;
    private String year;
    private String RegistrationNumber;
    private double StoragePeriodInMonths;
    private double MonthlyStorageCost;
    private double totalStorageCost;

    public Storage(){}


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

    public String getRegistrationNumber() {
        return RegistrationNumber;
    }

    public double getStoragePeriodInMonths() {
        return StoragePeriodInMonths;
    }

    public double getMonthlyStorageCost() {
        return MonthlyStorageCost;
    }

    public double getTotalStorageCost() {
        return totalStorageCost;
    }

    public Long getId() {
        return id;
    }

    public Storage(Builder builder)
    {
        this.id=builder.id;
        this.Make=builder.Make;
        this.Model=builder.Model;
        this.Colour=builder.Colour;
        this.year=builder.year;
        this.RegistrationNumber =builder.RegistrationNumber;
        this.StoragePeriodInMonths = builder.StoragePeriodInMonths;
        this.MonthlyStorageCost =builder.MonthlyStorageCost;
        this.totalStorageCost=builder.totalStorageCost;
    }
    public static class Builder
    {
        private Long id;
        private String Make;
        private String Model;
        private String Colour;
        private String year;
        private String RegistrationNumber;
        private double StoragePeriodInMonths;
        private double MonthlyStorageCost;
        private double totalStorageCost;

        public Builder (String RegistrationNumber)
        {
            this.RegistrationNumber = RegistrationNumber;
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

        public Builder StoragePeriodInMonths(double StoragePeriodInMonths)
        {
            this.StoragePeriodInMonths = StoragePeriodInMonths;
            return this;
        }

        public Builder MonthlyStorageCost(double MonthlyStorageCost)
        {
            this.MonthlyStorageCost = MonthlyStorageCost;
            return this;
        }

        public Builder totalStorageCost(double totalStorageCost)
        {
            this.totalStorageCost = totalStorageCost;
            return this;
        }

        public Builder id(long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Storage storage) {

            this.id = storage.id;
            this.Make=storage.Make;
            this.Model=storage.Model;
            this.Colour=storage.Colour;
            this.year=storage.year;
            this.RegistrationNumber=storage.RegistrationNumber;
            this.StoragePeriodInMonths =storage.StoragePeriodInMonths;
            this.MonthlyStorageCost =storage.MonthlyStorageCost;
            this.totalStorageCost =storage.totalStorageCost;


            return this;
        }

        public Storage build()
        {
            return new Storage(this);
        }
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Storage storage = (Storage) o;

        return id.equals(storage.id);
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
