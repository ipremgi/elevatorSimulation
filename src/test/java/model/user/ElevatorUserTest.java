package model.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by HWILKHU on 18/05/2017.
 */
public class ElevatorUserTest {

    ElevatorUser user;

    @Before
    public void setup(){
        user = new Employee(1,1,10,10);
    }

    @Test
    public void priorityComparison() throws InterruptedException {
        ElevatorUser client = new Client(1,2,10,10);
        ElevatorUser employeeA = new Employee(1,1,10,10);
        ElevatorUser employeeB = new Employee(1,1,10,10);

        PriorityQueue<ElevatorUser> priorityQueue = new PriorityQueue<ElevatorUser>();

        employeeB.setTimeAddedToQueue(System.currentTimeMillis());
        priorityQueue.add(employeeB);
        Thread.sleep(1);
        employeeA.setTimeAddedToQueue(System.currentTimeMillis());
        priorityQueue.add(employeeA);
        client.setTimeAddedToQueue(System.currentTimeMillis());
        priorityQueue.add(client);

        Assert.assertEquals(client,priorityQueue.poll());
        Assert.assertEquals(employeeB,priorityQueue.poll());
        Assert.assertEquals(employeeA, priorityQueue.poll());

    }

    @Test
    public void equals(){

        ElevatorUser user1 = new Client(1,2,10,10);
        ElevatorUser user2 = new Employee(1,1,10,10);

        Assert.assertTrue(user1 == user1);
        Assert.assertTrue(user2 == user2);
        Assert.assertTrue(user2 != user1);
    }

    @Test
    public void getSetCurrentFloor(){
        user.setCurrentFloor(10);

        Assert.assertEquals(10,user.getCurrentFloor());
    }

    @Test
    public void getSetDestinationFloor(){
        user.setDestFloor(10);

        Assert.assertEquals(10,user.getDestFloor());
    }

    @Test
    public void getSetTimeAddedToQueue(){
        long time = System.currentTimeMillis();
        user.setTimeAddedToQueue(time);

        Assert.assertEquals(time,user.getTimeAddedToQueue());
    }

    @Test
    public void getID(){
        Assert.assertTrue(user.getID().contains("employee"));
    }

    @Test
    public void getSetNumberOfFloors(){
        user.setNumberOfFloors(18);

        Assert.assertEquals(18,user.getNumberOfFloors());
    }

    @Test
    public void getSetFloorsAccessible(){
        ArrayList<Integer> floorsAccessible = new ArrayList<Integer>();
        floorsAccessible.add(1);
        floorsAccessible.add(2);
        user.setFloorsAccessible(floorsAccessible);

        Assert.assertEquals(floorsAccessible,user.getFloorsAccessible());
    }

    @Test
    public void getCapacity(){
        Assert.assertEquals(1,user.getCAPACITY());
    }

    @Test
    public void getSetPriority(){
        user.setPriority(5);

        Assert.assertEquals(5,user.getPriority());
    }
}
