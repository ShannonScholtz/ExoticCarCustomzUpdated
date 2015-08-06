package za.ac.cput.ExoticCarCustomz.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ExoticCarCustomz.domain.SalesInvoice;
import za.ac.cput.ExoticCarCustomz.repository.SalesInvoiceRepository;
import za.ac.cput.ExoticCarCustomz.services.SalesInvoiceService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
@Service
public class SalesInvoiceImpl implements SalesInvoiceService{

    @Autowired
    SalesInvoiceRepository salesInvoiceRepo;

    @Override
    public List<SalesInvoice> getSalesInvoice()
    {
        java.util.List<SalesInvoice> allSalesInvoice = new ArrayList<SalesInvoice>();

        Iterable<SalesInvoice> SalesInvoices = salesInvoiceRepo.findAll();

        for (SalesInvoice SalesInvoice : SalesInvoices)
        {
            allSalesInvoice.add(SalesInvoice);
        }

        return allSalesInvoice;
    }
}
