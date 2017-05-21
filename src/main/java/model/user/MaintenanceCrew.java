package model.user;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aishwarya on 05/05/2017.
 */
public class MaintenanceCrew extends Leaves {

    public MaintenanceCrew (int capacity, int numberOfFloors, int priority, int seed) {
        super("maintenancecrew",seed);
        this.setCapacity(capacity);
        this.setNumberOfFloors(numberOfFloors);
        this.setFloorsAccessible(determineFloorsAccessible());
        this.setDestFloor(getFloorsAccessible().get(0));
        this.setPriority(priority);
        this.setTickDuration(randomGenerator.nextInt(121)+120);
    }

    @Override
    protected List<Integer> determineFloorsAccessible() {
        ArrayList<Integer> fa = new ArrayList<Integer>();
        fa.add((getNumberOfFloors() - 1));
        return fa;
    }

    //Between 20 and 40 minutes after
    //they arrive at their desired floor, they will also go to the ground floor and leave the building - ticks


}