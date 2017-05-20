package gui.frames;

import gui.panels.InputPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IPREMGI on 20/05/2017.
 */
public class Menu extends JFrame {

    public Menu(){
        setLayout(new GridLayout(1,0));
        add(new InputPanel(true));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setSize(250,500);
        setTitle("Elevator Menu");
    }
}
