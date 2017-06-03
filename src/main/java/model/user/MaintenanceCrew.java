package model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Aishwarya on 05/05/2017.
 */
public class MaintenanceCrew extends Leaves {

    /**
     * The destination floor is set randomly using the random generator.
     * Maintenance crew has the name of MAIN_CREW_
     * Between 20 and 40 minutes of their arrival on floor, they will return to ground floor and leave the building, which equals to 121-241 ticks.
     * @param CAPACITY - how many people are allowed in the elevator
     * @param  priority - users priority
     * @param  numberOfFloors - number of floors in the building
     * @param random - random generator to move floors
     */

    public MaintenanceCrew (int CAPACITY, int numberOfFloors, int priority, Random random) {
        super("MAIN_CREW_", random, CAPACITY, numberOfFloors, priority);
        this.setFloorsAccessible(determineFloorsAccessible());
        this.setDestFloor(getFloorsAccessible().get(0));
        this.setTickDuration(randomGenerator.nextInt(121)+120);
    }


    /**
     * This methods determineFloorsAccessible ensure the maintenance crew  are allowed only on the floors they have access to.
     *THey only have access to top floor and ground.
     * */
    @Override
    protected List<Integer> determineFloorsAccessible() {
        ArrayList<Integer> fa = new ArrayList<Integer>();
        fa.add((getNumberOfFloors() - 1));
        return fa;
    }




}