package controller;

import model.building.*;
import model.user.Developer;
import model.user.ElevatorUser;
import model.user.Employee;
import view.ElevatorView;

import java.util.*;

/**
 * Created by HWILKHU on 02/05/2017.
 */

//rename to building controller?
public class ElevatorController {

    private Elevator elevator;
    private ElevatorView elevatorView;
    private Building building;
    private ArrayList<ElevatorUser> buildingOccupants = new ArrayList<ElevatorUser>();
    private Random random;

    public ElevatorController(Elevator elevator, ElevatorView elevatorView, Building building) {
        this.elevator = elevator;
        this.elevatorView = elevatorView;
        this.building = building;
    }

    public void addElevatorUser(ElevatorUser elevatorUser){
        buildingOccupants.add(elevatorUser);
    }
    
    public void openElevatorDoor(){
        elevator.setDoorStatus(DoorStatus.OPEN);
    }

    public void closeElevatorDoor(){
        elevator.setDoorStatus(DoorStatus.CLOSED);
    }

    public void moveElevator(int floor){
        elevator.setFloor(floor);
    }

    /**
     * Getting how many capacity is used up in the elevator
     * @return - number of capacity used
     */
    public int usedCapacity(){
        int usedCapacity = 0;

        for (ElevatorUser occupant : elevator.getUsers()){
            usedCapacity = usedCapacity + occupant.getCapacity();
        }

        return usedCapacity;
    }

    /**
     * Check if the person can be added to the elevator based on the capacity
     * @param person - person to add to the elevator
     * @return true if they can be added
     *         false if they cannot
     */
    public boolean canAddPersonToElevator(ElevatorUser person){
        return (person.getCapacity() + usedCapacity()) <= elevator.getMAX_CAPACITY();
    }

    public void addPersonToElevator(ElevatorUser user){
        elevator.addUser(user);

        //need a remove user from the waiting list
        //remove by id
        building.getFloor(user.getCurrentFloor()).removeUser(user);
    }

    /**
     * Calculate the next floor to travel to
     * Based on the people in the elevator and direction of elevator travelling
     * @return - the floor number
     */
    public int calculateNextFloor(){
        ArrayList<Integer> requests = checkForRequests();
        int nextFloor = 0;

        for (ElevatorUser occupant : elevator.getUsers()){
            requests.add(occupant.getDestFloor());
        }

        if (elevator.getDirection() == Direction.UP){
            for (int floorNumber : requests){
                if(floorNumber < elevator.getFloor()){
                    requests.remove(floorNumber);
                }
            }

            nextFloor = requests.indexOf(Collections.min(requests));

        } else if (elevator.getDirection() == Direction.DOWN){
            for (int floorNumber : requests){
                if(floorNumber > elevator.getFloor()){
                    requests.remove(floorNumber);
                }
            }

            nextFloor = requests.indexOf(Collections.max(requests));

        }

        return nextFloor;
    }

    /**
     * User leaving the elevator
     */
    public void leaveElevator(){
        List<ElevatorUser> elevatorOccupants = elevator.getUsers();

        for (ElevatorUser occupant : elevatorOccupants){
            if (occupant.getDestFloor() == elevator.getFloor()){
                elevator.removePerson(occupant);
            }
        }

    }

    public ArrayList<Integer> checkForRequests(){

        for (ElevatorUser occupant : buildingOccupants){
            if (occupant instanceof Employee || occupant instanceof Developer){
                if (random.nextBoolean()){
                    occupant.moveFloor();
                    building.getFloor(occupant.getCurrentFloor()).setBtnPressed(true);
                    building.getFloor(occupant.getCurrentFloor()).addUser(occupant);
                }
            }
        }


        List<Floor> floors = building.getFloors();

        ArrayList<Integer> floorRequests = new ArrayList<Integer>();

        int index = 0;

        for (Floor floor : floors){
            if (floor.isBtnPressed()){
                floorRequests.add(index);
            }
            index++;
        }

        return floorRequests;
    }

    public void updateView(){
        elevatorView.updateView(elevator.getFloor(),elevator.getUsers());
    }

}
