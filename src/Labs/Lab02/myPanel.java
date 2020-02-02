package Labs.Lab02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class myPanel extends JPanel {
    int x, y;//Original Values for X and Y
    int scaleX, scaleY;
    String shape;

    public myPanel(String shape){
        this.shape = shape.toLowerCase();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);
                //Get the X/Y coordinates
                x = mouseEvent.getX();
                y = mouseEvent.getY();

                scaleX = mouseEvent.getX();
                scaleY = mouseEvent.getY();

                repaint();
                System.out.println("Pressed");
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                super.mouseDragged(mouseEvent);
                //Determine the scaling with scaleX and scaleY
                scaleX = mouseEvent.getX();
                scaleY = mouseEvent.getY();

                repaint();
                System.out.println("Dragged");
            }
        });
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        //These variables represent the top and bottom X/Y values to set
        int xTopCoord = 0;
        int xBotCoord = 0;
        int yTopCoord = 0;
        int yBotCoord = 0;

        //Sets the colour of the shapes
        graphics.setColor(Color.BLACK);

        /* Finding the corners of the shape */
        //X Coordinates
        if (scaleX > x){
            xBotCoord = scaleX;
            xTopCoord = x;
        } else {
            xBotCoord = x;
            xTopCoord = scaleX;
        }

        //Y Coordinates
        if (scaleY > y){
            yBotCoord = scaleY;
            yTopCoord = y;
        } else {
            yBotCoord = y;
            yTopCoord = scaleY;
        }

        //Draws the shape on the screen
        if(shape.equals("rectangle"))
            graphics.drawRect(xTopCoord, yTopCoord, xBotCoord - xTopCoord, yBotCoord - yTopCoord);
        else
            graphics.drawOval(xTopCoord, yTopCoord, xBotCoord - xTopCoord, yBotCoord - yTopCoord);
    }
}
