package simulator;

import controller.ElevatorController;
import model.building.Building;
import model.building.Elevator;
import model.user.ElevatorUser;
import view.ElevatorView;

/**
 * Created by IPREMGI on 02/05/2017.
 */
public class EvelatorSimulator implements ISimulator {

    private SimulatorTick simulatorTick;
    private ElevatorController elevatorController;
    private int numberOfGoggle;
    private int numberOfMugtone;
    private int ticks;
    private int noOfFloors;
    private int maxCapacity;

    public EvelatorSimulator(int numberOfGoggles, int numberOfMugtones, int ticks, int noOfFloors, int maxCapacity) {
        this.numberOfGoggle=numberOfGoggles;
        this.numberOfMugtone=numberOfMugtones;
        this.ticks=ticks;
        this.noOfFloors=noOfFloors;
        this.maxCapacity=maxCapacity;
    }

    public void simulate() {
        simulatorTick = new SimulatorTick();
        Building building = new Building(noOfFloors,maxCapacity);
        Elevator elevator = building.getElevator();
        ElevatorView elevatorView = new ElevatorView();

        elevatorController = new ElevatorController(elevator,elevatorView,building);

        for (int i = 0; i < numberOfGoggle; i++){
            elevatorController.addElevatorUser();
        }

        for (int i = 0; i < numberOfMugtone; i++){
            elevatorController.addElevatorUser();
        }

        for (int i = 0; i < ticks; i++){
            nextTick(building,elevator);
        }


    }

    public void nextTick(Building building, Elevator elevator){

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
