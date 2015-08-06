package za.ac.cput.ExoticCarCustomz.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
@Entity
public class Mechanic implements Employee, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int hours;
    private double rate;
    private String mechanicType;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "mechanic_id")
    private List<ServiceSheet> serviceSheet;

    public Mechanic()
    {

    }

    public List<ServiceSheet> getServiceSheet() {
        return serviceSheet;
    }

    public String getMechanicType() {
        return mechanicType;
    }

    @Override
    public int getHours() {
        return hours;
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
    public Long getId() {
        return id;
    }

    public Mechanic (Builder builder)
    {
        this.id=builder.id;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.hours=builder.hours;
        this.rate = builder.rate;
        this.mechanicType=builder.mechanicType;
        this.serviceSheet=builder.serviceSheet;
    }

    public static class Builder
    {
        private Long id;
        private String firstName;
        private String lastName;
        private int hours;
        private double rate;
        private String mechanicType;
        private List<ServiceSheet> serviceSheet;


        public Builder (String lastName)
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

        public Builder mechanicType(String mechanicType)
        {
            this.mechanicType = mechanicType;
            return this;
        }

        public Builder id(long id)
        {
            this.id = id;
            return this;
        }

        public Builder serviceSheet(List<ServiceSheet> serviceSheet) {
            this.serviceSheet = serviceSheet;
            return this;
        }

        public Builder copy(Mechanic mechanic) {

            this.id = mechanic.id;
            this.firstName = mechanic.firstName;
            this.lastName = mechanic.lastName;
            this.hours = mechanic.hours;
            this.rate=mechanic.rate;
            this.mechanicType = mechanic.mechanicType;
            this.serviceSheet = mechanic.serviceSheet;

            return this;
        }

        public Mechanic build()
        {
            return new Mechanic(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Mechanic mechanic = (Mechanic) o;

        return id.equals(mechanic.id);
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
