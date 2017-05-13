package view;

import model.building.DoorStatus;
import model.user.ElevatorUser;

import java.util.List;

/**
 * Created by HWILKHU on 02/05/2017.
 */
public class ElevatorView {

    public void updateView(int elevatorfloor, DoorStatus doorStatus, List<ElevatorUser> elevatorOccupants){
        System.out.println("Elevator is on floor: " + elevatorfloor);
        System.out.println("Door Status: " + doorStatus);
        for (ElevatorUser occupant : elevatorOccupants){
            System.out.println(occupant.getID() + " is currently on the elevator");
        }
    }
}
