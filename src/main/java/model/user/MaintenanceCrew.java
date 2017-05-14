package model.user;

import simulator.SimulatorTick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aishwarya on 05/05/2017.
 */
public class MaintenanceCrew extends ElevatorUser {

    private int duration;
    private int minFloor;
    private int tickDuration;
    private SimulatorTick tick;

    public MaintenanceCrew (int capacity, int destFloor, int maxFloors, int priority, SimulatorTick tick) {
        super("maintenancecrew");
        this.setCapacity(capacity);
        this.setDestFloor(destFloor);
        this.setMaxFloors(maxFloors);
        this.setPriority(priority);
        this.tick=tick;
        this.tickDuration =tick.getTick() + randomGenerator.nextInt(120)+120;
    }

    @Override
    protected List<Integer> determineFloorsAccessible() {
        List<Integer> floorsAccessible = new ArrayList<Integer>();
        floorsAccessible.add(0);
        floorsAccessible.add(this.getMaxFloors());
        return floorsAccessible;
    }

    public void shouldILeave() {
        //check that they have reached their randomly assigned time
        if (tick.getTick() == tickDuration) {
            leaveBuilding();
        }
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



