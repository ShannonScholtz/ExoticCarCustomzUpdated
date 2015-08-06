package za.ac.cput.ExoticCarCustomz.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.ExoticCarCustomz.App;
import za.ac.cput.ExoticCarCustomz.config.factory.CarFactory;
import za.ac.cput.ExoticCarCustomz.config.factory.PartsUsedFactory;
import za.ac.cput.ExoticCarCustomz.config.factory.ServiceSheetFactory;
import za.ac.cput.ExoticCarCustomz.domain.*;
import za.ac.cput.ExoticCarCustomz.repository.CarRepository;
import za.ac.cput.ExoticCarCustomz.services.CarService;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/05.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class CarServiceTest extends AbstractTestNGSpringContextTests {


    @Autowired
    private CarService service;
    private Long id;
    @Autowired
    private CarRepository repository;
    private List<ServiceSheet> serviceSheet;
    private List<SalesInvoice> salesInvoice;
    private List<PartsUsed> partsUseds;


    @BeforeMethod
    public void setUp() throws Exception {
        serviceSheet = new ArrayList();
        salesInvoice = new ArrayList();
        partsUseds= new ArrayList();
    }

    @Test
    public void create() throws Exception {


        PartsUsed partsUsed1 = PartsUsedFactory.createPartsUsed("CMPTR454", "Bmw 325i E93 Computer-Box", 35000.00);
        partsUseds.add(partsUsed1);

        ServiceSheet serviceSheet1 = ServiceSheetFactory.createServiceSheet("14020156754", 2, partsUseds);
        serviceSheet.add(serviceSheet1);
        ServiceSheet serviceSheet2 = ServiceSheetFactory.createServiceSheet("14023445554", 1, partsUseds);
        serviceSheet.add(serviceSheet2);


        Car car = CarFactory.createCar("123345VW", "VW", "Golf 1", "Green", "2006", salesInvoice, serviceSheet);
        repository.save(car);
        id = car.getId();
        Assert.assertNotNull(id);

    }

    @Test
    public void testGetServiceSheet() throws Exception {
        List<ServiceSheet> serviceSheets = service.getServiceSheet(id);


        Assert.assertTrue(serviceSheets.size() == 2);
    }
}
