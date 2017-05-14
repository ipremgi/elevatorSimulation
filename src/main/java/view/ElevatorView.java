package view;

import model.building.Direction;
import model.building.DoorStatus;
import model.user.ElevatorUser;

import java.util.List;

/**
 * Created by HWILKHU on 02/05/2017.
 */
public class ElevatorView {

    public void updateView(int elevatorfloor, DoorStatus doorStatus, List<ElevatorUser> elevatorOccupants, int tick, Direction direction){
        System.out.println("\n**************************************************************\n");
        System.out.println("Tick: " + tick);
        System.out.println("Elevator direction: " + direction);
        System.out.println("Elevator is on floor: " + elevatorfloor);
        System.out.println("Door Status: " + doorStatus);
        for (ElevatorUser occupant : elevatorOccupants){
            System.out.println(occupant.getID() + " dest floor " + occupant.getDestFloor());
        }
        System.out.println("\n**************************************************************");
    }
}
