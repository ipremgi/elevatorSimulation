package gui.frames;

import gui.panels.ElevatorPanel;
import gui.panels.InputPanel;
import gui.panels.OutputPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IPREMGI on 20/05/2017.
 */
public class Simulation extends JFrame {

    public Simulation(){
        setLayout(new GridLayout(1,1,10,20));

        JPanel simContainer = new JPanel();
        simContainer.setLayout(new GridLayout(2,0,10,10));

        simContainer.add(new OutputPanel());
        simContainer.add(new ElevatorPanel());

        add(simContainer);
        add(new InputPanel(false));



        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setSize(540,475);
        setTitle("Elevator Simulation");
    }
}
