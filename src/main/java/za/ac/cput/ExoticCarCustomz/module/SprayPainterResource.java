package za.ac.cput.ExoticCarCustomz.module;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;

import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
public class SprayPainterResource extends ResourceSupport {

    private Long resid;
    private String firstName;
    private String lastName;
    private int hours;
    private double rate;
    private String PainterType;
    private List<ServiceSheet> serviceSheet;

    public SprayPainterResource()
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

    public String getPainterType() {
        return PainterType;
    }

    public double getRate() {
        return rate;
    }

    public Long getResid() {
        return resid;
    }

    public SprayPainterResource (Builder builder)
    {
        this.resid=builder.id;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.hours=builder.hours;
        this.rate = builder.rate;
        this.PainterType=builder.PainterType;
        this.serviceSheet=builder.serviceSheet;
    }

    public static class Builder
    {
        private Long id;
        private String firstName;
        private String lastName;
        private int hours;
        private double rate;
        private String PainterType;
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

        public Builder PainterType(String PainterType)
        {
            this.PainterType = PainterType;
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

        public Builder copy(SprayPainterResource sprayPainterResource) {

            this.id = sprayPainterResource.resid;
            this.firstName = sprayPainterResource.firstName;
            this.lastName = sprayPainterResource.lastName;
            this.hours = sprayPainterResource.hours;
            this.rate=sprayPainterResource.rate;
            this.PainterType = sprayPainterResource.PainterType;
            this.serviceSheet = sprayPainterResource.serviceSheet;

            return this;
        }

        public SprayPainterResource build()
        {
            return new SprayPainterResource(this);
        }
    }
}
