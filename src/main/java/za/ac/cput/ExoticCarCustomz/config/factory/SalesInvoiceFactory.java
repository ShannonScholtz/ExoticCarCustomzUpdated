package za.ac.cput.ExoticCarCustomz.config.factory;

import za.ac.cput.ExoticCarCustomz.domain.SalesInvoice;

/**
 * Created by student on 2015/07/30.
 */
public class SalesInvoiceFactory {

    public static SalesInvoice createSalesInvoice(String date, double amount)
    {
        SalesInvoice salesInvoice = (new SalesInvoice.Builder(date).amount(amount).build());

        return salesInvoice;
    }
}
