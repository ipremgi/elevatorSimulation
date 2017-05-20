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
 * The main JFrame that will show the simulation
 * The JFrame will show
 *      - Input provided by the user right hand side
 *      - Output of the simulation left hand side (top)
 *      - Elevator box that will display the users inside the elevator left hand side (bottom)
 */
public class Simulation extends JFrame {
    
    JPanel simPanel;
    OutputPanel outputPanel;
    ElevatorPanel elevatorPanel;


    public Simulation(GUIInputs inputs){
        setLayout(new GridLayout(1,1,10,20));
        startFrame(inputs);
    }

    /**
     * Starting the frame
     * Adding all the panels to the main frame and setting the visibility to true
     * @param inputs - object that contains input provided by the Menu frame
     */
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
    }

    /**
     * Updating the JPanels
     *  - Output panel - displaying the simulation information
     *  - Elevator panel - people inside the elevator
     * @param param - object that contains all the changes
     */
    public void update(GUIUpdates param){
        outputPanel.update(param);
        elevatorPanel.update(param);
        repaint();
    }
}
