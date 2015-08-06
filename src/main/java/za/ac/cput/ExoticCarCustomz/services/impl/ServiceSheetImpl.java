package za.ac.cput.ExoticCarCustomz.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.repository.ServiceSheetRepository;
import za.ac.cput.ExoticCarCustomz.services.ServiceSheetService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
@Service
public class ServiceSheetImpl implements ServiceSheetService {

    @Autowired
    ServiceSheetRepository serviceSheetRepo;

    @Override
    public List<ServiceSheet> getServiceSheet()
    {
        java.util.List<ServiceSheet> allServiceSheet = new ArrayList<ServiceSheet>();

        Iterable<ServiceSheet> serviceSheets= serviceSheetRepo.findAll();

        for (ServiceSheet salesperson : serviceSheets)
        {
            allServiceSheet.add(salesperson);
        }

        return allServiceSheet;
    }
}
