package za.ac.cput.ExoticCarCustomz.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by student on 2015/07/29.
 */
@Entity
public class ServiceSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ServiceNumber;
    private int PeriodWorkedOn;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="servicesheet_id")
    private List<PartsUsed> partsUsed;


    public ServiceSheet(){

    }

    public Long getId() {
        return id;
    }

    public String getServiceNumber() {
        return ServiceNumber;
    }

    public int getPeriodWorkedOn() {
        return PeriodWorkedOn;
    }

    public List<PartsUsed> getPartsUsed() {
        return partsUsed;
    }


    public ServiceSheet(Builder builder)
    {
        this.id=builder.id;
        this.ServiceNumber=builder.ServiceNumber;
        this.PeriodWorkedOn=builder.PeriodWorkedOn;
        this.partsUsed=builder.partsUsed;
    }

    public static class Builder
    {
        private Long id;
        private String ServiceNumber;
        private int PeriodWorkedOn;
        private List<PartsUsed> partsUsed;

        public Builder(String ServiceNumber)
        {
            this.ServiceNumber = ServiceNumber;
        }

        public Builder PeriodWorkedOn(int PeriodWorkedOn)
        {
            this.PeriodWorkedOn = PeriodWorkedOn;
            return this;
        }

        public Builder partsUsed(List<PartsUsed> partsUsed)
        {
            this.partsUsed = partsUsed;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(ServiceSheet serviceSheet)
        {
            this.id = serviceSheet.id;
            this.ServiceNumber = serviceSheet.ServiceNumber;
            this.PeriodWorkedOn = serviceSheet.PeriodWorkedOn;
            this.partsUsed = serviceSheet.partsUsed;

            return this;
        }

        public ServiceSheet build()
        {
            return new ServiceSheet(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ServiceSheet serviceSheet = (ServiceSheet) o;

        return id.equals(serviceSheet.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Service Number: " + ServiceNumber + "" + "Period Car Was Worked on: " + PeriodWorkedOn;
    }

}
