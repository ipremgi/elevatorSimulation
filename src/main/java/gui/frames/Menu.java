package gui.frames;

import gui.panels.InputPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IPREMGI on 20/05/2017.
 * The Menu Frame - this will allow the user to input their configuration
 */
public class Menu extends JFrame {

    public Menu(){
        setLayout(new GridLayout(1,0));
        startFrame();
    }

    private void startFrame(){
        add(new InputPanel(true, null));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setSize(210,500);
        setTitle("Elevator Menu");
    }
}
