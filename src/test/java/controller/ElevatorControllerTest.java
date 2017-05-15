package controller;


import junit.framework.Assert;
import model.building.Building;
import model.building.Elevator;
import model.user.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import view.ElevatorView;

/**
 * Created by HWILKHU on 06/05/2017.
 */
public class ElevatorControllerTest {

    private static ElevatorController controller;
    private static ElevatorView view;
    private static Building building;

    @Before
    public void setUp(){

        building = new Building(4,4);
        view = new ElevatorView();
        controller = new ElevatorController(building.getElevator(), view, building, 0.005);
    }


    /**
     * Test useCapacity method
     * Ensure correct values are return for the amount of capacity used in the Elevator
     */
    @Test
    public void testUsedCapacity(){
        ElevatorUser c = new Client(1,0,4);
        ElevatorUser e = new Employee(1,1,4);
        ElevatorUser d = new Developer(Company.MUGTOMES,1,1,4);

        controller.addPersonToElevator(c);
        Assert.assertTrue(controller.usedCapacity() == 1 );

        controller.addPersonToElevator(e);
        Assert.assertTrue(controller.usedCapacity() == 2);

        controller.addPersonToElevator(d);
        Assert.assertTrue(controller.usedCapacity() == 3);
    }


    /**
     * Testing canAddPersonToElevator method
     * Scenario - empty elevator with capacity of 4
     *          - add a person with capacity of 1
     *          - open door
     *          - should return true
     */
    @Test
    public void testCanAddPersonToElevator_1(){
        ElevatorUser c = new Client(1,0,4);
        controller.openElevatorDoor();

        Assert.assertTrue(controller.canAddPersonToElevator(c));
    }

    /**
     * Testing canAddPersonToElevator method
     * Scenario - empty elevator with capacity of 4
     *          - add a person with capacity of 1
     *          - closed door
     *          - should return false
     */
    @Test
    public void testCanAddPersonToElevator_2(){
        ElevatorUser c = new Client(1,0,4);
        Assert.assertTrue(!controller.canAddPersonToElevator(c));
    }

    /**
     * Testing canAddPersonToElevator method
     * Scenario - full elevator
     *          - add a person with capacity of 1
     *          - open door
     *          - should return false
     */
    @Test
    public void testCanAddPersonToElevator_3(){
        ElevatorUser mc = new MaintenanceCrew(4,0,4);
        ElevatorUser c = new Client(4,0,4);
        controller.openElevatorDoor();

        controller.addPersonToElevator(mc);

        Assert.assertTrue(!controller.canAddPersonToElevator(c));
    }

    /**
     * Testing canAddPersonToElevator method
     * Scenario - elevator with 1 developer
     *          - add a developer working for same company
     *          - open door
     *          - should return true
     */
    @Test
    public void testCanAddPersonToElevator_4(){
        ElevatorUser d1 = new Developer(Company.MUGTOMES, 1, 1,4);
        ElevatorUser d2 = new Developer(Company.MUGTOMES,1,0,4);
        controller.openElevatorDoor();

        controller.addPersonToElevator(d1);

        Assert.assertTrue(controller.canAddPersonToElevator(d2));
    }

    /**
     * Testing canAddPersonToElevator method
     * Scenario - elevator with 1 developer
     *          - add a developer working for same company
     *          - open door
     *          - should return true
     */
    @Test
    public void testCanAddPersonToElevator_5(){
        ElevatorUser d1 = new Developer(Company.MUGTOMES, 1, 1,4);
        ElevatorUser d2 = new Developer(Company.GOGGLES,1,0,4);
        controller.openElevatorDoor();

        controller.addPersonToElevator(d1);

        Assert.assertTrue(!controller.canAddPersonToElevator(d2));
    }





}
