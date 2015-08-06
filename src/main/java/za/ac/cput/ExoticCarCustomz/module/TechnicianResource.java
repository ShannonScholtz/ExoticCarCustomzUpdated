package za.ac.cput.ExoticCarCustomz.module;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;

import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
public class TechnicianResource extends ResourceSupport {

    private Long resid;
    private String firstName;
    private String lastName;
    private int hours;
    private double rate;
    private String soundInstalls;
    private List<ServiceSheet> serviceSheet;

    public TechnicianResource()
    {

    }

    public List<ServiceSheet> getServiceSheet() {
        return serviceSheet;
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

    public String getSoundInstalls() {
        return soundInstalls;
    }

    public double getRate() {
        return rate;
    }

    public Long getResid() {
        return resid;
    }

    public TechnicianResource (Builder builder)
    {
        this.resid=builder.id;
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

        public Builder resid(long id)
        {
            this.id = id;
            return this;
        }

        public Builder serviceSheet(List<ServiceSheet> serviceSheet) {
            this.serviceSheet = serviceSheet;
            return this;
        }

        public Builder copy(TechnicianResource technicianResource) {

            this.id = technicianResource.resid;
            this.firstName = technicianResource.firstName;
            this.lastName = technicianResource.lastName;
            this.hours = technicianResource.hours;
            this.rate=technicianResource.rate;
            this.soundInstalls = technicianResource.soundInstalls;
            this.serviceSheet = technicianResource.serviceSheet;

            return this;
        }

        public TechnicianResource build()
        {
            return new TechnicianResource(this);
        }
    }
}
