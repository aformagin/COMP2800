package Assignments.Assignment2;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    Dimension windowSize = new Dimension(640, 480);
    public MyFrame(){
        OptionsPanel optionsPanel = new OptionsPanel();
        MyDrawingPanel panel = new MyDrawingPanel(optionsPanel);
        optionsPanel.setPreferredSize(new Dimension(100, 100));
        panel.setPreferredSize(new Dimension(400, 400));
        setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));
        setResizable(false);
        add(optionsPanel);
        add(panel);
        setSize(windowSize);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        //Add Options Panel

        //Add Drawing Panel
    }
}
