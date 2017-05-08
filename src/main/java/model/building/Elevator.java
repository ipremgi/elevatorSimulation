package model.building;

import model.user.ElevatorUser;

import java.util.List;

/**
 * Created by IPREMGI on 02/05/2017.
 */
public class Elevator {

    private int floor; // what floor the elevator is in
    private final int MAX_CAPACITY; // number of capacity in elevator
    private Direction direction; // direction elevator is travelling
    private List<ElevatorUser> users; // list of people in the elevator
    private DoorStatus doorStatus; // status of the door


    /**
     * Constructor
     * Set the max capacity of elevator and default floor will be 0
     * @param max_capacity
     */
    public Elevator(int max_capacity) {
        MAX_CAPACITY = max_capacity;
        floor = 0;
    }


    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<ElevatorUser> getUsers() {
        return users;
    }

    public void setUsers(List<ElevatorUser> users) {
        this.users = users;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public void setDoorStatus(DoorStatus doorStatus) {
        this.doorStatus = doorStatus;
    }

    public void removePerson(ElevatorUser person){
        users.remove(person);
    }
}
