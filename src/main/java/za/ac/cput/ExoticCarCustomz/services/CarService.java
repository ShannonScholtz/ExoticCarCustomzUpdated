package za.ac.cput.ExoticCarCustomz.services;

import za.ac.cput.ExoticCarCustomz.domain.Car;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;

import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
public interface CarService {

    List<Car> getCar();

    List<ServiceSheet> getServiceSheet(Long id);

}
