package model.user;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Aishwarya on 03/05/2017.
 */
public class Developer extends ElevatorUser {

    private Company company;

    public Developer(Company company, int CAPACITY, int priority, int numberOfFloors, Random random) {
        super("DEV_" + company.name().toUpperCase() + "_", random, CAPACITY, numberOfFloors, priority);
        this.company = company;
        this.setFloorsAccessible(determineFloorsAccessible());
        this.setDestFloor(this.getFloorsAccessible().get(randomGenerator.nextInt(this.getFloorsAccessible().size())));
    }

    @Override
    protected List<Integer> determineFloorsAccessible(){
        List<Integer> floorsAccessible = new ArrayList<Integer>();

        for (int i = (getNumberOfFloors() - 1); i > ((getNumberOfFloors() - 1) / 2); i--) {
            floorsAccessible.add(i);
        }

        return floorsAccessible;
    }

    public Company getCompany() {
        return company;
    }

}


