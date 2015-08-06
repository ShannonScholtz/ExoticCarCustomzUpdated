package za.ac.cput.ExoticCarCustomz.config.factory;

import za.ac.cput.ExoticCarCustomz.domain.Storage;

/**
 * Created by student on 2015/08/04.
 */
public class StorageFactory {

    public static Storage createStorage(String RegistrationNumber, String Make, String Model, String Colour, String year, double StoragePeriodInMonths, double MonthlyStorageCost, double totalStorageCost)
    {
        Storage storage = new Storage.Builder(RegistrationNumber).Make(Make).Model(Model).Colour(Colour).year(year).StoragePeriodInMonths(StoragePeriodInMonths).MonthlyStorageCost(MonthlyStorageCost).totalStorageCost(totalStorageCost).build();

        return storage;
    }
}
