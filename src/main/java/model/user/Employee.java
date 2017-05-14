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
     * @param destFloor
     * @param priority
     * @param numberOfFloors
     */
    public Employee (int capacity, int destFloor , int priority, int numberOfFloors ) {
        super("employee");
        this.setCapacity(capacity);
        this.setNumberOfFloors(numberOfFloors);
        this.setFloorsAccessible(determineFloorsAccessible());
        this.setDestFloor(randomGenerator.nextInt(numberOfFloors));
        this.setPriority(priority);

    }

    @Override
    protected List<Integer> determineFloorsAccessible() {

        List<Integer> floorsAccessible = new ArrayList<Integer>();
        for (int i = 0; i <= getNumberOfFloors(); i++) {
            floorsAccessible.add(i);
        }
        return floorsAccessible;
    }

    public void moveFloor() {
        //int randomFloor = randomGenerator.nextInt(getNumberOfFloors());
        do{
            setDestFloor(randomGenerator.nextInt(getNumberOfFloors()));
        }while (getCurrentFloor() == getDestFloor());
        //any floor same probability
    }
}
