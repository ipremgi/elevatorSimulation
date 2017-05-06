package model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Aishwarya on 05/05/2017.
 */
public class Client extends ElevatorUser {


    private int duration;
    private Random randomGenerator;

    public Client(Integer capacity, Integer destFloor, double probability) {
        this.setCapacity(capacity);
        this.setProbabilty(probability);
        this.setDestFloor(destFloor);

        List<Integer> floorsAccessible = new ArrayList<Integer>();

        for (int i = 0; i <= getMaxFloors() / 2; i++) {
            floorsAccessible.add(i);
        }
        this.setFloorsAccessable(floorsAccessible);

        //set a random time they will leave between their two parameters
    }


//    public boolean fileComplaint() {
//
//    }

    public void leaveBuilding() {
        setDestFloor(0);
    }

    public void moveFloor() {
        //will enter the building and go to one of the floors in the bottom half of the building
        // (which may include the ground floor). After they complete their business, they will return to the ground floor and leave.

        int randomFloor = randomGenerator.nextInt(getFloorsAccessable().size());
        setDestFloor(getFloorsAccessable().get(randomFloor));
    }

    public void shouldILeave() {


        //check that they have reached their randomly assigned time
        if (duration >= 10 && duration <= 90) {
            leaveBuilding();
        } else {
        }


    }


    public boolean shouldIFileComplaint() {
        if (duration <= 60) {
            //moveFloor(); //PRIORITY QUEUE

            return false;

        } else {
            return true;
        }

        //figure out how many ticks for that number of time


    }

}

/*
1 tick is 10 sec
 6 tick is 60 sec
        60 tick is 10 min
        90 tick is 30 min

 */

/*
* sets the move floor using probabilty
* */

