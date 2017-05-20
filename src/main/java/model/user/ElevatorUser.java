package model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
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
    protected Random randomGenerator;
    private long timeAddedToQueue;
    private List<Integer> floorsAccessible = new ArrayList<Integer>();

    public ElevatorUser(String className,int seed){
        ID = className + nextID.incrementAndGet();
        if(Integer.toString(seed).trim().length() == 0){
            randomGenerator = new Random(seed);
        } else {
            randomGenerator = new Random();
        }
    }

    public String getID() {
        return ID;
    }

    protected void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;}

    //numberOfFloors
    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    protected void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    // Capacity

    public int getCapacity() {
        return capacity;
    }

    protected void setCapacity(Integer capacity) {
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

    protected void setFloorsAccessible(List<Integer> floorsAccessible) {
        this.floorsAccessible = floorsAccessible;
    }

    protected abstract List<Integer> determineFloorsAccessible();

    public abstract void moveFloor();

    public int compareTo(ElevatorUser otherUser){
        if (this.getPriority() == otherUser.getPriority() && this.getTimeAddedToQueue() == otherUser.getTimeAddedToQueue()){
            return 0;
        } else if (this.getPriority() == otherUser.getPriority() && this.getTimeAddedToQueue() > otherUser.getTimeAddedToQueue()){
            return 1;
        }else if (this.getPriority() == otherUser.getPriority() && this.getTimeAddedToQueue() < otherUser.getTimeAddedToQueue()){
            return -1;
        }
        else if (this.priority > otherUser.getPriority()){
            return -1;
        } else if (this.priority < otherUser.getPriority()){
            return 1;
        }
        return priority;
    }

    public long getTimeAddedToQueue() {
        return timeAddedToQueue;
    }

    public void setTimeAddedToQueue(long timeAddedToQueue) {
        this.timeAddedToQueue = timeAddedToQueue;
    }

    @Override
    public boolean equals(Object o){

        if (o == this) return true;
        if (!(o instanceof ElevatorUser)) return false;

        ElevatorUser user = (ElevatorUser) o;

        return Objects.equals(this.ID,user.ID);
    }
}
