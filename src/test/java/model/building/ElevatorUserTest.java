package model.building;

import model.user.Client;
import model.user.ElevatorUser;
import model.user.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by HWILKHU on 18/05/2017.
 */
public class ElevatorUserTest {

    Floor floor;

    @Before
    public void setup(){
        floor = new Floor();
    }

    @Test
    public void priorityComparison() throws InterruptedException {
        Client client = new Client(1,2,10);
        Employee employeeA = new Employee(1,1,10);
        Employee employeeB = new Employee(1,1,10);

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
}
