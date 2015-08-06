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
import za.ac.cput.ExoticCarCustomz.config.factory.TechnicianFactory;
import za.ac.cput.ExoticCarCustomz.domain.PartsUsed;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.domain.Technician;
import za.ac.cput.ExoticCarCustomz.repository.TechnicianRepository;
import za.ac.cput.ExoticCarCustomz.services.TechnicianService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/06.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TechnicianServiceTest extends AbstractTestNGSpringContextTests {


    @Autowired
    private TechnicianService service;
    private Long id;
    @Autowired
    private TechnicianRepository repository;
    private List<ServiceSheet> serviceSheet;
    private List<PartsUsed> partsUseds;


    @BeforeMethod
    public void setUp() throws Exception {
        serviceSheet = new ArrayList();
        partsUseds= new ArrayList();
    }

    @Test
    public void create() throws Exception {

        PartsUsed partsUsed1 = PartsUsedFactory.createPartsUsed("GSonyEquip3532", "Sony Sound System", 10000.00);
        partsUseds.add(partsUsed1);

        ServiceSheet serviceSheet1 = ServiceSheetFactory.createServiceSheet("11110166754", 2, partsUseds);
        serviceSheet.add(serviceSheet1);

        Technician technician = TechnicianFactory.createTechnician("Patrick", "Edmund", 8, 124.000, "Fully Equipped Sony Sound System", serviceSheet);
        repository.save(technician);
        id = technician.getId();
        Assert.assertNotNull(id);

    }

    @Test
    public void testGetServiceSheet() throws Exception {
        List<ServiceSheet> sheet = service.getServiceSheet(id);

        Assert.assertTrue(sheet.size() == 1);
    }
}
