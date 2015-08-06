package za.ac.cput.ExoticCarCustomz.services;

import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.domain.Technician;

import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
public interface TechnicianService {

    List<Technician> getTechnician();

    List<ServiceSheet> getServiceSheet(Long id);
}
