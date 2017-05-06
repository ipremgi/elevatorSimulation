package model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Aishwarya on 05/05/2017.
 */
public class Employee extends ElevatorUser {

    private Random randomGenerator;

    public Employee (Integer capacity, Integer destFloor, double probability ) {

        this.setCapacity(capacity);
        this.setProbabilty(probability);
        this.setDestFloor(destFloor);

        List<Integer> floorsAccessible = new ArrayList<Integer>();

        for (int i = 0; i <= getMaxFloors(); i++) {
            floorsAccessible.add(i);
        }

        this.setFloorsAccessable(floorsAccessible);
    }

    public void leaveBuilding() {
        setDestFloor(0);

    }


    public void moveFloor() {
        int randomFloor = randomGenerator.nextInt(getFloorsAccessable().size());
        setDestFloor(getFloorsAccessable().get(randomFloor));

        //any floor same probability

    }
}
