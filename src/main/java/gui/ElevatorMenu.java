package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ipremgi on 17/05/2017.
 */
public class ElevatorMenu extends JFrame implements ActionListener{

    private JLabel pLabel;
    private JLabel qLabel;
    private JLabel elCapLabel; // elevator max capacity
    private JLabel noOfFloorsLabel;
    private JLabel noOfEmpsLabel;
    private JLabel noOfDevMugLabel;
    private JLabel noOfDevGogLabel;
    private JLabel simTimeLabel;

    private JTextField pField;
    private JTextField qField;
    private JTextField elCapField;
    private JTextField noOfFloorsField;
    private JTextField noOfEmpsField;
    private JTextField noOfDevMugField;
    private JTextField noOfDevGogField;
    private JTextField simTimeField;

    private JButton start; // start the simulation

    public ElevatorMenu(){
        instantiateComponents();
        addComponents();
    }

    private void instantiateComponents(){
        setLayout(new FlowLayout());

        pLabel = new JLabel("Probability for P");
        qLabel = new JLabel("Probability for Q");
        elCapLabel = new JLabel("Elevator capacity");
        noOfFloorsLabel = new JLabel("Number of floors");
        noOfEmpsLabel = new JLabel("Number of employees");
        noOfDevMugLabel = new JLabel("Number of Mugtomes developers");
        noOfDevGogLabel = new JLabel("Number of Goggles developers");
        simTimeLabel = new JLabel("Simulation time");

        pField = new JTextField(15);
        qField = new JTextField(15);
        elCapField = new JTextField(15);
        noOfFloorsField = new JTextField(15);
        noOfEmpsField = new JTextField(15);
        noOfDevMugField = new JTextField(15);
        noOfDevGogField = new JTextField(15);
        simTimeField = new JTextField(15);

        start = new JButton("START");
    }

    private void addComponents(){
        add(pLabel);
        add(pField);

        add(qLabel);
        add(qField);

        add(elCapLabel);
        add(elCapField);

        add(noOfFloorsLabel);
        add(noOfFloorsField);

        add(noOfEmpsLabel);
        add(noOfEmpsField);

        add(noOfDevMugLabel);
        add(noOfDevMugField);

        add(noOfDevGogLabel);
        add(noOfDevGogField);

        add(simTimeLabel);
        add(simTimeField);

        add(start);
        start.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(pField.getText());
    }
}
