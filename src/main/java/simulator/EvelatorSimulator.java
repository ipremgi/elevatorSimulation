package simulator;

import controller.ElevatorController;
import model.building.Building;
import model.building.Elevator;
import model.user.*;
import view.ElevatorView;

import java.util.Random;

/**
 * Created by IPREMGI on 02/05/2017.
 */
public class EvelatorSimulator implements ISimulator {

    private SimulatorTick simulatorTick;
    private ElevatorController elevatorController;
    private int numberOfGoggle;
    private int numberOfMugtone;
    private int numberOfEmployees;
    private int ticks;
    private int noOfFloors;
    private int maxCapacity;
    private Random random = new Random();
    private double q;

    public EvelatorSimulator(int numberOfGoggles, int numberOfMugtones, int ticks, int noOfFloors, int maxCapacity, double q, int numberOfEmployees) {
        this.numberOfGoggle=numberOfGoggles;
        this.numberOfMugtone=numberOfMugtones;
        this.ticks=ticks;
        this.noOfFloors=noOfFloors;
        this.maxCapacity=maxCapacity;
        this.q=q;
        this.numberOfEmployees=numberOfEmployees;
    }

    public void simulate() {
        System.out.println("simulation has started");

        simulatorTick = new SimulatorTick();
        Building building = new Building(noOfFloors,maxCapacity);
        Elevator elevator = building.getElevator();
        ElevatorView elevatorView = new ElevatorView();

        elevatorController = new ElevatorController(elevator,elevatorView,building);

        // creates goggle developers
        for (int i = 0; i < numberOfGoggle; i++){
            System.out.println("creating goggle developer");

            elevatorController.addElevatorUser(new Developer(Company.GOGGLES,1,5,0.05));
        }

        //creates mugtone developers
        for (int i = 0; i < numberOfMugtone; i++){
            System.out.println("creating mugtone developer");

            elevatorController.addElevatorUser(new Developer(Company.MUGTOMES,1,5,0.05));
        }

        //creates employees
        for (int i = 0; i < numberOfEmployees; i++){
            System.out.println("creating employee");
            elevatorController.addElevatorUser(new Employee(1,3,0.07));
        }

        for (int i = 0; i < ticks; i++){
            nextTick(building,elevator);
        }


    }

    public void nextTick(Building building, Elevator elevator){

        System.out.println("next tick is being called");

        //create client
        if (random.nextDouble() <= q){
            elevatorController.addElevatorUser(new Client(1,2,0.005));
        }

        //create maintenance crew
        if (random.nextDouble() <= 0.005){
            elevatorController.addElevatorUser(new MaintenanceCrew(1,10,0.005,10));
        }


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
