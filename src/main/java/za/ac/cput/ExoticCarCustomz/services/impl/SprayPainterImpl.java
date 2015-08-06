package za.ac.cput.ExoticCarCustomz.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.domain.SprayPainter;
import za.ac.cput.ExoticCarCustomz.repository.SprayPainterRepository;
import za.ac.cput.ExoticCarCustomz.services.SprayPainterService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
@Service
public class SprayPainterImpl implements SprayPainterService {


    @Autowired
    SprayPainterRepository sprayPainterRepo;

    @Override
    public List<SprayPainter> getSprayPainter()
    {
        java.util.List<SprayPainter> allSprayPainter = new ArrayList<SprayPainter>();

        Iterable<SprayPainter> sprayPainters= sprayPainterRepo.findAll();

        for (SprayPainter sprayPainter : sprayPainters)
        {
            allSprayPainter.add(sprayPainter);
        }

        return allSprayPainter;
    }

    @Override
    public List<ServiceSheet> getServiceSheet(Long id)
    {
        return sprayPainterRepo.findOne(id).getServiceSheet();
    }
}
