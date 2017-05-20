package model.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by HWILKHU on 20/05/2017.
 */
public class LeavesTest {
    private Leaves client;

    @Before
    public void setup(){
        client = new Client(1,1,10,10);
    }

    @Test
    public void leaveBuilding(){
        client.leaveBuilding();

        Assert.assertEquals(0,client.getDestFloor());
    }

    @Test
    public void shouldTheyLeaveTheBuilding(){
        client.setCurrentFloor(client.getDestFloor());
        client.setTickDuration(1);
        client.shouldILeave();

        Assert.assertEquals(0,client.getDestFloor());
        Assert.assertFalse(client.isRemoveMe());

        client.setCurrentFloor(0);
        client.shouldILeave();

        Assert.assertTrue(client.isRemoveMe());
    }
}
