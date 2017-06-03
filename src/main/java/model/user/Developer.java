package model.user;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Aishwarya on 03/05/2017.
 */

public class Developer extends ElevatorUser {

    private Company company;
/**
 * The destination floor is set randomly using the random generator.
 * The developer is concatenated with the company to distinguish between the two companies.
 * @param company -- developers can be from two company goggles and mugtomes
 * @param CAPACITY - how many people are allowed in the elevator
 * @param  priority - users priority
 * @param  numberOfFloors - number of floors in the building
 * @param random - random generator to move floors
 * */

    public Developer(Company company, int CAPACITY, int priority, int numberOfFloors, Random random) {
        super("DEV_" + company.name().toUpperCase() + "_", random, CAPACITY, numberOfFloors, priority);
        this.company = company;
        this.setFloorsAccessible(determineFloorsAccessible());
        this.setDestFloor(this.getFloorsAccessible().get(randomGenerator.nextInt(this.getFloorsAccessible().size())));
    }

    /**
     * This methods determineFloorsAccessible ensure the developers is allowed only on the floors they have access to.
     * developers only has access to the only work in the top half of the building.
     * @return floors accessible by developers
     * */

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


