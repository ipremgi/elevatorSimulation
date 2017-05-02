package controller;

import view.ElevatorView;

import java.util.ArrayList;

/**
 * Created by HWILKHU on 02/05/2017.
 */
public class ElevatorController {

    private Elevator elevator;
    private ElevatorView elevatorView;
    private int ticks;
    private Arraylist<elevatoruser> buildingOccupants= new ArrayList<ElevatorUser>();

    public ElevatorController(Elevator elevator, ElevatorView elevatorView, int numMugstoneEmployees, int numGoggleEmployees) {
        this.elevator = elevator;
        this.elevatorView = elevatorView;
    }

    public void nextTick(){}

    private void openElevatorDoor(){}

    private void closeElevatorDoor(){}

    private void moveElevator(){}

    private int usedCapacity(){

        return 0;
    }

    private boolean canAddPersonToElevator(){

        return true;
    }

    private void addPersonToElevator(){}

    private int calculateNextFloor(){

        return 0;
    }

    private void leaveEelevator(){}

    private void noRequsts(){}

    private int[] checkForRequests(){

        return {0};
    }

}
