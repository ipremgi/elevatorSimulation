package model.user;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aishwarya on 05/05/2017.
 */
public class MaintenanceCrew extends Leaves {

    public MaintenanceCrew (int capacity, int numberOfFloors, int priority) {
        super("maintenancecrew");
        this.setCapacity(capacity);
        this.setNumberOfFloors(numberOfFloors);
        this.setDestFloor(determineFloorsAccessible().get(0) - 1);
        this.setPriority(priority);
        this.setTickDuration(randomGenerator.nextInt(120)+120);
    }

    @Override
    protected List<Integer> determineFloorsAccessible() {
        ArrayList<Integer> fa = new ArrayList<>();
        fa.add(getNumberOfFloors());
        return fa;
    }

    //Between 20 and 40 minutes after
    //they arrive at their desired floor, they will also go to the ground floor and leave the building - ticks


}



