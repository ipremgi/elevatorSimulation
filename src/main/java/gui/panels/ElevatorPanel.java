package gui.panels;

import gui.GUIParameter;
import model.building.Elevator;
import model.user.ElevatorUser;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IPREMGI on 20/05/2017.
 */
public class ElevatorPanel extends JPanel implements IPanels {

    private JTextField elevator;

    public ElevatorPanel(){
        setLayout(new GridLayout(1,0));
        instantiateComponents();
        addComponents();
    }

    public void instantiateComponents() {
        elevator = new JTextField("EMPTY");
        elevator.setEditable(false);

    }

    public void addComponents() {
        add(elevator);
    }

    public void update(GUIParameter param){
        String names = "null";

        if(param.getElevatorOccupants().size() == 0 ){
            elevator.setText("EMPTY");
        } else {
            for (ElevatorUser user : param.getElevatorOccupants()) {
                names = names + "\n" + user.getID();
            }
            elevator.setText(names);
        }

        repaint();
    }
}
