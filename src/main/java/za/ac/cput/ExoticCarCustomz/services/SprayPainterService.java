package za.ac.cput.ExoticCarCustomz.services;

import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;
import za.ac.cput.ExoticCarCustomz.domain.SprayPainter;

import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
public interface SprayPainterService {

    List<SprayPainter> getSprayPainter();

    List<ServiceSheet> getServiceSheet(Long id);
}
