package model.building;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by HWILKHU on 20/05/2017.
 */
public class BuildingTest {
    private Building building;

    @Before
    public void setup(){
        building = new Building(10,10);
    }

    @Test
    public void getSetFloors(){
        Assert.assertEquals(10,building.getFloors().size());
    }

    @Test
    public void getSetComplaints(){
        building.addComplaint();
        Assert.assertEquals(1,building.getNoOfComplaints());
    }

    @Test
    public void getElevator(){
        Assert.assertTrue(building.getElevator() instanceof Elevator);
    }
}
