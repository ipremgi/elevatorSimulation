package model.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by HWILKHU on 21/05/2017.
 */
public class DeveloperTest {
    private Developer developer;

    @Before
    public void setup(){
        developer = new Developer(Company.MUGTOMES,1,1,10,10);
    }

    @Test
    public void getCompany(){
        Assert.assertEquals(Company.MUGTOMES,developer.getCompany());
    }

    @Test
    public void determineFloorsAccessible(){
        ArrayList<Integer> floorsAccessible = new ArrayList<>();
        floorsAccessible.add(9);
        floorsAccessible.add(8);
        floorsAccessible.add(7);
        floorsAccessible.add(6);
        floorsAccessible.add(5);
        Assert.assertEquals(floorsAccessible,developer.getFloorsAccessible());
    }
}
