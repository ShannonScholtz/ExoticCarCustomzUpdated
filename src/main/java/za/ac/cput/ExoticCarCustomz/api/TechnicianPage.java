package za.ac.cput.ExoticCarCustomz.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.domain.Technician;
import za.ac.cput.ExoticCarCustomz.module.TechnicianResource;
import za.ac.cput.ExoticCarCustomz.services.TechnicianService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
@RestController
@RequestMapping(value="/technician/**")
public class TechnicianPage {

    @Autowired
    private TechnicianService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<ServiceSheet> getSheet(@PathVariable Long id)
    {
        return service.getServiceSheet(id);
    }

    @RequestMapping(value="/technicians", method=RequestMethod.GET)

    public List<TechnicianResource> getTechnician()

    {
        List<TechnicianResource> hateoas = new ArrayList();
        List<Technician> tech = service.getTechnician();

        for (Technician c: tech)
        {
            TechnicianResource res = new TechnicianResource.Builder(c.getLastName())
                    .firstName(c.getFirstName())
                    .hours(c.getHours())
                    .rate(c.getRate())
                    .soundInstalls(c.getsoundInstalls())
                    .serviceSheet(c.getServiceSheet())
                    .resid(c.getId()).build();

            Link techni = new Link("http://localhost:8081/technician" + res.getResid()+res.toString())
                    .withRel("techi");
            res.add(techni);
            hateoas.add(res);
        }

        return hateoas;
    }
}
