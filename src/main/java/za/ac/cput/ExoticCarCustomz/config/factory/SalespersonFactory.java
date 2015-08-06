package za.ac.cput.ExoticCarCustomz.config.factory;

import za.ac.cput.ExoticCarCustomz.domain.SalesInvoice;
import za.ac.cput.ExoticCarCustomz.domain.Salesperson;
import za.ac.cput.ExoticCarCustomz.domain.ServiceSheet;

import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
public class SalespersonFactory {

    public static Salesperson createSalesperson(String firstName, String lastName, int hours, double rate, int DailySales, List<SalesInvoice> salesInvoice)
    {
        Salesperson salesperson = new Salesperson.Builder(lastName).firstName(firstName).hours(hours).rate(rate).DailySales(DailySales).salesInvoice(salesInvoice).build();

        return salesperson;
    }
}
