package model.user;

/**
 * Created by Aishwarya on 05/05/2017.
 */
public class Employee extends ElevatorUser {
    private int duration;


    public void leaveBuilding() {
        setDestFloor(0);

    }

    public void moveFloor() {
        //any floor same probability

    }
}
