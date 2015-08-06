package za.ac.cput.ExoticCarCustomz.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.domain.Technician;
import za.ac.cput.ExoticCarCustomz.repository.TechnicianRepository;
import za.ac.cput.ExoticCarCustomz.services.TechnicianService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
@Service
public class TechnicianImpl implements TechnicianService {

    @Autowired
    TechnicianRepository technicianRepo;

    @Override
    public List<Technician> getTechnician()
    {
        java.util.List<Technician> allTechnician = new ArrayList<Technician>();

        Iterable<Technician> technicians= technicianRepo.findAll();

        for (Technician technician : technicians)
        {
            allTechnician.add(technician);
        }

        return allTechnician;
    }

    @Override
    public List<ServiceSheet> getServiceSheet(Long id)
    {
        return technicianRepo.findOne(id).getServiceSheet();
    }
}
