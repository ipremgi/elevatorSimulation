package model.user;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aishwarya on 05/05/2017.
 */
public class Employee extends ElevatorUser {
    /**
     *
     * @param capacity
     * @param priority
     * @param numberOfFloors
     */
    public Employee (int capacity, int priority, int numberOfFloors,int seed) {
        super("employee",seed);
        this.setCapacity(capacity);
        this.setNumberOfFloors(numberOfFloors);
        this.setFloorsAccessible(determineFloorsAccessible());
        this.setDestFloor(randomGenerator.nextInt(numberOfFloors));
        this.setPriority(priority);

    }

    @Override
    protected List<Integer> determineFloorsAccessible() {

        List<Integer> floorsAccessible = new ArrayList<Integer>();
        for (int i = 0; i < getNumberOfFloors(); i++) {
            floorsAccessible.add(i);
        }
        return floorsAccessible;
    }
}
