package za.ac.cput.ExoticCarCustomz.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ExoticCarCustomz.domain.Car;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.repository.CarRepository;
import za.ac.cput.ExoticCarCustomz.services.CarService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
@Service
public class CarImpl implements CarService {

    @Autowired
    CarRepository carRepo;

    @Override
    public List<Car> getCar()
    {
        java.util.List<Car> allCars = new ArrayList<Car>();

        Iterable<Car> cars = carRepo.findAll();

        for (Car car : cars)
        {
            allCars.add(car);
        }

        return allCars;
    }

    @Override
    public List<ServiceSheet> getServiceSheet(Long id)
    {
        return carRepo.findOne(id).getServiceSheet();
    }
}
