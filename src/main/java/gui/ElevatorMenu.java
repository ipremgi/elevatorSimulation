package gui;

import simulator.ElevatorSimulator;
import simulator.ISimulator;

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

    /**
     * Instantiate the JFrame components
     */
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
        pField.setName("Probability for P");
        qField = new JTextField(15);
        qField.setName("Probability for Q");
        elCapField = new JTextField(15);
        elCapField.setName("Elevator capacity");
        noOfFloorsField = new JTextField(15);
        noOfFloorsField.setName("Number of floors");
        noOfEmpsField = new JTextField(15);
        noOfEmpsField.setName("Number of employees");
        noOfDevMugField = new JTextField(15);
        noOfDevMugField.setName("Number of Mugtomes developers");
        noOfDevGogField = new JTextField(15);
        noOfDevGogField.setName("Number of Goggles developers");
        simTimeField = new JTextField(15);
        simTimeField.setName("Simulation time");

        start = new JButton("START");
    }

    /**
     * Add the components to the JFrame in the correct order
     */
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

    /**
     * Start the simulation when the start button is pressed
     * @param e
     */
    public void actionPerformed(ActionEvent e) {

        ISimulator simulator = new ElevatorSimulator(validateIntField(noOfDevGogField),
                                                        validateIntField(noOfDevMugField),
                                                        validateIntField(simTimeField),
                                                        validateIntField(noOfFloorsField),
                                                        validateIntField(elCapField),
                                                        validateDoubleField(qField),
                                                        validateDoubleField(pField),
                                                        validateIntField(noOfEmpsField),50);

        this.setVisible(false);
        simulator.simulate();
    }


    /**
     * Validate any field that should have a double input
     * @param field - field to validate
     * @return - the double value if valid
     */
    private double validateDoubleField(JTextField field){
        try {
            return Double.parseDouble(field.getText());
        }catch (NumberFormatException nfe){
            throw new NumberFormatException("Invalid input for " + field.getName());
        }
    }

    /**
     * Validate any field that should have a integer input
     * @param field - field to validate
     * @return - the int value if valid
     */
    private int validateIntField(JTextField field){
        try {
            return Integer.parseInt(field.getText());
        }catch (NumberFormatException nfe){
            throw new NumberFormatException("Invalid input for " + field.getName());
        }
    }

}
