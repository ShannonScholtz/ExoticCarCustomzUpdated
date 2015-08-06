package za.ac.cput.ExoticCarCustomz.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;



/**
 * Created by student on 2015/07/31.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CarTest.class,
        CustomerTest.class,
        MechanicTest.class,
        PartsUsedTest.class,
        SalesInvoiceTest.class,
        SalespersonTest.class,
        ServiceSheetTest.class,
        SprayPainterTest.class,
        TechnicianTest.class,
        StorageTest.class
})
public class DomainTestSuite {
}
