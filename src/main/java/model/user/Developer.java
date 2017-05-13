package model.user;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Aishwarya on 03/05/2017.
 */
public class Developer extends ElevatorUser {

    private Company company;
    private Random randomGenerator = new Random();

    public Developer(Company company, int capacity, int destFloor, double probability, int priority, int maxFloors  ) {
        super("developer" + company.name());
        this.company = company;
        this.setCapacity(capacity);
        this.setProbabilty(probability);
        this.setDestFloor(destFloor);
        this.setMaxFloors(10);
        this.setFloorsAccessible(determineFloorsAccessible());
    }

    @Override
    protected List<Integer> determineFloorsAccessible(){
        List<Integer> floorsAccessible = new ArrayList<Integer>();

        for (int i = getMaxFloors(); i >= (getMaxFloors() / 2); i--) {
            floorsAccessible.add(i);
        }

        return floorsAccessible;
    }

    public void leaveBuilding() {
        setDestFloor(0);
    }


    public void moveFloor() {

        int randomFloor = randomGenerator.nextInt(getFloorsAccessible().size());

        this.setDestFloor( getFloorsAccessible().get(randomFloor));

        //only work in the top half of the building. Developers may randomly decide to move to another floor in the top half.
    }







    }


