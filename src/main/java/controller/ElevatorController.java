package controller;

import view.ElevatorView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by HWILKHU on 02/05/2017.
 */
public class ElevatorController {

    private Elevator elevator;
    private ElevatorView elevatorView;
    private Building building;
    private int ticks = 0;
    private Arraylist<ElevatorUser> buildingOccupants= new ArrayList<ElevatorUser>();
    private DoorStatus doorStatus;
    private Direction direction;

    public ElevatorController(Elevator elevator, ElevatorView elevatorView, Building building, int numMugstoneEmployees, int numGoggleEmployees) {
        this.elevator = elevator;
        this.elevatorView = elevatorView;
        this.building = building;
    }

    public void nextTick(){

        ticks++;
        int steps = 4;

        if (ticks % steps == 1){
            openElevatorDoor();
        } else if (ticks % steps == 2){
            leaveElevator();

            for (ElevatorUser person : building.getFloor(elevator.getFloor).getQueue;){
                if (canAddPersonToElevator(person)){
                    addPersonToElevator(person);
                }
            }

            elevatorView.updateView(elevator.getFloor,elevator.getOccupants);
        } else if (ticks % steps == 3){
            closeElevatorDoor();
        } else if (ticks % steps == 0){
            moveElevator();
            elevatorView.updateView(elevator.getFloor,elevator.getOccupants);
        }


    }

    private void openElevatorDoor(){
        elevator.setDoorStatus(doorStatus.OPEN);
    }

    private void closeElevatorDoor(){
        elevator.setDoorStatus(doorStatus.CLOSED);
    }

    private void moveElevator(){
        elevator.setFloor=calculateNextFloor();
    }

    private int usedCapacity(){
        int usedCapacity = 0;

        List<ElevatorUser> elevatorOccupants = elevator.getOccupants();

        for (ElevatorUser occupant : elevatorOccupants){
            usedCapacity = usedCapacity + occupant.getCapacity();
        }

        return usedCapacity;
    }

    private boolean canAddPersonToElevator(ElevatorUser person){

        if ((person.getCapacity() + usedCapacity()) > elevator.getMaxCap()){
            return false;
        }

        return true;
    }

    private void addPersonToElevator(ElevatorUser person){
        elevator.addPerson(person);
    }

    private int calculateNextFloor(){
        ArrayList<Integer> requests = checkForRequests();
        int nextFloor = 0;

        for (ElevatorUser occupant : elevatorOccupants){
            requests.add(occupant.getDestFloor);
        }

        if (elevator.getDirection = direction.UP){
            for (int floorNumber : requests){
                if(floorNumber < elevator.getFloor()){
                    requests.remove(floorNumber);
                }
            }

            nextFloor = requests.indexOf(Collections.min(requests));

        } else if (elevator.getDirection = direction.DOWN){
            for (int floorNumber : requests){
                if(floorNumber > elevator.getFloor()){
                    requests.remove(floorNumber);
                }
            }

            nextFloor = requests.indexOf(Collections.max(requests));

        }

        return nextFloor;
    }

    private void leaveElevator(){
        List<ElevatorUser> elevatorOccupants = elevator.getOccupants();

        for (ElevatorUser occupant : elevatorOccupants){
            if (occupant.getDestFloor() == elevator.getFloor()){
                elevator.removePerson(occupant);
            }
        }

    }

    private void noRequsts(){
        elevator.setFloor(0);
    }

    private ArrayList<Integer> checkForRequests(){
        List<Floor> floors = buiilding.getFloors();

        ArrayList<Integer> floorRequests = new ArrayList<Integer>();

        for (Floor floor : floors){
            if (floor.isButtonPressed()){
                floorRequests.add(floor.getFloorNumber());
            }
        }

        return floorRequests;
    }

}
