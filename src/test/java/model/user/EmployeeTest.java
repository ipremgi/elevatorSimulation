package model.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by HWILKHU on 20/05/2017.
 */
public class EmployeeTest {
    private Employee employee;

    @Before
    public void setup(){
        employee = new Employee(1,1,10,10);
    }

    @Test
    public void determineFloorsAccessible(){
        Assert.assertEquals(10,employee.determineFloorsAccessible().size());
    }

    @Test
    public void moveFloor(){
        employee.moveFloor();

        Assert.assertTrue(employee.getFloorsAccessible().contains(employee.getDestFloor()));
        Assert.assertTrue(employee.getDestFloor() != employee.getCurrentFloor());
    }
}
