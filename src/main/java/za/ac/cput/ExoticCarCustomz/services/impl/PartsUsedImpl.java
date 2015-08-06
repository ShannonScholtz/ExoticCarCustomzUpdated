package za.ac.cput.ExoticCarCustomz.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ExoticCarCustomz.domain.PartsUsed;
import za.ac.cput.ExoticCarCustomz.repository.PartsUsedRepository;
import za.ac.cput.ExoticCarCustomz.services.PartsUsedService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
@Service
public class PartsUsedImpl implements PartsUsedService {


    @Autowired
    PartsUsedRepository partsUsedRepo;

    @Override
    public List<PartsUsed> getPartsUsed()
    {
        java.util.List<PartsUsed> allPartsUsed = new ArrayList<PartsUsed>();

        Iterable<PartsUsed> partsUseds = partsUsedRepo.findAll();

        for (PartsUsed partsUsed : partsUseds)
        {
            allPartsUsed.add(partsUsed);
        }

        return allPartsUsed;
    }
}


