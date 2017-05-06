package simulator;

import model.user.ElevatorUser;

/**
 * Created by IPREMGI on 02/05/2017.
 */
public class EvelatorSimulator implements ISimulator {


    public void simulate() {

    }

    public void nextTick(){

        ticks++;
        int steps = 4;

        if (ticks % steps == 1){
            openElevatorDoor();
        } else if (ticks % steps == 2){
            leaveElevator();

            for (ElevatorUser person : building.getFloor(elevator.getFloor()).getWaitingForLift()){
                if (canAddPersonToElevator(person)){
                    addPersonToElevator(person);
                }
            }

            updateView();
        } else if (ticks % steps == 3){
            closeElevatorDoor();
        } else if (ticks % steps == 0){
            moveElevator(calculateNextFloor());
            updateView();
        }


    }
}
