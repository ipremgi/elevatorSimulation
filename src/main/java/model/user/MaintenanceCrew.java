package model.user;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Aishwarya on 05/05/2017.
 */
public class MaintenanceCrew extends ElevatorUser {

    private int duration;
    private  int minFloor;

    public MaintenanceCrew (Integer capacity, Integer destFloor, double probability ) {

        this.setCapacity(capacity);
        this.setProbabilty(probability);
        this.setDestFloor(destFloor);
        this.setFloorsAccessable(Collections.min(number), Collections.max(getFloorsAccessable()));

    }




    public void leaveBuilding() {

        setDestFloor(0);
    }

    public void moveFloor() {
        //will arrive and go to the top floor, taking up 4 spaces with their equipment and materials. After they complete their work, they will return to the ground floor and leave.

    }

    public void shouldIleave(){
        if duration >=
        //figure out how many ticks for that number of time


    }




    }
