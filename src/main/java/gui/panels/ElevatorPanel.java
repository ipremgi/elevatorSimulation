package gui.panels;

import gui.dto.GUIUpdates;
import model.user.ElevatorUser;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IPREMGI on 20/05/2017.
 * This JPanel will contain the users in the elevator
 */
public class ElevatorPanel extends JPanel implements IPanels {

    private JLabel elevatorLabel;
    private JTextPane elevatorPane; // used to display the users in the elevator

    public ElevatorPanel(){
        setLayout(new GridLayout(2,0));
        setBorder(BorderFactory.createLineBorder(Color.RED));
        instantiateComponents();
        addComponents();
    }

    public void instantiateComponents() {
        elevatorLabel = new JLabel("Elevator");
        elevatorPane = new JTextPane();
        elevatorPane.setEditable(false);

    }

    public void addComponents() {
        add(elevatorLabel);
        add(new JScrollPane(elevatorPane));
    }

    /**
     * Updating the Pane component
     * @param param - object containing the number of users in the elevator
     */
    public void update(GUIUpdates param){
        String names = "";

        if(param.getElevatorOccupants().size() == 0 ){
            elevatorPane.setText("EMPTY");
        } else {
            for (ElevatorUser user : param.getElevatorOccupants()) {
                names = user.getID() + ",\n" + names;
            }
            elevatorPane.setText(names);
        }

        repaint(); // refresh the panel
    }
}
