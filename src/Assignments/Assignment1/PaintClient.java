package Assignments.Assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PaintClient {

    public static void main(String[] args) {
        //Variables
        boolean menuVisible = true;
        //

        //Create and configure JFrame
        JFrame painterFrame = new JFrame();
        painterFrame.setTitle("AF - Painter");
        painterFrame.setSize(640, 480);
        painterFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        painterFrame.setVisible(true);
        painterFrame.setLayout(new FlowLayout());


        //Create menu panel and painter panel
        JPanel menuPanel = new JPanel();
        JPanel painterPanel = new JPanel();
        JPanel canvasPanel = new JPanel();
        //Create combo box and continue button
        JComboBox brushBox = new JComboBox();
        JButton continueBtn = new JButton("Switch to Canvas");
        JButton palletteBtn = new JButton("Back to Pallette");
        JColorChooser cc = new JColorChooser();

        //Adding all components to the JPanels
        menuPanel.add(brushBox);
        menuPanel.add(continueBtn);
        menuPanel.setVisible(true);

        //Adding panels to the JFrame
        painterFrame.add(menuPanel);
        painterFrame.add(painterPanel);
        painterFrame.add(canvasPanel);
        painterPanel.add(palletteBtn);
        painterPanel.setVisible(false);
        canvasPanel.setVisible(false);
        canvasPanel.setBackground(Color.red);
        menuPanel.add(cc);
        canvasPanel.setPreferredSize(new Dimension(500, 300));

        /*
        Action Listeners
        Continue Button
        Pallatte Button
        Canvas Panel(for drawing)
         */
        continueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                painterPanel.setVisible(true);
                canvasPanel.setVisible(true);
                menuPanel.setVisible(false);
            }
        });

        palletteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                painterPanel.setVisible(false);
                canvasPanel.setVisible(false);
                menuPanel.setVisible(true);
            }
        });

        canvasPanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                //Check to see which of the two options in the Combobox are selected
                System.out.println("We are drawing on the screen! :D");
                Graphics g = canvasPanel.getGraphics();
                //TODO Change this to be a variable size
                g.drawRect(mouseEvent.getX(), mouseEvent.getY(), 2, 2);

            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                /*Ignore, no code here*/
            }
        });
    
    }

}
