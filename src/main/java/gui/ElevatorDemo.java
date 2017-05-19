package gui;

import javax.swing.*;

/**
 * Created by IPREMGI on 08/05/2017.
 */
public class ElevatorDemo {

//    public static void main(String[] args) {
//        ElevatorCanvas ec = new ElevatorCanvas();
//
//
//        JFrame jf = new JFrame();
//        jf.add(ec);
//        jf.setVisible(true);
//        jf.setSize(700,450);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jf.setTitle("Elevator");
//    }

//    public static void main(String[] args) {
//        //1. Create the frame.
//        JFrame frame = new JFrame("FrameDemo");
//
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500,500);
//
//        frame.setVisible(true);
//    }


    public static void main(String[] args) {
        ElevatorMenu em = new ElevatorMenu();
        em.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        em.setResizable(false);
        em.setVisible(true);
        em.setSize(250,500);
        em.setTitle("Elevator Menu");
    }
}
