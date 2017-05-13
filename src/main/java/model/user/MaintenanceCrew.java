package model.user;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aishwarya on 05/05/2017.
 */
public class MaintenanceCrew extends ElevatorUser {

    private int duration;
    private  int minFloor;

    public MaintenanceCrew (int capacity, int destFloor, int maxFloors, int priority ) {
        super("maintenancecrew");
        this.setCapacity(capacity);
        this.setDestFloor(destFloor);
        this.setMaxFloors(maxFloors);
        this.setPriority(priority);
    }

    @Override
    protected List<Integer> determineFloorsAccessible() {
        List<Integer> floorsAccessible = new ArrayList<Integer>();
        floorsAccessible.add(0);
        floorsAccessible.add(this.getMaxFloors());
        return floorsAccessible;
    }

    //Between 20 and 40 minutes after
    //they arrive at their desired floor, they will also go to the ground floor and leave the building - ticks
    public void leaveBuilding() {
        setDestFloor(0);
    }

    public void moveFloor() {
        //will arrive and go to the top floor, taking up 4 spaces with their equipment and materials. After they complete their work, they will return to the ground floor and leave.
    }

}



