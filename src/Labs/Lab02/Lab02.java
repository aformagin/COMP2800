package Labs.Lab02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

public class Lab02 {
    public static void main(String[] args) {
        //Creating components
        JFrame myWindow = new JFrame();
        myPanel panel1 = new myPanel("Rectangle");
        myPanel panel2 = new myPanel("Oval");

        //Configuring Components
        myWindow.setSize(500, 500);
        myWindow.setVisible(true);
        myWindow.setLayout(new BorderLayout());
        myWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel1.setPreferredSize(new Dimension(350, 350));
        panel1.setLayout(null);
        panel2.setBackground(Color.GRAY);
        panel2.setBounds(100, 150, 200, 200);
        myWindow.add(panel1, BorderLayout.CENTER);
        panel1.add(panel2);
    }


}
