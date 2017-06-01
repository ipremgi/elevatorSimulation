package model.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by HWILKHU on 21/05/2017.
 */
public class ClientTest {
    private Client client;
    private Random random = new Random(1);

    @Before
    public void setup(){
        client = new Client(1,1,10,random);
    }

    @Test
    public void determineFloorsAccessible(){
        ArrayList<Integer> floorsAccessible = new ArrayList<Integer>();
        floorsAccessible.add(0);
        floorsAccessible.add(1);
        floorsAccessible.add(2);
        floorsAccessible.add(3);
        floorsAccessible.add(4);

        Assert.assertEquals(floorsAccessible,client.getFloorsAccessible());
    }

    @Test
    public void checkClientComplainsCorrectly(){
        client.setWaiting(true);

        for (int i = 0; i < 60; i++){
            client.shouldIComplain();
        }

        Assert.assertTrue(client.shouldIComplain());
        Assert.assertEquals(0,client.getDestFloor());
    }
}
