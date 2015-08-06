package za.ac.cput.ExoticCarCustomz.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.ExoticCarCustomz.domain.Mechanic;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.module.MechanicResource;
import za.ac.cput.ExoticCarCustomz.services.MechanicService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/05.
 */
@RestController
@RequestMapping(value="/mechanic/**")
public class MechanicPage {


    @Autowired
    private MechanicService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<ServiceSheet> getSheet(@PathVariable Long id)
    {
        return service.getServiceSheet(id);
    }

    @RequestMapping(value="/mechanics", method=RequestMethod.GET)

    public List<MechanicResource> getMechanics()

    {
        List<MechanicResource> hateoas = new ArrayList();
        List<Mechanic> mechan = service.getMechanic();

        for (Mechanic c: mechan)
        {
            MechanicResource res = new MechanicResource.Builder(c.getLastName())
                    .firstName(c.getFirstName())
                    .hours(c.getHours())
                    .rate(c.getRate())
                    .mechanicType(c.getMechanicType())
                    .serviceSheet(c.getServiceSheet())
                    .resid(c.getId()).build();

            Link mec = new Link("http://localhost:8081/mechanic" + res.getResid()+res.toString())
                    .withRel("mechanz");
            res.add(mec);
            hateoas.add(res);
        }

        return hateoas;
    }
}
