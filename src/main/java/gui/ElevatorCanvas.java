package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

/**
 * Created by IPREMGI on 08/05/2017.
 */
public class ElevatorCanvas extends JPanel implements ActionListener{


    Timer t = new Timer(200, this);
    int x = 0;
    int y = 150;

    int vy = 100;

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.LIGHT_GRAY);
        g2.draw3DRect(20, 20, 120, 600, true); // outside box

        g2.setColor(Color.BLACK);
        g2.drawRect(30,y,100,100); // elevator
        Rectangle2D person1 = new Rectangle.Double(40, y + 10, 35.0, 35.0); // person
        g2.fill(person1);
        g2.setColor(Color.RED);
        Rectangle2D person2 = new Rectangle2D.Double(85, y + 10, 35.0, 35.0) ;
        g2.fill(person2);
        g2.setColor(Color.GREEN);
        Rectangle2D person3 = new Rectangle.Double(40, y + 55, 35.0,35.0);
        g2.fill(person3);
        g2.setColor(Color.YELLOW);
        Rectangle2D person4 = new Rectangle2D.Double(85, y + 55, 35.0, 35.0);
        System.out.println(person4.);
        g2.fill(person4);









        t.start();
    }


    public void actionPerformed(ActionEvent e) {
        if (y < 150  || y > 400){
            vy = -vy;
        }

        y += vy;
        repaint();

    }
}
