package model.building;

import model.user.ElevatorUser;
import model.user.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Created by HWILKHU on 18/05/2017.
 */
public class FloorTest {
    private Floor floor;
    private Random random = new Random(1);

    @Before
    public void setup(){
        floor=new Floor();
    }

    @Test
    public void addUserGetWaitingForLift(){
        ElevatorUser user = new Employee(1,1,10,random);
        floor.addUser(user);

        Assert.assertEquals(user,floor.getWaitingForLift().peek());
    }

    @Test
    public void getSetButtonPressed(){
        floor.setBtnPressed(true);
        Assert.assertTrue(floor.isBtnPressed());
    }
}
