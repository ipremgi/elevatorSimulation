package gui.frames;

import gui.dto.GUIInputs;
import gui.dto.GUIUpdates;
import gui.panels.ElevatorPanel;
import gui.panels.InputPanel;
import gui.panels.OutputPanel;

import javax.swing.*;
import java.awt.*;
/**
 * Created by IPREMGI on 20/05/2017.
 */
public class Simulation extends JFrame {
    
    JPanel simPanel;
    OutputPanel outputPanel;
    ElevatorPanel elevatorPanel;


    public Simulation(GUIInputs inputs){
        setLayout(new GridLayout(1,1,10,20));
        startFrame(inputs);
    }
    
    
    private void startFrame(GUIInputs inputs){

        simPanel = new JPanel();
        simPanel.setLayout(new GridLayout(2,0,10,10));

        outputPanel = new OutputPanel();
        elevatorPanel = new ElevatorPanel();
        simPanel.add(outputPanel);
        simPanel.add(elevatorPanel);

        add(simPanel);
        add(new InputPanel(false, inputs));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setSize(540,475);
        setTitle("Elevator Simulation");
//
//
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//        java.util.List<ElevatorUser> a  = new ArrayList<ElevatorUser>();
//        a.add(new Client(1,0,2));
//        a.add(new Employee(2,4,5));
//        GUIUpdates u = new GUIUpdates(1,2, Direction.DOWN,5, DoorStatus.CLOSED, a);
//
//        update(u);
//
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//        u.setElevatorOccupants(new ArrayList<ElevatorUser>());
//
//        update(u);


    }

    public void update(GUIUpdates param){
        outputPanel.update(param);
        elevatorPanel.update(param);
    }
}
