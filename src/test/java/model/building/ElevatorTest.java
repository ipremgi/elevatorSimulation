package model.building;

import model.user.ElevatorUser;
import model.user.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by HWILKHU on 20/05/2017.
 */
public class ElevatorTest {

    private Elevator elevator;
    private Random random = new Random(1);

    @Before
    public void setup(){
        elevator = new Elevator(4);
    }

    @Test
    public void getSetFloor(){
        elevator.setFloor(10);

        Assert.assertEquals(10,elevator.getFloor());
    }

    @Test
    public void getMaxCapacity(){
        Assert.assertEquals(4,elevator.getMAX_CAPACITY());
    }

    @Test
    public void getSetDirection(){
        elevator.setDirection(Direction.DOWN);

        Assert.assertEquals(Direction.DOWN,elevator.getDirection());
    }

    @Test
    public void getSetDoorStatus(){
        elevator.setDoorStatus(DoorStatus.CLOSED);

        Assert.assertEquals(DoorStatus.CLOSED,elevator.getDoorStatus());
    }

    @Test
    public void elevatorOccupantOperations(){
        ElevatorUser employee = new Employee(1,1,10,random);
        ArrayList<ElevatorUser> elevatorOccupants = new ArrayList<ElevatorUser>();

        elevator.addUser(employee);
        elevatorOccupants.add(employee);

        Assert.assertEquals(elevatorOccupants,elevator.getUsers());

        elevator.removePerson(employee);
        elevatorOccupants.remove(employee);

        Assert.assertEquals(elevatorOccupants,elevator.getUsers());

    }
}
