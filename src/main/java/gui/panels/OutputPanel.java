package gui.panels;

import gui.dto.GUIUpdates;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IPREMGI on 20/05/2017.
 * This JPanel contains information about the elevator and simulation
 *  - Tick
 *  - Number of complaints
 *  - Elevator Direction
 *  - Current Floor
 *  - Door Status
 *  - Elevator Capacity
 */
public class OutputPanel extends JPanel implements IPanels {

    private JLabel ticksLabel;
    private JLabel noOfCompLabel;
    private JLabel elDirLabel;
    private JLabel curFloorLabel;
    private JLabel doorStatusLabel;
    private JLabel elCapLabel;

    private JTextField ticksField;
    private JTextField noOfCompField;
    private JTextField elDirField;
    private JTextField curFloorField;
    private JTextField doorStatusField;
    private JTextField elCapField;

    public OutputPanel() {
        setLayout(new GridLayout(6,2,2,2));
        setBorder(BorderFactory.createLineBorder(Color.GREEN));

        instantiateComponents();
        addComponents();
    }

    /**
     * Setting all the field with the new data
     * @param param - object containing updated information
     */
    public void update(GUIUpdates param){
        ticksField.setText(param.getTick());
        noOfCompField.setText(param.getNumberOfComplaints());
        elDirField.setText(param.getDirection().name());
        curFloorField.setText(param.getElevatorfloor());
        doorStatusField.setText(param.getDoorStatus().name());
        elCapField.setText(param.getCapacity());

        //repaint(); // updates the JPanel with new values
    }

    public void instantiateComponents() {
        ticksLabel = new JLabel("Tick", SwingConstants.CENTER);
        noOfCompLabel = new JLabel("No of Complaints", SwingConstants.CENTER);
        elDirLabel = new JLabel("Elevator Direction", SwingConstants.CENTER);
        curFloorLabel = new JLabel("Current Floor", SwingConstants.CENTER);
        doorStatusLabel = new JLabel("Door Status", SwingConstants.CENTER);
        elCapLabel = new JLabel("Elevator Capacity", SwingConstants.CENTER);

        ticksField = new JTextField("0", SwingConstants.CENTER);
        noOfCompField = new JTextField("0", SwingConstants.CENTER);
        elDirField = new JTextField("STATIONARY", SwingConstants.CENTER);
        curFloorField = new JTextField("0", SwingConstants.CENTER);
        doorStatusField = new JTextField("CLOSED", SwingConstants.CENTER);
        elCapField = new JTextField("0", SwingConstants.CENTER);

        ticksField.setEditable(false);
        noOfCompField.setEditable(false);
        elDirField.setEditable(false);
        curFloorField.setEditable(false);
        doorStatusField.setEditable(false);
        elCapField.setEditable(false);
    }

    public void addComponents() {
        add(ticksLabel);
        add(ticksField);

        add(noOfCompLabel);
        add(noOfCompField);

        add(elDirLabel);
        add(elDirField);

        add(curFloorLabel);
        add(curFloorField);

        add(doorStatusLabel);
        add(doorStatusField);

        add(elCapLabel);
        add(elCapField);
    }
}
