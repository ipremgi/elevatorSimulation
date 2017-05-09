package gui;

import javax.swing.*;

/**
 * Created by IPREMGI on 08/05/2017.
 */
public class ElevatorDemo {

    public static void main(String[] args) {
        ElevatorCanvas ec = new ElevatorCanvas();

        JFrame jf = new JFrame();
        jf.add(ec);
        jf.setVisible(true);
        jf.setSize(700,450);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setTitle("Elevator");
    }
}
