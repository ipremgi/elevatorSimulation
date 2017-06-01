package gui.panels;

import gui.dto.GUIInputs;
import simulator.ElevatorSimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IPREMGI on 20/05/2017.
 * This JPanel will be used for the Main Menu and also for the Simulation
 */
public class InputPanel extends JPanel implements ActionListener,IPanels {

    private JLabel pLabel;
    private JLabel qLabel;
    private JLabel elCapLabel; // elevator max capacity
    private JLabel noOfFloorsLabel;
    private JLabel noOfEmpsLabel;
    private JLabel noOfDevMugLabel;
    private JLabel noOfDevGogLabel;
    private JLabel simTimeLabel;
    private JLabel seedLabel;

    private JTextField pField;
    private JTextField qField;
    private JTextField elCapField;
    private JTextField noOfFloorsField;
    private JTextField noOfEmpsField;
    private JTextField noOfDevMugField;
    private JTextField noOfDevGogField;
    private JTextField simTimeField;
    private JTextField seedField;

    private JButton start; // start the simulation

    private GUIInputs input;

    private boolean edidtable; // true for Main Menu

    public InputPanel(boolean editable, GUIInputs input) {
        this.edidtable = editable;
        this.input = input;
        setBorder(BorderFactory.createLineBorder(Color.BLUE));
        instantiateComponents();
        addComponents();
    }

    public void actionPerformed(ActionEvent e) {
        GUIInputs input = new GUIInputs(validateIntField(noOfDevGogField),
                validateIntField(noOfDevMugField),
                validateIntField(simTimeField),
                validateIntField(noOfFloorsField),
                validateIntField(elCapField),
                validateDoubleField(qField),
                validateDoubleField(pField),
                validateIntField(noOfEmpsField),
                validSeed(seedField));

        //this.setVisible(false);
        Thread simulation = new Thread(new ElevatorSimulator(input));
        simulation.start();
    }

    public void instantiateComponents() {
        setLayout(new FlowLayout());

        pLabel = new JLabel("Probability for P");
        qLabel = new JLabel("Probability for Q");
        elCapLabel = new JLabel("Elevator capacity");
        noOfFloorsLabel = new JLabel("Number of floors");
        noOfEmpsLabel = new JLabel("Number of employees");
        noOfDevMugLabel = new JLabel("Number of Mugtomes developers");
        noOfDevGogLabel = new JLabel("Number of Goggles developers");
        simTimeLabel = new JLabel("Simulation time (Ticks)");
        seedLabel = new JLabel("Seed (Optional)");

        pField = new JTextField(15);
        pField.setName("Probability for P");
        pField.setEditable(edidtable);
        qField = new JTextField(15);
        qField.setName("Probability for Q");
        qField.setEditable(edidtable);
        elCapField = new JTextField(15);
        elCapField.setName("Elevator capacity");
        elCapField.setEditable(edidtable);
        noOfFloorsField = new JTextField(15);
        noOfFloorsField.setName("Number of floors");
        noOfFloorsField.setEditable(edidtable);
        noOfEmpsField = new JTextField(15);
        noOfEmpsField.setName("Number of employees");
        noOfEmpsField.setEditable(edidtable);
        noOfDevMugField = new JTextField(15);
        noOfDevMugField.setName("Number of Mugtomes developers");
        noOfDevMugField.setEditable(edidtable);
        noOfDevGogField = new JTextField(15);
        noOfDevGogField.setName("Number of Goggles developers");
        noOfDevGogField.setEditable(edidtable);
        simTimeField = new JTextField(15);
        simTimeField.setName("Simulation time");
        simTimeField.setEditable(edidtable);
        seedField = new JTextField(15);
        seedField.setName("Seed");
        seedField.setEditable(edidtable);

        start = new JButton("START");
        start.setVisible(edidtable);

    }

    public void addComponents() {
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

        add(seedLabel);
        add(seedField);

        if(edidtable){ // add the button if the editable is true
            add(start);
            start.addActionListener(this);
        } else { // if false set the field text based on the input parameter
            pField.setText(Double.toString(input.getP()));
            qField.setText(Double.toString(input.getQ()));
            elCapField.setText(Integer.toString(input.getMaxCapacity()));
            noOfFloorsField.setText(Integer.toString(input.getNoOfFloors()));
            noOfEmpsField.setText(Integer.toString(input.getNumberOfEmployees()));
            noOfDevMugField.setText(Integer.toString(input.getNumberOfMugtomes()));
            noOfDevGogField.setText(Integer.toString(input.getNumberOfGoggles()));
            simTimeField.setText(Integer.toString(input.getTicks()));
            seedField.setText((input.getSeed() == -1) ? "No seed" : Integer.toString(input.getSeed()));
        }
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

    private int validSeed(JTextField seedField){
        if(seedField.getText().trim().length() == 0){
            return -1;
        } else {
            return validateIntField(seedField);
        }
    }
}
