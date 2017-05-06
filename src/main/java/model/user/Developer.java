package model.user;
import java.util.Random;

/**
 * Created by Aishwarya on 03/05/2017.
 */
public class Developer extends ElevatorUser {

    private Company company;
    private Random randomGenerator;

    public Developer(Company company, Integer capacity, Integer destFloor, double probability ) {
        this.company = company;
        this.setCapacity(capacity);
        this.setProbabilty(probability);
        this.setDestFloor(destFloor);
        for (int i = getMaxFloors(); i <= getMaxFloors() / 2; i--) {
            this.setFloorsAccessable(i);

        }
    }

    public void leaveBuilding() {
        setDestFloor(0);
    }


    public void moveFloor() {

        int randomFloor = randomGenerator.nextInt(getFloorsAccessable().size());
        Integer setDestFloor() = getFloorsAccessable().get(randomFloor);

        //only work in the top half of the building. Developers may randomly decide to move to another floor in the top half.
    }







    }

}
