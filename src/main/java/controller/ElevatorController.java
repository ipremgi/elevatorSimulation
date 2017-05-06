package controller;

import model.building.Building;
import model.building.Direction;
import model.building.DoorStatus;
import model.building.Elevator;
import model.user.ElevatorUser;
import view.ElevatorView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by HWILKHU on 02/05/2017.
 */

//rename to building controller?
public class ElevatorController {

    private Elevator elevator;
    private ElevatorView elevatorView;
    private Building building;
    private int ticks = 0;
    //move to building model?
    private ArrayList<ElevatorUser> buildingOccupants= new ArrayList<ElevatorUser>();
    private DoorStatus doorStatus;
    private Direction direction;

    public ElevatorController(Elevator elevator, ElevatorView elevatorView, Building building) {
        this.elevator = elevator;
        this.elevatorView = elevatorView;
        this.building = building;
    }

    public void addElevatorUser(ElevatorUser elevatorUser){
        buildingOccupants.add(elevatorUser);
    }


    //move to simulator class?
    public void nextTick(){

        ticks++;
        int steps = 4;

        if (ticks % steps == 1){
            openElevatorDoor();
        } else if (ticks % steps == 2){
            leaveElevator();

            for (ElevatorUser person : building.getFloor(elevator.getFloor()).getWaitingForLift()){
                if (canAddPersonToElevator(person)){
                    addPersonToElevator(person);
                }
            }

            updateView();
        } else if (ticks % steps == 3){
            closeElevatorDoor();
        } else if (ticks % steps == 0){
            moveElevator(calculateNextFloor());
            updateView();
        }


    }

    private void openElevatorDoor(){
        elevator.setDoorStatus(doorStatus.OPEN);
    }

    private void closeElevatorDoor(){
        elevator.setDoorStatus(doorStatus.CLOSED);
    }

    private void moveElevator(int floor){
        elevator.setFloor=floor;
    }

    private int usedCapacity(){
        int usedCapacity = 0;

        for (ElevatorUser occupant : elevator.getOccupants()){
            usedCapacity = usedCapacity + occupant.getCapacity();
        }

        return usedCapacity;
    }

    private boolean canAddPersonToElevator(ElevatorUser person){

        if ((person.getCapacity() + usedCapacity()) > elevator.getMAX_CAPACITY()){
            return false;
        }

        return true;
    }

    private void addPersonToElevator(ElevatorUser person){
        elevator.addPerson(person);
        //need a remove user from the waiting list
        //remove by id
        building.getFloor(person.getFloor).removeUser(person);
    }



    private int calculateNextFloor(){
        ArrayList<Integer> requests = checkForRequests();
        int nextFloor = 0;

        for (ElevatorUser occupant : elevator.getOccupants()){
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


    //probably don't need this
    private void noRequsts(){
        elevator.setFloor(0);
    }

    private ArrayList<Integer> checkForRequests(){

        List<ElevatorUser> buildingOccupants = building.getOccupants();

        for (ElevatorUser occupant : buildingOccupants){
            if (occupant.shouldIMove()){
                occupant.moveFloor();
                building.getFloor(occupant.getFloor).setBtnPressed(true);
                building.getFloor(occupant.getFloor).addUser(occupant);
            }
        }


        List<Floor> floors = buiilding.getFloors();

        ArrayList<Integer> floorRequests = new ArrayList<Integer>();

        for (Floor floor : floors){
            if (floor.isBtnPressed()){
                floorRequests.add(floor.getFloorNumber());
            }
        }

        return floorRequests;
    }

    private void updateView(){
        elevatorView.updateView(elevator.getFloor,elevator.getOccupants);
    }

}
