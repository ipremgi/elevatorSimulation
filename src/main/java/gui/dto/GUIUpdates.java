package gui.dto;

import model.building.Direction;
import model.building.DoorStatus;
import model.user.ElevatorUser;

import java.util.List;

/**
 * Created by IPREMGI on 20/05/2017.
 * Class used to transport information in order to update the GUI
 */
public class GUIUpdates {

    private int tick;
    private int numberOfComplaints;
    private Direction direction;
    private int elevatorfloor;
    private DoorStatus doorStatus;
    private List<ElevatorUser> elevatorOccupants;

    public GUIUpdates(int tick, int numberOfComplaints, Direction direction, int elevatorfloor, DoorStatus doorStatus, List<ElevatorUser> elevatorOccupants) {
        this.tick = tick;
        this.numberOfComplaints = numberOfComplaints;
        this.direction = direction;
        this.elevatorfloor = elevatorfloor;
        this.doorStatus = doorStatus;
        this.elevatorOccupants = elevatorOccupants;
    }

    public String getTick() {
        return Integer.toString(tick);
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

    public String getNumberOfComplaints() {
        return Integer.toString(numberOfComplaints);
    }

    public void setNumberOfComplaints(int numberOfComplaints) {
        this.numberOfComplaints = numberOfComplaints;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getElevatorfloor() {
        return Integer.toString(elevatorfloor);
    }

    public void setElevatorfloor(int elevatorfloor) {
        this.elevatorfloor = elevatorfloor;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public void setDoorStatus(DoorStatus doorStatus) {
        this.doorStatus = doorStatus;
    }

    public List<ElevatorUser> getElevatorOccupants() {
        return elevatorOccupants;
    }

    public void setElevatorOccupants(List<ElevatorUser> elevatorOccupants) {
        this.elevatorOccupants = elevatorOccupants;
    }

    public String getCapacity(){
        int cap = 0;

        for(ElevatorUser user: elevatorOccupants){
            cap += user.getCapacity();
        }

        return Integer.toString(cap);
    }
}
