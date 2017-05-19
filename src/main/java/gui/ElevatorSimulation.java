package gui;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;

/**
 * Created by IPREMGI on 17/05/2017.
 */
public class ElevatorSimulation extends JFrame {


    private JPanel simInputPanel; // simulation information inputted in the menu box
    private JPanel simOutputPanel; // output of the simulation
    private JPanel simPanel;
    private JPanel simulationPanel;


    public ElevatorSimulation(){
        simInputPanel = new ElevatorMenu();
        simInputPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        simPanel = new JPanel(new GridLayout(2,0,10,10));
        simPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        simOutputPanel = new JPanel(new GridLayout(5,2,2,2));
        simOutputPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));


        simOutputPanel.add(new JLabel("Tick",SwingConstants.CENTER));
        simOutputPanel.add(new JTextField("TICKS"));
        simOutputPanel.add(new JLabel("Number of complaints:"));
        simOutputPanel.add(new JTextField("NO OF COMPLAINTS"));
        simOutputPanel.add(new JLabel("Elevator direction"));
        simOutputPanel.add(new JTextField("DIRECTION"));
        simOutputPanel.add(new JLabel("Floor"));
        simOutputPanel.add(new JTextField("Current Floor"));
        simOutputPanel.add(new JLabel("Door Status:"));
        simOutputPanel.add(new JTextField("Door status"));






        simulationPanel = new JPanel();
        simulationPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        simPanel.add(simOutputPanel);
        simPanel.add(simulationPanel);


        setLayout(new GridLayout(1,1,10,20));
        add(simPanel);
        add(simInputPanel);
        setVisible(true);
        setSize(540,475);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }














//    public ElevatorSimulation() {
//
//        JLabel resultLabel = new JLabel("Probability for Q",
//                JLabel.LEADING); //== LEFT
//        JLabel result = new JLabel("0.005");
//        result.setForeground(Color.black);
//        result.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createLineBorder(Color.black),
//                BorderFactory.createEmptyBorder(5,5,5,5)
//        ));
//
//        JPanel resultPanel = new JPanel();
//        resultPanel.add(resultLabel);
//        //resultPanel.add(result);
//        resultPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        resultPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
//        resultPanel.setSize(20,20);
//        setLayout(new BorderLayout());
//
//        add(resultPanel,BorderLayout.WEST);
//
//        JPanel resultPanel2 = new JPanel();
//        resultPanel2.add(result);
//        resultPanel2.setSize(20,20);
//        resultPanel2.setBorder(BorderFactory.createLineBorder(Color.blue));
//
//        add(resultPanel2, BorderLayout.EAST);
//
//        this.setVisible(true);
//        this.setSize(250,240);
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//
//
//
//
//    }

//    public ElevatorSimulation() {
//
//        JLabel a = new JLabel("This is a label");
//        JTextField b = new JTextField(5);
//
//        JLabel a1 = new JLabel("Another Label");
//        JTextField b1 = new JTextField(5);
//
//        setLayout(new GridLayout(1,1,5,5));
//
//        JPanel p = new JPanel();
//        p.setSize(20,20);
//        p.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
//        p.add(a);
//        p.add(b);
//
////        JPanel p1 = new JPanel();
////        p1.setSize(30,30);
////        p1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
////        p1.add(a1);
////        p1.add(b1);
//
//        add(p);
////        add(p1);
//
//        add(new ElevatorMenu());
//
//        this.setVisible(true);
//        this.setSize(400,440);
//        this.setResizable(false);
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//
//
//    }













}
