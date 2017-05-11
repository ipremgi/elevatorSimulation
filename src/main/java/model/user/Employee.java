package model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Aishwarya on 05/05/2017.
 */
public class Employee extends ElevatorUser {

    private Random randomGenerator;

    public Employee (int capacity, int destFloor, double probability , int priority, int maxFloors ) {
        super("employee");
        this.setCapacity(capacity);
        this.setProbabilty(probability);
        this.setDestFloor(destFloor);
        this.setPriority(priority);
        this.setMaxFloors(maxFloors);
    }

    @Override
    protected List<Integer> determineFloorsAccessible() {

        List<Integer> floorsAccessible = new ArrayList<Integer>();
        for (int i = 0; i <= getMaxFloors(); i++) {
            floorsAccessible.add(i);
        }
        return floorsAccessible;
    }

    public void leaveBuilding() {
        setDestFloor(0);
    }

    public void moveFloor() {
        int randomFloor = randomGenerator.nextInt(getFloorsAccessible().size());
        setDestFloor(getFloorsAccessible().get(randomFloor));
        //any floor same probability
    }
}
