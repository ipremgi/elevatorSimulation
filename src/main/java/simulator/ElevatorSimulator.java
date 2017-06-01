package simulator;


import controller.BuildingController;
import gui.dto.GUIInputs;
import gui.frames.Simulation;
import model.building.Building;
import model.building.Direction;
import model.building.DoorStatus;
import model.building.Elevator;
import model.counter.IncrementCounter;
import model.user.*;
import view.ElevatorView;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by IPREMGI on 02/05/2017.
 */
public class ElevatorSimulator implements ISimulator,Runnable {

    private IncrementCounter simulatorTick;
    private BuildingController buildingController;


    private int numberOfGoggle;
    private int numberOfMugtome;
    private int numberOfEmployees;
    private int ticks;
    private final int noOfFloors;
    private final int maxCapacity;
    private Random random;
    private final double q;
    private final double p;
    private final int seed;
    private GUIInputs inputs;

    public ElevatorSimulator(GUIInputs inputs) {
        this.inputs = inputs;
        this.numberOfGoggle = inputs.getNumberOfGoggles();
        this.numberOfMugtome = inputs.getNumberOfMugtomes();
        this.ticks = inputs.getTicks();
        this.noOfFloors = inputs.getNoOfFloors();
        this.maxCapacity = inputs.getMaxCapacity();
        this.q = inputs.getQ();
        this.p = inputs.getP();
        this.numberOfEmployees = inputs.getNumberOfEmployees();
        this.seed = inputs.getSeed();
        if(seed != -1){
            random = new Random(seed);
        } else {
            random = new Random();
        }
    }

    public void simulate() {
        System.out.println("simulation has started");

        simulatorTick = new IncrementCounter();
        Building building = new Building(noOfFloors,maxCapacity);
        Elevator elevator = building.getElevator();
        Simulation es = new Simulation(inputs);
        ElevatorView elevatorView = new ElevatorView(es);
        buildingController = new BuildingController(elevatorView,building,p, seed);

        // creates goggle developers
        for (int i = 0; i < numberOfGoggle; i++){


            buildingController.addElevatorUser(new Developer(Company.GOGGLES,1,1,building.getFloors().size(),seed));
        }

        //creates mugtone developers
        for (int i = 0; i < numberOfMugtome; i++){


            buildingController.addElevatorUser(new Developer(Company.MUGTOMES,1,1,building.getFloors().size(),seed));
        }

        //creates employees
        for (int i = 0; i < numberOfEmployees; i++){

            buildingController.addElevatorUser(new Employee(1,1,building.getFloors().size(),seed));
        }

        while (simulatorTick.getCount() < ticks){
            nextTick(building,elevator);
        }

    }


    public void nextTick(Building building, Elevator elevator){
        if (simulatorTick.getCount() < ticks ){
            if (elevator.getDoorStatus() == DoorStatus.CLOSED){
                buildingController.openElevatorDoor();
                eachTick(building.getFloors().size());
                simulatorTick.nextCount();
                buildingController.updateView(simulatorTick.getCount());
            }
        }
        if (simulatorTick.getCount() < ticks ){
            if (elevator.getDoorStatus() == DoorStatus.OPEN){
                buildingController.leaveElevator();

                PriorityQueue<ElevatorUser> tmpWaitingList = new PriorityQueue<ElevatorUser>(building.getFloor(elevator.getFloor()).getWaitingForLift());

                for (ElevatorUser person : tmpWaitingList){
                    if (buildingController.canAddPersonToElevator(person)){
                        buildingController.addPersonToElevator(person);
                    }
                }

                elevatorChangeDirection(elevator);
                eachTick(building.getFloors().size());
                simulatorTick.nextCount();
                buildingController.updateView(simulatorTick.getCount());
            }
        }
        if (simulatorTick.getCount() < ticks ){
            if (elevator.getDoorStatus() == DoorStatus.OPEN){
                buildingController.closeElevatorDoor();
                eachTick(building.getFloors().size());
                simulatorTick.nextCount();
                buildingController.updateView(simulatorTick.getCount());
            }
        }
        if (simulatorTick.getCount() < ticks ){
            if (elevator.getDoorStatus() == DoorStatus.CLOSED){
                int nextFloor = buildingController.calculateNextFloor();
                int floorsMoving = Math.abs(elevator.getFloor() - nextFloor);
                buildingController.moveElevator(nextFloor);
                for(int i = 0; i < floorsMoving;i++){
                    if (simulatorTick.getCount() < ticks){
                        eachTick(building.getFloors().size());
                        simulatorTick.nextCount();
                    }
                }
                buildingController.updateView(simulatorTick.getCount());
            }
        }


    }

    private void createRandomElevatorUsers(int numberOfFloors){
        //create client
        if (random.nextDouble() <= q){
            buildingController.addElevatorUser(new Client(1,2,numberOfFloors,seed));
            System.out.println("*** CLIENT CREATED! ***");
        }

        //create maintenance crew
        if (random.nextDouble() <= 0.005){
            buildingController.addElevatorUser(new MaintenanceCrew(4,numberOfFloors,1,seed));
            System.out.println("*** MAINTENANCE CREW CREATED CREATED! ***");
        }
    }

    private void elevatorChangeDirection(Elevator elevator){
        if (elevator.getDirection() == Direction.UP){
            if (elevator.getFloor() > buildingController.calculateNextFloor()){
                elevator.setDirection(Direction.DOWN);
            }
        } else if (elevator.getDirection() == Direction.DOWN){
            if (elevator.getFloor() < buildingController.calculateNextFloor() || elevator.getFloor() == 0){
                elevator.setDirection(Direction.UP);
            }
        }
    }

    private void eachTick(int numberOfFloors){
        //creates clients and maintenance crews
        createRandomElevatorUsers(numberOfFloors);
        //checks for new requests
        buildingController.checkForRequests();
        buildingController.checkForComplaints();
    }

    /**
     * Start a thread with the simulate method running when the class is instantiated
     */
    public void run() {
        simulate();
    }
}
