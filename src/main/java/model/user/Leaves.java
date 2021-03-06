package model.user;

import java.util.Random;

/**
 * Created by HWILKHU on 14/05/2017.
 */
public abstract class Leaves extends ElevatorUser {

    private int tickDuration;
    private boolean leaving = false;
    private boolean removeMe = false;

    public Leaves(String className, Random random, int CAPACITY, int numberOfFloors, int priority) {
        super(className,random,CAPACITY, numberOfFloors, priority);
    }

    public void leaveBuilding() {
        setDestFloor(0);
    }

    public void shouldILeave() {
        //check that they have reached their randomly assigned time
        if (getCurrentFloor() == getDestFloor() && !leaving){
            tickDuration--;
            if (tickDuration == 0) {
                leaving = true;
                leaveBuilding();
            }
        }else if(getCurrentFloor() == getDestFloor() && leaving){
            this.removeMe = true;
        }
    }

    public boolean isRemoveMe() {
        return removeMe;
    }

    public void setTickDuration(int tickDuration) {
        this.tickDuration = tickDuration;
    }

}
