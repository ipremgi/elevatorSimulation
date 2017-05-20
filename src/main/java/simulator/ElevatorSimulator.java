package simulator;

import controller.ElevatorController;
import gui.ElevatorSimulation;
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
public class ElevatorSimulator implements ISimulator {

    private SimulatorTick simulatorTick;
    private ElevatorController elevatorController;

    private int numberOfGoggle;
    private int numberOfMugtone;
    private int numberOfEmployees;
    private int ticks;
    private int noOfFloors;
    private int maxCapacity;
    private Random random = new Random(50);
    private double q;
    private double p;

    public ElevatorSimulator(int numberOfGoggles, int numberOfMugtones, int ticks, int noOfFloors, int maxCapacity, double q, double p, int numberOfEmployees) {
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
        ElevatorSimulation es = new ElevatorSimulation();
        ElevatorView elevatorView = new ElevatorView(es);

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

            elevatorController.addElevatorUser(new Employee(1,1,building.getFloors().size()));
        }

//        for (int i = 0; i < ticks; i++){
//            nextTick(building,elevator);
//        }

        while (simulatorTick.getTick() < ticks){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nextTick(building,elevator);
        }


    }

    public void nextTick(Building building, Elevator elevator){
        //increment tick
        //simulatorTick.nextTick();

        //System.out.println(simulatorTick.getTick());

        if (simulatorTick.getTick() < ticks ){
            if (elevator.getDoorStatus() == DoorStatus.CLOSED){
                elevatorController.openElevatorDoor();
                eachTick(building.getFloors().size());
                simulatorTick.nextTick();
                elevatorController.updateView(simulatorTick.getTick());
            }
        }
        if (simulatorTick.getTick() < ticks ){
            if (elevator.getDoorStatus() == DoorStatus.OPEN){
                elevatorController.leaveElevator();

                PriorityQueue<ElevatorUser> tmpWaitingList = new PriorityQueue<ElevatorUser>(building.getFloor(elevator.getFloor()).getWaitingForLift());

                for (ElevatorUser person : tmpWaitingList){
                    if (elevatorController.canAddPersonToElevator(person)){
                        elevatorController.addPersonToElevator(person);
                    }
                }

                elevatorChangeDirection(elevator);
                eachTick(building.getFloors().size());
                simulatorTick.nextTick();
                elevatorController.updateView(simulatorTick.getTick());
            }
        }
        if (simulatorTick.getTick() < ticks ){
            if (elevator.getDoorStatus() == DoorStatus.OPEN){
                elevatorController.closeElevatorDoor();
                eachTick(building.getFloors().size());
                simulatorTick.nextTick();
                elevatorController.updateView(simulatorTick.getTick());
            }
        }
        if (simulatorTick.getTick() < ticks ){
            if (elevator.getDoorStatus() == DoorStatus.CLOSED){
                int nextFloor = elevatorController.calculateNextFloor();
                int floorsMoving = Math.abs(elevator.getFloor() - nextFloor);
                elevatorController.moveElevator(nextFloor);
                for(int i = 0; i < floorsMoving;i++){
                    if (simulatorTick.getTick() < ticks){
                        eachTick(building.getFloors().size());
                        simulatorTick.nextTick();
                    }
                }
                elevatorController.updateView(simulatorTick.getTick());
            }
        }


    }

    private void createRandomElevatorUsers(int numberOfFloors){
        //create client
        if (random.nextDouble() <= q){
            elevatorController.addElevatorUser(new Client(1,2,numberOfFloors));
            System.out.println("*** CLIENT CREATED! ***");
        }

        //create maintenance crew
        if (random.nextDouble() <= 0.005){
            elevatorController.addElevatorUser(new MaintenanceCrew(4,numberOfFloors,1));
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

    private void eachTick(int numberOfFloors){
        //creates clients and maintenance crews
        createRandomElevatorUsers(numberOfFloors);
        //checks for new requests
        elevatorController.checkForRequests();
        elevatorController.checkForComplaints();
    }
}
