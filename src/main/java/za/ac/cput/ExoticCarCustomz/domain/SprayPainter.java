package za.ac.cput.ExoticCarCustomz.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
@Entity
public class SprayPainter implements Employee, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int hours;
    private double rate;
    private String PainterType;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "spraypainter_id")
    private List<ServiceSheet> serviceSheet;

    public SprayPainter()
    {

    }

    public List<ServiceSheet> getServiceSheet() {
        return serviceSheet;
    }

    public String PainterType() {
        return PainterType;
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

    public SprayPainter (Builder builder)
    {
        this.id=builder.id;
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

        public Builder id(long id)
        {
            this.id = id;
            return this;
        }

        public Builder serviceSheet(List<ServiceSheet> serviceSheet) {
            this.serviceSheet = serviceSheet;
            return this;
        }

        public Builder copy(SprayPainter sprayPainter) {

            this.id = sprayPainter.id;
            this.firstName = sprayPainter.firstName;
            this.lastName = sprayPainter.lastName;
            this.hours = sprayPainter.hours;
            this.rate=sprayPainter.rate;
            this.PainterType = sprayPainter.PainterType;
            this.serviceSheet = sprayPainter.serviceSheet;

            return this;
        }

        public SprayPainter build()
        {
            return new SprayPainter(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SprayPainter sprayPainter = (SprayPainter) o;

        return id.equals(sprayPainter.id);
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
