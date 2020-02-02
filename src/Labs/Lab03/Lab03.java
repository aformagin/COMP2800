package Labs.Lab03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.security.SecureRandom;

public class Lab03 extends JPanel {
    boolean dir = true;
    public int rotate = 1;
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        SecureRandom random = new SecureRandom();

        //Setting the points for the Star
        int[] xPoints = {55, 67, 109, 73, 83, 55, 27, 37, 1, 43};
        int[] yPoints = {0, 36, 36, 54, 96, 72, 96, 54, 36, 36};

        //Creating the Graphics2D object
        Graphics2D g2d = (Graphics2D) g;

        //Creating path
        Polygon star = new Polygon(xPoints, yPoints, 10);
//        GeneralPath star = new GeneralPath();

//        //Set init coords
//        star.translate(xPoints[0], yPoints[0]);
//
//        //Create the star, this does not draw the star
//        for (int count = 1; count < xPoints.length; count++)
//            star.lineTo(xPoints[count], yPoints[count]);
//
//        star.closePath(); //Closes the pathing for the shape

        g2d.translate(150, 150); //Translate the origin to (150, 150)

        //Rotates around the origin

        if(dir)
            g2d.rotate((Math.PI/10) * ++rotate);
        else
            g2d.rotate((Math.PI/10) * --rotate);

        JButton toggle = new JButton("Toggle");
        toggle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dir = !dir;
            }
        });
        /* Removed For loop from textbook example*/

        //Setting random colour
        g2d.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        //Repainting the screen

        g2d.fillPolygon(star); //Draws the star

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public boolean changeDir(){
        this.dir = !dir;
        return dir;
    }
}// End of class

