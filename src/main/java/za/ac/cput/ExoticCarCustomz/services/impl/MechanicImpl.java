package za.ac.cput.ExoticCarCustomz.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ExoticCarCustomz.domain.Mechanic;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.repository.MechanicRepository;
import za.ac.cput.ExoticCarCustomz.services.MechanicService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
@Service
public class MechanicImpl implements MechanicService {


    @Autowired
    MechanicRepository mechanicRepo;

    @Override
    public List<Mechanic> getMechanic()
    {
        java.util.List<Mechanic> allMechanics = new ArrayList<Mechanic>();

        Iterable<Mechanic> mechanics = mechanicRepo.findAll();

        for (Mechanic mech : mechanics)
        {
            allMechanics.add(mech);
        }

        return allMechanics;
    }

    @Override
    public List<ServiceSheet> getServiceSheet(Long id)
    {
        return mechanicRepo.findOne(id).getServiceSheet();
    }
}
