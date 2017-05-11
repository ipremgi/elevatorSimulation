package simulator;

import controller.ElevatorController;
import model.building.Elevator;
import model.user.ElevatorUser;

/**
 * Created by IPREMGI on 02/05/2017.
 */
public class EvelatorSimulator implements ISimulator {

    private SimulatorTick simulatorTick;
    private ElevatorController elevatorController;
    private Elevator elevator;

    public void simulate() {
        simulatorTick = new SimulatorTick();
        elevatorController = new ElevatorController();

    }

    public void nextTick(){

        simulatorTick.nextTick();
        int steps = 4;
        int ticks = simulatorTick.getTick();

        if (ticks % steps == 1){
            elevatorController.openElevatorDoor();
        } else if (ticks % steps == 2){
            elevatorController.leaveElevator();

            for (ElevatorUser person : building.getFloor(elevator.getFloor()).getWaitingForLift()){
                if (elevatorController.canAddPersonToElevator(person)){
                    elevatorController.addPersonToElevator(person);
                }
            }

            elevatorController.updateView();
        } else if (ticks % steps == 3){
            elevatorController.closeElevatorDoor();
        } else if (ticks % steps == 0){
            elevatorController.moveElevator(elevatorController.calculateNextFloor());
            elevatorController.updateView();
        }


    }
}
