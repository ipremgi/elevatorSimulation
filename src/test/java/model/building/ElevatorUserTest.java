package model.building;

import model.user.Client;
import model.user.ElevatorUser;
import model.user.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.PriorityQueue;

/**
 * Created by HWILKHU on 18/05/2017.
 */
public class ElevatorUserTest {

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
}
