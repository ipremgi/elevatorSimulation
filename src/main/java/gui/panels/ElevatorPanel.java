package gui.panels;

import gui.dto.GUIUpdates;
import model.user.ElevatorUser;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IPREMGI on 20/05/2017.
 */
public class ElevatorPanel extends JPanel implements IPanels {

    private JLabel elevatorLabel;
    private JTextPane elevatorField;

    public ElevatorPanel(){
        setLayout(new GridLayout(2,0));
        setBorder(BorderFactory.createLineBorder(Color.RED));
        instantiateComponents();
        addComponents();
    }

    public void instantiateComponents() {
        elevatorLabel = new JLabel("Elevator");
        elevatorField = new JTextPane();
        elevatorField.setEditable(false);

    }

    public void addComponents() {
        add(elevatorLabel);
        add(elevatorField);
    }

    public void update(GUIUpdates param){
        String names = "";

        if(param.getElevatorOccupants().size() == 0 ){
            elevatorField.setText("EMPTY");
        } else {
            for (ElevatorUser user : param.getElevatorOccupants()) {
                names = user.getID() + ",\n" + names;
            }
            elevatorField.setText(names);
        }

        repaint();
    }
}
