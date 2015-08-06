package za.ac.cput.ExoticCarCustomz.module;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;

import javax.persistence.*;
import java.util.List;

/**
 * Created by student on 2015/08/05.
 */
public class MechanicResource extends ResourceSupport {

    private Long resid;
    private String firstName;
    private String lastName;
    private int hours;
    private double rate;
    private String mechanicType;
    private List<ServiceSheet> serviceSheet;

    public MechanicResource()
    {

    }

    public List<ServiceSheet> getServiceSheet() {
        return serviceSheet;
    }

    public String getMechanicType() {
        return mechanicType;
    }

    public int getHours() {
        return hours;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getRate() {
        return rate;
    }

    public Long getResid() {
        return resid;
    }

    public MechanicResource (Builder builder)
    {
        this.resid=builder.id;
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

        public Builder resid(long id)
        {
            this.id = id;
            return this;
        }

        public Builder serviceSheet(List<ServiceSheet> serviceSheet) {
            this.serviceSheet = serviceSheet;
            return this;
        }

        public Builder copy(MechanicResource mechanic) {

            this.id = mechanic.resid;
            this.firstName = mechanic.firstName;
            this.lastName = mechanic.lastName;
            this.hours = mechanic.hours;
            this.rate=mechanic.rate;
            this.mechanicType = mechanic.mechanicType;
            this.serviceSheet = mechanic.serviceSheet;

            return this;
        }

        public MechanicResource build()
        {
            return new MechanicResource(this);
        }
    }
}
