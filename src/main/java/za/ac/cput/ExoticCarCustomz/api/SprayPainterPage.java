package za.ac.cput.ExoticCarCustomz.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.domain.SprayPainter;
import za.ac.cput.ExoticCarCustomz.module.SprayPainterResource;
import za.ac.cput.ExoticCarCustomz.services.SprayPainterService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
@RestController
@RequestMapping(value="/spraypainter/**")
public class SprayPainterPage {

    @Autowired
    private SprayPainterService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<ServiceSheet> getSheet(@PathVariable Long id)
    {
        return service.getServiceSheet(id);
    }

    @RequestMapping(value="/spraypainters", method=RequestMethod.GET)

    public List<SprayPainterResource> getSprayPainter()

    {
        List<SprayPainterResource> hateoas = new ArrayList();
        List<SprayPainter> spray = service.getSprayPainter();

        for (SprayPainter c: spray)
        {
            SprayPainterResource res = new SprayPainterResource.Builder(c.getLastName())
                    .firstName(c.getFirstName())
                    .hours(c.getHours())
                    .rate(c.getRate())
                    .PainterType(c.PainterType())
                    .serviceSheet(c.getServiceSheet())
                    .resid(c.getId()).build();

            Link spraypaint = new Link("http://localhost:8081/spraypainter" + res.getResid()+res.toString())
                    .withRel("spray");
            res.add(spraypaint);
            hateoas.add(res);
        }

        return hateoas;
    }
}
