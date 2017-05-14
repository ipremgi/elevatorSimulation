package model.user;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aishwarya on 03/05/2017.
 */
public class Developer extends ElevatorUser {

    private Company company;

    public Developer(Company company, int capacity, int priority,int numberOfFloors) {
        super("developer" + company.name());
        this.company = company;
        this.setCapacity(capacity);
        this.setNumberOfFloors(numberOfFloors);
        this.setFloorsAccessible(determineFloorsAccessible());
        this.setDestFloor(this.getFloorsAccessible().get(randomGenerator.nextInt(this.getFloorsAccessible().size())));
        this.setPriority(priority);
    }

    @Override
    protected List<Integer> determineFloorsAccessible(){
        List<Integer> floorsAccessible = new ArrayList<Integer>();

        for (int i = (getNumberOfFloors() - 1); i > ((getNumberOfFloors() - 1) / 2); i--) {
            floorsAccessible.add(i);
        }

        return floorsAccessible;
    }

    public void moveFloor() {

        do{
            this.setDestFloor(this.getFloorsAccessible().get(randomGenerator.nextInt(this.getFloorsAccessible().size())));
        }while (getCurrentFloor() == getDestFloor());
        //only work in the top half of the building. Developers may randomly decide to move to another floor in the top half.
    }

    public Company getCompany() {
        return company;
    }

}


