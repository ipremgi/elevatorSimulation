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

    public Developer(Company company, Integer capacity, Integer destFloor, double probability ) {
        this.company = company;
        this.setCapacity(capacity);
        this.setProbabilty(probability);
        this.setDestFloor(destFloor);
        this.setMaxFloors(10);

        List<Integer> floorsAccessible = new ArrayList<Integer>();

        for (int i = getMaxFloors(); i >= (getMaxFloors() / 2); i--) {
            floorsAccessible.add(i);
        }

        this.setFloorsAccessable(floorsAccessible);

        System.out.println("developer created");
    }

    public void leaveBuilding() {
        setDestFloor(0);
    }


    public void moveFloor() {

        System.out.println(getFloorsAccessable().size());

        int randomFloor = randomGenerator.nextInt(getFloorsAccessable().size());

        this.setDestFloor( getFloorsAccessable().get(randomFloor));

        //only work in the top half of the building. Developers may randomly decide to move to another floor in the top half.
    }







    }


