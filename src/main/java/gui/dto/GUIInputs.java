package gui.dto;

/**
 * Created by IPREMGI on 20/05/2017.
 * Data Transfer Object
 * This class will store the user configuration from Menu Frame
 */
public class GUIInputs {

    private int numberOfGoggles;
    private int numberOfMugtomes;
    private int ticks;
    private int noOfFloors;
    private int maxCapacity;
    private double q;
    private double p;
    private int numberOfEmployees;
    private int seed;

    public GUIInputs(int numberOfGoggles, int numberOfMugtomes, int ticks, int noOfFloors, int maxCapacity, double q, double p, int numberOfEmployees, int seed) {
        this.numberOfGoggles = numberOfGoggles;
        this.numberOfMugtomes = numberOfMugtomes;
        this.ticks = ticks;
        this.noOfFloors = noOfFloors;
        this.maxCapacity = maxCapacity;
        this.q = q;
        this.p = p;
        this.numberOfEmployees = numberOfEmployees;

        if(Integer.toString(seed).trim().length() == 0){
            this.seed = -1;
        } else {
            this.seed = seed;
        }


    }

    public int getNumberOfGoggles() {
        return numberOfGoggles;
    }

    public void setNumberOfGoggles(int numberOfGoggles) {
        this.numberOfGoggles = numberOfGoggles;
    }

    public int getNumberOfMugtomes() {
        return numberOfMugtomes;
    }

    public void setNumberOfMugtomes(int numberOfMugtomes) {
        this.numberOfMugtomes = numberOfMugtomes;
    }

    public int getTicks() {
        return ticks;
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public double getQ() {
        return q;
    }

    public void setQ(double q) {
        this.q = q;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }
}




