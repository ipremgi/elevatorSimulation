package model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Aishwarya on 03/05/2017.
 */
public abstract class ElevatorUser implements Comparable<ElevatorUser> {

    private int capacity;
    private int currentFloor = 0;
    private int destFloor;
    private static AtomicInteger nextID = new AtomicInteger();
    private int numberOfFloors;//change name
    private int priority;
    private String ID;
    protected Random randomGenerator = new Random();

    public ElevatorUser(String className){
        ID = className + nextID.incrementAndGet();
    }

    public String getID() {
        return ID;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    private List<Integer> floorsAccessible = new ArrayList<Integer>();

    public int getPriority() {
        return priority;}

    //numberOfFloors
    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    // Capacity

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    //currentFloor

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Integer currentFloor) {
        this.currentFloor = currentFloor;
    }

    //Destination floor
    public int getDestFloor() {
        return destFloor;
    }

    public void setDestFloor(Integer destFloor) {
        this.destFloor = destFloor;
    }

    //flooraccess
    public List<Integer> getFloorsAccessible() {
        return floorsAccessible;
    }

    public void setFloorsAccessible(List<Integer> floorsAccessible) {
        this.floorsAccessible = floorsAccessible;
    }

    //    public boolean fileComplaint() {
    //    }
    protected abstract List<Integer> determineFloorsAccessible();

    public abstract void moveFloor();

    public int compareTo(ElevatorUser otherUser){
        if (this.getPriority() == otherUser.getPriority()){
            return 0;
        } else if (this.priority > otherUser.getPriority()){
            return 1;
        } else if (this.priority < otherUser.getPriority()){
            return -1;
        }
        return priority;
    }

}
