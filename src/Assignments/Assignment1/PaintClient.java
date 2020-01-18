package Assignments.Assignment1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;
import java.awt.*;
import java.awt.event.*;

public class PaintClient{
    public static void main(String [] args){

        //Declaring JComponents
        JPanel painterPanel = new JPanel();
        JPanel canvasPanel = new JPanel();
        JPanel optionsPanel = new JPanel();
        JComboBox<String> brushBox = new JComboBox<>();
        JColorChooser cc = new JColorChooser();
        JFrame painterFrame = new JFrame();
        JFrame advancedOptions = new JFrame();
        JButton optionsBtn = new JButton("Advanced Options");
        JSlider sizeSlider = new JSlider();

        /* Configuring JComboBox */
        brushBox.addItem("Rectangle");
        brushBox.addItem("Oval");

        /* Configuring JColourChooser */
        cc.setColor(Color.BLACK);

        /* Configuring JSlider */
        sizeSlider.setMinimum(10);
        sizeSlider.setMaximum(40);
        sizeSlider.setValue(10);

        /* Configuring JPanels */
        //Painter Options Panel
        painterPanel.add(brushBox);
        painterPanel.add(optionsBtn);
        painterPanel.setVisible(true);
        //Canvas Panel
        canvasPanel.setPreferredSize(new Dimension(300, 200));
        canvasPanel.setVisible(true);
        canvasPanel.setBackground(Color.WHITE);

        //Menu Panel
        optionsPanel.add(cc);
        optionsPanel.add(sizeSlider);

        //Configuring JFrames
        //Painter Frame
        painterFrame.setSize(800, 800);
        painterFrame.setLayout(new BorderLayout());
        painterFrame.add(painterPanel, BorderLayout.NORTH);
        painterFrame.add(canvasPanel, BorderLayout.CENTER);
        painterFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Menu Frame
        advancedOptions.setSize(700, 400);
        advancedOptions.add(optionsPanel);
        //Setting frame to visible
        painterFrame.setVisible(true);

        /* Action Listeners */

        //Options Button Listener
        optionsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Graphics g = advancedOptions.getGraphics();
                advancedOptions.setVisible(true);
                //Updates the graphics once the frame is visible
                advancedOptions.update(g);
            }
        });
        //Canvas Mouse and Mouse Motion Listeners
        canvasPanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                //Check to see which of the two options in the Combobox are selected
                Graphics g = canvasPanel.getGraphics(); //Setting the graphics to that of the panel
                mousePaint(mouseEvent, g, brushBox, cc, sizeSlider);
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                /*Ignore, no code here*/
            }
        });

        canvasPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Graphics g = canvasPanel.getGraphics();
                System.out.println(brushBox.getSelectedItem());
                mousePaint(mouseEvent, g, brushBox, cc, sizeSlider);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });

    }

    /**
     * mousePaint - Handles the painting of the screen
     * @param mouseEvent - Mouse action event
     * @param g - graphics object to control the colour and drawing
     * @param brushBox - JCombobox with the select
     * @param cc - JColorChooser to adjust the colour
     * @param sizeSlider - The JSlider to adjust the size
     */
    private static void mousePaint(MouseEvent mouseEvent, Graphics g, JComboBox<String> brushBox, JColorChooser cc, JSlider sizeSlider) {
        if(brushBox.getSelectedItem().equals("Rectangle")){
            g.setColor(cc.getColor());
                g.fillRect(mouseEvent.getX(), mouseEvent.getY(), sizeSlider.getValue(), sizeSlider.getValue());
        }else{
            g.setColor(cc.getColor());
            g.fillOval(mouseEvent.getX(), mouseEvent.getY(), sizeSlider.getValue(), sizeSlider.getValue());
        }
    }
}