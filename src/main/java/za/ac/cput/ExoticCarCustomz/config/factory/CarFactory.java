package za.ac.cput.ExoticCarCustomz.config.factory;

import za.ac.cput.ExoticCarCustomz.domain.Car;
import za.ac.cput.ExoticCarCustomz.domain.SalesInvoice;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;

import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
public class CarFactory {

    public static Car createCar(String SerialNumber, String Make, String Model, String Colour, String year, List<SalesInvoice> salesInvoice, List<ServiceSheet> serviceSheet)
    {
        Car car = new Car.Builder(SerialNumber).Make(Make).Model(Model).Colour(Colour).year(year).salesInvoice(salesInvoice).serviceSheet(serviceSheet).build();

        return car;
    }
}

