package view;

import gui.ElevatorSimulation;
import gui.GUIParameter;
import model.building.Direction;
import model.building.DoorStatus;
import model.user.ElevatorUser;

import java.util.List;

/**
 * Created by HWILKHU on 02/05/2017.
 */
public class ElevatorView {

    private ElevatorSimulation es;

    public ElevatorView(ElevatorSimulation es) {
        this.es = es;
    }



    public void updateView(int elevatorfloor, DoorStatus doorStatus, List<ElevatorUser> elevatorOccupants, int tick, Direction direction, int numberOfComplaints){
        es.update(new GUIParameter(tick,numberOfComplaints,direction, elevatorfloor, doorStatus, elevatorOccupants));
        System.out.println("\n**************************************************************\n");
        System.out.println("Tick: " + tick);
        System.out.println("Number of complaints: "+numberOfComplaints);
        System.out.println("Elevator direction: " + direction);
        System.out.println("Elevator is on floor: " + elevatorfloor);
        System.out.println("Door Status: " + doorStatus);
        for (ElevatorUser occupant : elevatorOccupants){
            System.out.println(occupant.getID() + " dest floor " + occupant.getDestFloor());
        }
        System.out.println("\n**************************************************************");



    }

}
