package za.ac.cput.ExoticCarCustomz.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.ExoticCarCustomz.App;
import za.ac.cput.ExoticCarCustomz.config.factory.PartsUsedFactory;
import za.ac.cput.ExoticCarCustomz.config.factory.ServiceSheetFactory;
import za.ac.cput.ExoticCarCustomz.config.factory.SprayPainterFactory;
import za.ac.cput.ExoticCarCustomz.domain.PartsUsed;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.domain.SprayPainter;
import za.ac.cput.ExoticCarCustomz.repository.SprayPainterRepository;
import za.ac.cput.ExoticCarCustomz.services.SprayPainterService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class SprayPainterServiceTest extends AbstractTestNGSpringContextTests {



    @Autowired
    private SprayPainterService service;
    private Long id;
    @Autowired
    private SprayPainterRepository repository;
    private List<ServiceSheet> serviceSheet;
    private List<PartsUsed> partsUseds;


    @BeforeMethod
    public void setUp() throws Exception {
        serviceSheet = new ArrayList();
        partsUseds= new ArrayList();
    }

    @Test
    public void create() throws Exception {

        PartsUsed partsUsed1 = PartsUsedFactory.createPartsUsed("123CODE235", "Green and Black Painter", 12000.00);
        partsUseds.add(partsUsed1);

        ServiceSheet serviceSheet1 = ServiceSheetFactory.createServiceSheet("15190492754", 8, partsUseds);
        serviceSheet.add(serviceSheet1);

        SprayPainter sprayPainter = SprayPainterFactory.createSprayPainter("Jackson", "Janet", 8, 200.000, "Airbrush art", serviceSheet);
        repository.save(sprayPainter);
        id = sprayPainter.getId();
        Assert.assertNotNull(id);

    }

    @Test
    public void testGetServiceSheet() throws Exception {
        List<ServiceSheet> sheet = service.getServiceSheet(id);

        Assert.assertTrue(sheet.size() == 1);
    }
}
