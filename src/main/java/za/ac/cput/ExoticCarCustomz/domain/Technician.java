package za.ac.cput.ExoticCarCustomz.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
@Entity
public class Technician implements Employee, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int hours;
    private double rate;
    private String soundInstalls;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "technician_id")
    private List<ServiceSheet> serviceSheet;

    public Technician()
    {

    }

    public List<ServiceSheet> getServiceSheet() {
        return serviceSheet;
    }

    public String getsoundInstalls() {
        return soundInstalls;
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

    public Technician(Builder builder)
    {
        this.id=builder.id;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.hours=builder.hours;
        this.rate = builder.rate;
        this.soundInstalls=builder.soundInstalls;
        this.serviceSheet=builder.serviceSheet;
    }

    public static class Builder
    {
        private Long id;
        private String firstName;
        private String lastName;
        private int hours;
        private double rate;
        private String soundInstalls;
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

        public Builder soundInstalls(String soundInstalls)
        {
            this.soundInstalls = soundInstalls;
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

        public Builder copy(Technician technician) {

            this.id = technician.id;
            this.firstName = technician.firstName;
            this.lastName = technician.lastName;
            this.hours = technician.hours;
            this.rate= technician.rate;
            this.soundInstalls = technician.soundInstalls;
            this.serviceSheet = technician.serviceSheet;

            return this;
        }

        public Technician build()
        {
            return new Technician(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Technician technician = (Technician) o;

        return id.equals(technician.id);
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
