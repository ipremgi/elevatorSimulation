package controller;

import model.building.*;
import model.user.*;
import view.ElevatorView;

import java.util.*;

/**
 * Created by HWILKHU on 02/05/2017.
 */

//rename to building controller?
public class BuildingController {

    private Elevator elevator;
    private ElevatorView elevatorView;
    private Building building;
    private ArrayList<ElevatorUser> buildingOccupants = new ArrayList<ElevatorUser>();
    private double p;
    private Random random;
    private ArrayList<Integer> requests = new ArrayList<Integer>();
    private int delay = 80;


    public BuildingController(ElevatorView elevatorView, Building building, double p, Random random) {
        this.elevator = building.getElevator();
        this.elevatorView = elevatorView;
        this.building = building;
        this.p = p;

        this.random = random;
    }

    /**
     * adds users to the building sd they are a part of the simulation
     * @param elevatorUser
     */
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
            usedCapacity = usedCapacity + occupant.getCAPACITY();
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
        if (person instanceof Developer){
            for(ElevatorUser user : elevator.getUsers()){
                if(user instanceof Developer){
                    if(((Developer) user).getCompany() != ((Developer) person).getCompany()){
                        building.getFloor(elevator.getFloor()).removeUser(person);
                        person.setTimeAddedToQueue(System.currentTimeMillis());
                        building.getFloor(elevator.getFloor()).addUser(person);
                        return false;
                    }
                }
            }
        }
        return ((person.getCAPACITY() + usedCapacity()) <= elevator.getMAX_CAPACITY()) && (elevator.getDoorStatus() == DoorStatus.OPEN);
    }

    public void addPersonToElevator(ElevatorUser user){
        elevator.addUser(user);

        if (user instanceof Client){
            ((Client) user).setWaiting(false);
        }

        //need a remove user from the waiting list
        //remove by id
        building.getFloor(user.getCurrentFloor()).removeUser(user);
        //buildingOccupants.remove(user);
        if(building.getFloor(user.getCurrentFloor()).getWaitingForLift().isEmpty()){
            building.getFloor(user.getCurrentFloor()).setBtnPressed(false);
        }
    }

    /**
     * Calculate the next floor to travel to
     * Based on the people in the elevator and direction of elevator travelling
     * @return - the floor number
     */
    public int calculateNextFloor(){
        ArrayList<Integer> tmpRequests = new ArrayList<Integer>(requests);

        //System.out.println(requests);

        for (ElevatorUser occupant : elevator.getUsers()){
            requests.add(occupant.getDestFloor());
            tmpRequests.add(occupant.getDestFloor());
        }

        //System.out.println("tmp requests:"+tmpRequests);

        if (elevator.getDirection() == Direction.UP){
            for (int floorNumber : requests){
                if(floorNumber <= elevator.getFloor()){
                    tmpRequests.remove(new Integer(floorNumber));
                }
            }
            //System.out.println("tmp requests:"+tmpRequests);
            //nextFloor = tmpRequests.indexOf(Collections.min(tmpRequests));
            Collections.sort(tmpRequests);
            //System.out.println("next floor:"+nextFloor);

        } else if (elevator.getDirection() == Direction.DOWN){
            for (int floorNumber : requests){
                if(floorNumber >= elevator.getFloor()){
                    tmpRequests.remove(new Integer(floorNumber));
                }
            }
            Collections.sort(tmpRequests,Collections.reverseOrder());
        }

        if(tmpRequests.size() == 0){
            tmpRequests.add(0);

        }

        return tmpRequests.get(0);
    }

    /**
     * User leaving the elevator
     */
    public void leaveElevator(){
        List<ElevatorUser> elevatorOccupants = new ArrayList<ElevatorUser>(elevator.getUsers());

        for (ElevatorUser occupant : elevatorOccupants){

            if (occupant.getDestFloor() == elevator.getFloor()){
                System.out.println("Leaving elevator : " + occupant.getID());
                occupant.setCurrentFloor(elevator.getFloor());
                elevator.removePerson(occupant);
                //System.out.println("adding to building occupants");
                buildingOccupants.add(occupant);
                //System.out.println(buildingOccupants);
            }
        }

    }

    public void checkForRequests(int ticks){

        ArrayList<ElevatorUser> buildingOccupants = new ArrayList<ElevatorUser>(this.buildingOccupants);

        for (ElevatorUser occupant : buildingOccupants){
            if (occupant.getCurrentFloor() == 0 && occupant.getDestFloor() != 0) {
                occupant.setEnterTick(ticks);
                requestElevator(occupant);
                if (occupant instanceof Client){
                    ((Client) occupant).setWaiting(true);
                }
            }else if (occupant instanceof Employee || occupant instanceof Developer){
                if (random.nextDouble() <= p){
                    occupant.moveFloor();
                    occupant.setEnterTick(ticks);
                    requestElevator(occupant);
                }
            }
            else if (occupant instanceof Leaves){
                if (((Leaves) occupant).isRemoveMe()){
                    this.buildingOccupants.remove(occupant);
                }
                ((Leaves) occupant).shouldILeave();
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

        requests = floorRequests;
    }

    public void updateView(int tick){
        elevatorView.updateView(elevator.getFloor(),elevator.getDoorStatus(),elevator.getUsers(),tick,elevator.getDirection(), building.getNoOfComplaints());
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void requestElevator(ElevatorUser elevatorUser){
        building.getFloor(elevatorUser.getCurrentFloor()).setBtnPressed(true);
        elevatorUser.setTimeAddedToQueue(System.currentTimeMillis());
        building.getFloor(elevatorUser.getCurrentFloor()).addUser(elevatorUser);
        this.buildingOccupants.remove(elevatorUser);
    }

    /**
     * checks if any clients in the waiting queues have been waiting long enough to complain
     */
    public void checkForComplaints(){
        for (Floor floor : building.getFloors()){
            Iterator<ElevatorUser> iterator = floor.getWaitingForLift().iterator();
            while (iterator.hasNext()){
                ElevatorUser user = iterator.next();
                if (user instanceof Client){
                    if(((Client) user).shouldIComplain()){
                     building.addComplaint();
                    }
                }
            }
        }
    }

    public ArrayList<Integer> getRequests() {
        return requests;
    }

}
