package za.ac.cput.ExoticCarCustomz.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.ExoticCarCustomz.App;
import za.ac.cput.ExoticCarCustomz.config.factory.MechanicFactory;
import za.ac.cput.ExoticCarCustomz.config.factory.PartsUsedFactory;
import za.ac.cput.ExoticCarCustomz.config.factory.ServiceSheetFactory;
import za.ac.cput.ExoticCarCustomz.domain.Mechanic;
import za.ac.cput.ExoticCarCustomz.domain.PartsUsed;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.repository.MechanicRepository;
import za.ac.cput.ExoticCarCustomz.services.MechanicService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/05.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class MechanicServiceTest extends AbstractTestNGSpringContextTests {


    @Autowired
    private MechanicService service;
    private Long id;
    @Autowired
    private MechanicRepository repository;
    private List<ServiceSheet> serviceSheet;
    private List<PartsUsed> partsUseds;


    @BeforeMethod
    public void setUp() throws Exception {
        serviceSheet = new ArrayList();
        partsUseds= new ArrayList();
    }

    @Test
    public void create() throws Exception {

        PartsUsed partsUsed1 = PartsUsedFactory.createPartsUsed("GRLINK454", "Bmw 325i E93 Gear linkages", 15000.00);
        partsUseds.add(partsUsed1);

        ServiceSheet serviceSheet1 = ServiceSheetFactory.createServiceSheet("14020166754", 2, partsUseds);
        serviceSheet.add(serviceSheet1);

        Mechanic mechanic = MechanicFactory.createMechanic("Johannes", "Burg", 8, 124.000, "Gearbox specialist", serviceSheet);
        repository.save(mechanic);
        id = mechanic.getId();
        Assert.assertNotNull(id);

    }

    @Test
    public void testGetServiceSheet() throws Exception {
        List<ServiceSheet> sheet = service.getServiceSheet(id);

        Assert.assertTrue(sheet.size() == 1);
    }

}
