package model.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by HWILKHU on 21/05/2017.
 */
public class MaintenanceTest {
    private MaintenanceCrew maintenanceCrew;

    @Before
    public void setup(){
        maintenanceCrew = new MaintenanceCrew(1,10,1,10);
    }

    @Test
    public void determineFloorsAccessible(){
        Assert.assertEquals(1,maintenanceCrew.getFloorsAccessible().size());
        Assert.assertEquals(9,(int) maintenanceCrew.getFloorsAccessible().get(0));
    }
}
