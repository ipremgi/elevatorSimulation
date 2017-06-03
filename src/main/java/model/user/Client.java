package model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Aishwarya on 05/05/2017.
 * Client extends the leaves, as the leaves class decides when and if the user of the elevator leaves the building.
 */

public class Client extends Leaves {

    private int ticksWaiting = 0;
    private boolean waiting = false;
    private boolean complained=false;

/**
 * The destination floor is set randomly using the random generator.
 * setTickDuration is used to decided the number of ticks a client is allowed to stay till.
 * @param CAPACITY - how many people are allowed in the elevator
 * @param  priority - users priority
 * @param  numberOfFloors - number of floors in the building
 * @param random - random generator to move floors
* */

    public Client(int CAPACITY, int priority, int numberOfFloors, Random random) {
        super("CLIENT_", random, CAPACITY, numberOfFloors, priority);
        this.setFloorsAccessible(determineFloorsAccessible());
        this.setDestFloor(this.getFloorsAccessible().get(randomGenerator.nextInt((this.getFloorsAccessible().size()))));
        this.setTickDuration(randomGenerator.nextInt(31)+60);//other classes
    }

    /**
     * This method determineFloorsAccessible ensure the client is allowed only on the floors they have access to.
     * client only has access to the bottom half of the building
     * */


    @Override
    protected List<Integer> determineFloorsAccessible(){
        List<Integer> floorsAccessible = new ArrayList<Integer>();

        for (int i = 0; i < (getNumberOfFloors()) / 2; i++) {
            floorsAccessible.add(i);
        }

        return floorsAccessible;
    }
    /**
     * sets the waiting
     * @param waiting - should wait or not for elevator
     * */

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    /**
     * If they should wait and have not complained then increment in tick number (tick waiting).
     * if ticksWaiting increments to more than 60 ticks which is equivalent to 10 minutes then they complaint.
     * @return - true, should complain.
     * @return - false, should not complain.
     * */
    public boolean shouldIComplain(){
        if (waiting && !complained){
            ticksWaiting++;
            if (ticksWaiting > 60){
                complained = true;
                leaveBuilding();
                return true;
            }
        }
        return false;
    }

}