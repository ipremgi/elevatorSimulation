package controller;


import gui.frames.Simulation;
import junit.framework.Assert;
import model.building.Building;
import model.building.Direction;
import model.user.*;
import org.junit.Before;
import org.junit.Test;
import view.ElevatorView;

/**
 * Created by IPREMGI on 06/05/2017.
 */
public class BuildingControllerTest {

    private static BuildingController controller;
    private static ElevatorView view;
    private static Building building;

    @Before
    public void setUp(){

        building = new Building(4,4);
        view = new ElevatorView(new Simulation(null));
        controller = new BuildingController(view, building, 0.005);
    }


    /**
     * Test useCapacity method
     * Scenario - Add User to elevator and check used capacity
     *          - should return the total of capacity of the users in the elevator
     */
    @Test
    public void testUsedCapacity(){
        ElevatorUser c = new Client(1,0,4,50);
        ElevatorUser e = new Employee(1,1,4,50);
        ElevatorUser d = new Developer(Company.MUGTOMES,2,1,4,50);


        controller.addPersonToElevator(c);
        Assert.assertTrue(controller.usedCapacity() == 1 );

        controller.addPersonToElevator(e);
        Assert.assertTrue(controller.usedCapacity() == 2);

        controller.addPersonToElevator(d);
        Assert.assertTrue(controller.usedCapacity() == 4);
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

        ElevatorUser c = new Client(1,0,4,50);
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
        ElevatorUser c = new Client(1,0,4,50);

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
        ElevatorUser mc = new MaintenanceCrew(4,0,4,50);
        ElevatorUser c = new Client(4,0,4,50);

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
        ElevatorUser d1 = new Developer(Company.MUGTOMES, 1, 1,4,50);
        ElevatorUser d2 = new Developer(Company.MUGTOMES,1,0,4,50);

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
        ElevatorUser d1 = new Developer(Company.MUGTOMES, 1, 1,4,50);
        ElevatorUser d2 = new Developer(Company.GOGGLES,1,0,4,50);

        controller.openElevatorDoor();

        controller.addPersonToElevator(d1);

        Assert.assertTrue(!controller.canAddPersonToElevator(d2));
    }


    /**
     * DISCUSS WITH AISHU & HARDISH IN CALL
     * Testing leaveElevator method
     * Scenario - check the correct person leaves the elevator
     *          - elevator should have the correct amount users after calling the leaving method
     */
    @Test
    public void testLeaveElevator(){
        ElevatorUser c = new Developer(Company.MUGTOMES,1,0,4,50);
        c.setDestFloor(2);

        ElevatorUser d = new Developer(Company.MUGTOMES, 1, 0, 4,50);
        d.setDestFloor(2);

        ElevatorUser e = new Employee(1,0,4,50);

        e.setDestFloor(4);

        controller.openElevatorDoor();
        controller.addPersonToElevator(c);
        controller.addPersonToElevator(d);
        controller.addPersonToElevator(e);
        controller.closeElevatorDoor();

        Assert.assertTrue(controller.usedCapacity() == 3);

        controller.moveElevator(2);
        controller.openElevatorDoor();
        controller.leaveElevator();
        controller.closeElevatorDoor();

        Assert.assertTrue(controller.usedCapacity() == 1);

        controller.moveElevator(4);
        controller.openElevatorDoor();
        controller.leaveElevator();
        controller.closeElevatorDoor();

        Assert.assertTrue(controller.usedCapacity() == 0);
    }

    /**
     * Testing calculateNextFloor method
     * Scenario - set elevator direction to UP
     *          - set dest floor for users
     *          - should return next floor to go to
     *          - change direction to DOWN
     *          - should the next floor to go to
     */
    @Test
    public void testCalculateNextFloor(){
        building.getElevator().setDirection(Direction.UP);

        ElevatorUser e  = new Employee(1,0,6,50);
        e.setDestFloor(6); // setting the destination for person

        ElevatorUser d1 = new Developer(Company.GOGGLES, 1,0,6,50);
        d1.setDestFloor(5);

        ElevatorUser d2 = new Developer(Company.GOGGLES, 1,0,6,50);

        d2.setDestFloor(2);

        // Add users to elevator
        controller.openElevatorDoor();
        controller.addPersonToElevator(e);
        controller.addPersonToElevator(d1);
        controller.addPersonToElevator(d2);
        controller.closeElevatorDoor();

        building.getElevator().setFloor(3);
        Assert.assertTrue(controller.calculateNextFloor() == 5);

        building.getElevator().setDirection(Direction.DOWN);
        Assert.assertTrue(controller.calculateNextFloor() == 2);

    }

    /**
     * Testing moveElevator method
     * Scenario - set the elevator floor
     *          - check the elevator current floor
     *          - should be the same as the value used to set
     */
    @Test
    public void testMoveElevator(){
        controller.moveElevator(4);
        Assert.assertTrue(building.getElevator().getFloor() == 4);

        controller.moveElevator(2);
        Assert.assertTrue(building.getElevator().getFloor() == 2);
    }




}
