package model.user;

import simulator.SimulatorTick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aishwarya on 05/05/2017.
 * Clients will enter the building and go to one of the floors in the bottom half of the building (which may include the ground floor).
 * After they complete their business, they will return to the ground floor and leave.
 */
public class Client extends Leaves {

    private int ticksWaiting = 0;
    private boolean waiting = false;

    public Client(int capacity, int priority, int numberOfFloors) {
        super("client");
        this.setCapacity(capacity);
        this.setPriority(priority);
        this.setNumberOfFloors(numberOfFloors);
        this.setFloorsAccessible(determineFloorsAccessible());
        this.setDestFloor(this.getFloorsAccessible().get(randomGenerator.nextInt((this.getFloorsAccessible().size() - 1))));
        this.setTickDuration(randomGenerator.nextInt(30)+60);//other classes
    }

    @Override
    protected List<Integer> determineFloorsAccessible(){
        List<Integer> floorsAccessible = new ArrayList<Integer>();

        for (int i = 0; i < (getNumberOfFloors() - 1) / 2; i++) {
            floorsAccessible.add(i);
        }

        System.out.println(floorsAccessible);

        return floorsAccessible;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public boolean shouldIComplain(){
        if (waiting){
            ticksWaiting++;
            if (ticksWaiting >= 60){
                return true;
            }
        }
        return false;
    }
}


/*
* sets the move floor using probabilty
* */

