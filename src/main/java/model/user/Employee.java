package model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Aishwarya on 05/05/2017.
 */
public class Employee extends ElevatorUser {
    /**
     * The destination floor is set randomly using the random generator.
     * @param CAPACITY - how many people are allowed in the elevator
     * @param  priority - users priority
     * @param  numberOfFloors - number of floors in the building
     * @param random - random generator to move floors
     */
    public Employee (int CAPACITY, int priority, int numberOfFloors, Random random) {
        super("EMP_", random, CAPACITY, numberOfFloors, priority);
        this.setFloorsAccessible(determineFloorsAccessible());
        this.setDestFloor(randomGenerator.nextInt(numberOfFloors));
    }

    /**
     * This methods determineFloorsAccessible ensure the employees are allowed only on the floors they have access to.
     * the client have access to all floors
     * @return the floors accessible.
     * */

    @Override
    protected List<Integer> determineFloorsAccessible() {

        List<Integer> floorsAccessible = new ArrayList<Integer>();
        for (int i = 0; i < getNumberOfFloors(); i++) {
            floorsAccessible.add(i);
        }
        return floorsAccessible;
    }
}
