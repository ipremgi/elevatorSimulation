package model.user;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Aishwarya on 03/05/2017.
 */
public abstract class ElevatorUser {

    //change Integer to int
    private Integer capacity;
    private Integer currentFloor = 0;
    private Integer destFloor;
    private Integer ID;
    private static AtomicInteger nextID;
    private double probabilty;
    private int maxFloors;
    //typo Accessible
    private List<Integer> floorsAccessable = new ArrayList<Integer>();



    //maxFloors
    public int getMaxFloors() {
        return maxFloors;
    }

    public void setMaxFloors(int maxFloors) {
        this.maxFloors = maxFloors;
    }

    // Capacity

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    //currentFloor

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Integer currentFloor) {
        this.currentFloor = currentFloor;
    }

    //Destination floor
    public Integer getDestFloor() {
        return destFloor;
    }

    public void setDestFloor(Integer destFloor) {
        this.destFloor = destFloor;
    }

    //probability of moving
    public double getProbabilty() {
        return probabilty;
    }

    public void setProbabilty(double probabilty) {
        this.probabilty = probabilty;
    }

    //flooraccess
    public List<Integer> getFloorsAccessable() {
        return floorsAccessable;
    }

    public void setFloorsAccessable(List<Integer> floorsAccessable) {
        this.floorsAccessable = floorsAccessable;
    }

    //leave or move
    public void leaveBuilding(){
        destFloor = 0;

    }
    public  void moveFloor(){

    }

    public Integer getID() {
        return ID;
    }
}
