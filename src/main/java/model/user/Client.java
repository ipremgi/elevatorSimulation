package model.user;

import simulator.SimulatorTick;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Aishwarya on 05/05/2017.
 * Clients will enter the building and go to one of the floors in the bottom half of the building (which may include the ground floor).
 * After they complete their business, they will return to the ground floor and leave.
 */
public class Client extends ElevatorUser {

    private SimulatorTick tick;
    private int tickDuration;


    public Client(int capacity, int destFloor, SimulatorTick tick,int priority) {
        super("client");
        this.setCapacity(capacity);
        this.setDestFloor(destFloor);
        this.tick=tick;
        this.setPriority(priority);
        this.setFloorsAccessible(determineFloorsAccessible());
        this.tickDuration = tick.getTick() + randomGenerator.nextInt(30)+60;//other classes
    }

    @Override
    protected List<Integer> determineFloorsAccessible(){
        List<Integer> floorsAccessible = new ArrayList<Integer>();

        for (int i = 0; i <= getMaxFloors() / 2; i++) {
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
    }

    public void shouldILeave() {
        //check that they have reached their randomly assigned time
        if (tick.getTick() == tickDuration) {
            leaveBuilding();
        }
    }

   // in here?
    public boolean shouldIFileComplaint() {
        if (tick.getTick() <= 60) {
            //moveFloor(); //PRIORITY QUEUE
            return false;

        } else {
            return true;
        }


    }
}


/*
* sets the move floor using probabilty
* */

