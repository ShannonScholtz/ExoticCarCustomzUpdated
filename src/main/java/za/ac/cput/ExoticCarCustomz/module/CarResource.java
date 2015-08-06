package za.ac.cput.ExoticCarCustomz.module;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.ExoticCarCustomz.domain.SalesInvoice;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;

import java.util.List;

/**
 * Created by student on 2015/08/05.
 */
public class CarResource extends ResourceSupport {

    private Long resid;
    private String SerialNumber;
    private String Make;
    private String Model;
    private String Colour;
    private String year;

    private List<SalesInvoice> salesInvoice;
    private List<ServiceSheet> serviceSheet;

    public CarResource(){}

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

    public Long getResid() {
        return resid;
    }

    public CarResource(Builder builder)
    {
        this.resid=builder.id;
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


        public Builder resid(long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(CarResource carRes) {

            this.id = carRes.resid;
            this.SerialNumber = carRes.SerialNumber;
            this.Make=carRes.Make;
            this.Model=carRes.Model;
            this.Colour=carRes.Colour;
            this.year=carRes.year;
            this.salesInvoice=carRes.salesInvoice;
            this.serviceSheet =carRes.serviceSheet;

            return this;
        }

        public CarResource build()
        {
            return new CarResource(this);
        }
    }
}
