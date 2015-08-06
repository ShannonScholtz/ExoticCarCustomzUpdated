package za.ac.cput.ExoticCarCustomz.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ExoticCarCustomz.domain.Salesperson;
import za.ac.cput.ExoticCarCustomz.repository.SalespersonRepository;
import za.ac.cput.ExoticCarCustomz.services.SalespersonService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
@Service
public class SalespersonImpl implements SalespersonService{

    @Autowired
    SalespersonRepository salespersonRepo;

    @Override
    public List<Salesperson> getSalesperson()
    {
        java.util.List<Salesperson> allSalesperson = new ArrayList<Salesperson>();

        Iterable<Salesperson> salespersons= salespersonRepo.findAll();

        for (Salesperson salesperson : salespersons)
        {
            allSalesperson.add(salesperson);
        }

        return allSalesperson;
    }
}
