package simulator;

import controller.ElevatorController;
import model.building.Building;
import model.building.Direction;
import model.building.DoorStatus;
import model.building.Elevator;
import model.user.*;
import view.ElevatorView;

import java.util.PriorityQueue;
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
    private double p;

    public EvelatorSimulator(int numberOfGoggles, int numberOfMugtones, int ticks, int noOfFloors, int maxCapacity, double q, double p, int numberOfEmployees) {
        this.numberOfGoggle=numberOfGoggles;
        this.numberOfMugtone=numberOfMugtones;
        this.ticks=ticks;
        this.noOfFloors=noOfFloors;
        this.maxCapacity=maxCapacity;
        this.q=q;
        this.p=p;
        this.numberOfEmployees=numberOfEmployees;
    }

    public void simulate() {
        System.out.println("simulation has started");

        simulatorTick = new SimulatorTick();
        Building building = new Building(noOfFloors,maxCapacity);
        Elevator elevator = building.getElevator();
        ElevatorView elevatorView = new ElevatorView();

        elevatorController = new ElevatorController(elevator,elevatorView,building,p);

        // creates goggle developers
        for (int i = 0; i < numberOfGoggle; i++){


            elevatorController.addElevatorUser(new Developer(Company.GOGGLES,1,1,building.getFloors().size()));
        }

        //creates mugtone developers
        for (int i = 0; i < numberOfMugtone; i++){


            elevatorController.addElevatorUser(new Developer(Company.MUGTOMES,1,1,building.getFloors().size()));
        }

        //creates employees
        for (int i = 0; i < numberOfEmployees; i++){

            elevatorController.addElevatorUser(new Employee(1,1,2,9));
        }

        for (int i = 0; i < ticks; i++){
            nextTick(building,elevator);
        }


    }

    public void nextTick(Building building, Elevator elevator){
        //increment tick
        simulatorTick.nextTick();
        //creates clients and maintenance crews
        createRandomElevatorUsers(building.getFloors().size());
        //checks for new requests
        elevatorController.checkForRequests();
        elevatorController.checkForComplaints();

        //System.out.println(simulatorTick.getTick());
        int steps = 4;
        int ticks = simulatorTick.getTick();

        if (ticks % steps == 1){
            if (elevator.getDoorStatus() == DoorStatus.CLOSED){
                elevatorController.openElevatorDoor();
                elevatorController.updateView(ticks);
            }
        } else if (ticks % steps == 2){
            if (elevator.getDoorStatus() == DoorStatus.OPEN){
                elevatorController.leaveElevator();

                PriorityQueue<ElevatorUser> tmpWaitingList = new PriorityQueue<>(building.getFloor(elevator.getFloor()).getWaitingForLift());

                for (ElevatorUser person : tmpWaitingList){
                    if (elevatorController.canAddPersonToElevator(person)){
                        elevatorController.addPersonToElevator(person);
                    }
                }

                elevatorChangeDirection(elevator);
                elevatorController.updateView(ticks);
            }
        } else if (ticks % steps == 3){
            if (elevator.getDoorStatus() == DoorStatus.OPEN){
                elevatorController.closeElevatorDoor();
                elevatorController.updateView(ticks);
            }
        } else if (ticks % steps == 0){
            if (elevator.getDoorStatus() == DoorStatus.CLOSED){
                elevatorController.moveElevator(elevatorController.calculateNextFloor());
                elevatorController.updateView(ticks);
            }
        }


    }

    private void createRandomElevatorUsers(int numberOfFloors){
        //create client
        if (random.nextDouble() <= q){
            elevatorController.addElevatorUser(new Client(1,1,numberOfFloors));
            System.out.println("*** CLIENT CREATED! ***");
        }

        //create maintenance crew
        if (random.nextDouble() <= 0.005){
            elevatorController.addElevatorUser(new MaintenanceCrew(4,numberOfFloors,2));
            System.out.println("*** MAINTENANCE CREW CREATED CREATED! ***");
        }
    }

    private void elevatorChangeDirection(Elevator elevator){
        if (elevator.getDirection() == Direction.UP){
            if (elevator.getFloor() > elevatorController.calculateNextFloor()){
                elevator.setDirection(Direction.DOWN);
            }
        } else if (elevator.getDirection() == Direction.DOWN){
            if (elevator.getFloor() < elevatorController.calculateNextFloor() || elevator.getFloor() == 0){
                elevator.setDirection(Direction.UP);
            }
        }
    }
}
