package za.ac.cput.ExoticCarCustomz.services;

import za.ac.cput.ExoticCarCustomz.domain.Mechanic;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;

import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
public interface MechanicService {

    List<Mechanic> getMechanic();

   List<ServiceSheet> getServiceSheet(Long id);
}
