package za.ac.cput.ExoticCarCustomz.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.ExoticCarCustomz.domain.Car;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.module.CarResource;
import za.ac.cput.ExoticCarCustomz.services.CarService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/05.
 */
@RestController
@RequestMapping(value="/car/**")
public class CarPage {

    @Autowired
    private CarService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<ServiceSheet> getSheet(@PathVariable Long id)
    {
        return service.getServiceSheet(id);
    }

    @RequestMapping(value="/cars", method=RequestMethod.GET)

    public List<CarResource> getCarss()

    {
        List<CarResource> hateoas = new ArrayList();
        List<Car> cars = service.getCar();

        for (Car c: cars)
        {
            CarResource res = new CarResource.Builder(c.getSerialNumber())
                    .Make(c.getMake())
                    .Model(c.getModel())
                    .Colour(c.getColour())
                    .year(c.getYear())
                    .salesInvoice(c.getSalesInvoice())
                    .serviceSheet(c.getServiceSheet())
                    .resid(c.getId()).build();

            Link sheet = new Link("http://localhost:8081/car" + res.getResid()+res.toString())
                    .withRel("servsheet");
            res.add(sheet);
            hateoas.add(res);
        }

        return hateoas;
    }
}
