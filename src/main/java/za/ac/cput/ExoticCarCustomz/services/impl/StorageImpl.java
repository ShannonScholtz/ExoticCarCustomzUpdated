package za.ac.cput.ExoticCarCustomz.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ExoticCarCustomz.domain.Storage;
import za.ac.cput.ExoticCarCustomz.repository.StorageRepository;
import za.ac.cput.ExoticCarCustomz.services.StorageService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/04.
 */
@Service
public class StorageImpl implements StorageService {

    @Autowired
    StorageRepository serviceSheetRepo;

    @Override
    public List<Storage> getStorage()
    {
        List<Storage> allStorage = new ArrayList<Storage>();

        Iterable<Storage> serviceSheets= serviceSheetRepo.findAll();

        for (Storage storage : serviceSheets)
        {
            allStorage.add(storage);
        }

        return allStorage;
    }
}
