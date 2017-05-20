package gui.dto;

/**
 * Created by IPREMGI on 20/05/2017.
 */
public class GUIInputs {

    private int numberOfGoggles;
    private int numberOfMugtones;
    private int ticks;
    private int noOfFloors;
    private int maxCapacity;
    private double q;
    private double p;
    private int numberOfEmployees;

    public GUIInputs(int numberOfGoggles, int numberOfMugtones, int ticks, int noOfFloors, int maxCapacity, double q, double p, int numberOfEmployees) {
        this.numberOfGoggles = numberOfGoggles;
        this.numberOfMugtones = numberOfMugtones;
        this.ticks = ticks;
        this.noOfFloors = noOfFloors;
        this.maxCapacity = maxCapacity;
        this.q = q;
        this.p = p;
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfGoggles() {
        return numberOfGoggles;
    }

    public void setNumberOfGoggles(int numberOfGoggles) {
        this.numberOfGoggles = numberOfGoggles;
    }

    public int getNumberOfMugtones() {
        return numberOfMugtones;
    }

    public void setNumberOfMugtones(int numberOfMugtones) {
        this.numberOfMugtones = numberOfMugtones;
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
}




