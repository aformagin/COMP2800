package Labs.Lab01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab01 {
    private static int count = 0;
    public static void main(String[] args) {

        //Creating the JFrame
        JFrame parentFrame = new JFrame();
        //PosX, PosY, Width, Height
        Rectangle buttonBounds = new Rectangle(150, 100, 200,75 );
        //Set the on exit for parentFrame so it will terminate the program
        JButton createChildButton = new JButton("Click to create child");
        parentFrame.setSize(500, 300);
        parentFrame.setVisible(true);
        parentFrame.setLayout(null);


        createChildButton.setBounds(buttonBounds);
        parentFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        parentFrame.add(createChildButton);
        parentFrame.setTitle("Parent Frame");

        //Create the actionListener
        createChildButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                count++;//Increases the count for the number of children

                //Creating and setting up child frame
                JFrame childFrame = new JFrame();
                childFrame.setSize(500, 300);
                childFrame.setLayout(null);
                childFrame.setVisible(true);

                //Creating and adding the JButton
                JButton colourButton = new JButton();
                colourButton.setBounds(buttonBounds);
                colourButton.setText("Change the colour of the parent!");
                childFrame.add(colourButton);
                childFrame.setTitle("Child Frame ["+ count + "]");

                //Action listener to change the colour of the parent window
                colourButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        int i, i1, i2;
                        i = random(0, 255);
                        i1 = random(0, 255);
                        i2 = random(0, 255);
                        Color c = new Color(i, i1, i2);
                        parentFrame.getContentPane().setBackground(c);
                    }
                });

            }
        });
    }
    public static int random(int min, int max){
        return (int)(Math.random() * (max - min + 1)) + min;
    }
}
