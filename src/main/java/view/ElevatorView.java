package view;

import model.user.ElevatorUser;

import java.util.List;

/**
 * Created by HWILKHU on 02/05/2017.
 */
public class ElevatorView {

    public void updateView(int elevatorfloor, List<ElevatorUser> elevatorOccupants){
        System.out.println("Elevator is on floor: " + elevatorfloor);
        for (ElevatorUser occupant : elevatorOccupants){
            System.out.println(occupant.getID() + " is currently on the elevator");
        }
    }
}
