package model.building;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IPREMGI on 02/05/2017.
 */
public class Building {

    private Elevator elevator;
    private List<Floor> floors; // number of floors in the building
    private int noOfComplaints; // number of complaints

    /**
     * Constructor
     * Creates the Elevator object and list of floors
     * Default no of complaints is 0
     * @param noOfFloors - number of floors in the building
     * @param maxCapacity - max capacity of elevator
     */
    public Building(int noOfFloors, int maxCapacity) {
        this.elevator = new Elevator(maxCapacity);
        this.floors = createFloors(noOfFloors);
        noOfComplaints = 0;
    }

    /**
     * Create the list of floors
     * @param floors - number of floors to create
     * @return - list of floors
     */
    private List<Floor> createFloors(int floors){
        List<Floor> f = new ArrayList<Floor>();

        for(int i = 0; i<floors; i++){
            f.add(new Floor());
        }

        return f;
    }

    public int getNoOfComplaints() {
        return noOfComplaints;
    }

    public void addComplaint() {
        this.noOfComplaints++;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public Floor getFloor(int floor) {
        return floors.get(floor);
    }
}
