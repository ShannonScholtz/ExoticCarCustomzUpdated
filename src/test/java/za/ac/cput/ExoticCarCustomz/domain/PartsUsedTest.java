package za.ac.cput.ExoticCarCustomz.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.ExoticCarCustomz.config.factory.PartsUsedFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/31.
 */
public class PartsUsedTest {

    @Test
    public void testCreate() throws Exception
    {

        PartsUsed partsUsed = PartsUsedFactory.createPartsUsed("CMPTR454", "Bmw 325i E93 Computer-Box", 35000.00);

        Assert.assertEquals("CMPTR454", partsUsed.getPartNumber());
        Assert.assertEquals("Bmw 325i E93 Computer-Box", partsUsed.getDescription());
        Assert.assertEquals(35000.00, partsUsed.getPrice(), 0.2f);
    }

    @Test
    public void testUpdate() throws Exception
    {
        List<ServiceSheet> serviceSheet = new ArrayList();

        PartsUsed partsUsed = PartsUsedFactory.createPartsUsed("CMPTR454", "Bmw 325i E93 Computer-Box", 35000.00);

        PartsUsed newPartsUsed = new PartsUsed.Builder(partsUsed.getPartNumber()).copy(partsUsed).description("VW Golf 5 Gti Computer-Box").build();

        Assert.assertEquals("Bmw 325i E93 Computer-Box", partsUsed.getDescription());
        Assert.assertEquals("VW Golf 5 Gti Computer-Box", newPartsUsed.getDescription());
    }
}
