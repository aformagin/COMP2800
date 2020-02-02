package Assignments.Assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class MyDrawingPanel extends JPanel{
    private Coordinates p1, p2;
    private boolean coordOneSet = false;
    private static Point2D initPoint = new Point2D.Double(0,0);
    private static Point2D newPoint = new Point2D.Double(0,0);
    AffineTransform transform = new AffineTransform();


    ArrayList<Line2D> lineList = new ArrayList<>();
    public MyDrawingPanel(OptionsPanel optionsPanel){
        setBackground(Color.WHITE);

        /*Mouse click listener that will record the current (x,y) coordinates
         * then on the second click draw the line with the direction*/
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                String option = optionsPanel.getBox();
                switch (option){
                    case "Draw":
                        System.out.println("Draw Selected");
                        if(!coordOneSet){
                            p1 = new Coordinates(mouseEvent.getX(), mouseEvent.getY());
                            coordOneSet = true;
                        }else{
                            p2 = new Coordinates(mouseEvent.getX(), mouseEvent.getY());
                            System.out.println("Line?");
                            coordOneSet = false;
                            Line2D line = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
                            lineList.add(line);
                            repaint();
                        }//End of coordinate else
                        break;
                    case "Delete":
                        System.out.println("Delete Selected");
                        try{
                            /* Removes the line from lineList if it is under the mouse location
                             * or within the "Deadzone"/"Threshold"*/
                            lineList.removeIf(line -> line.ptLineDist(mouseEvent.getX(), mouseEvent.getY()) < 5
                                    && line.getBounds().contains(mouseEvent.getPoint()));
                        }catch(Exception e){
                            System.err.println("No lines under cursor");
                        }
                        repaint();
                        break;
                    case "Move":
                        System.out.println("Moved Selected - Refer to Motion Listener");
                        break;
                }//End of switch statements
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent){
                super.mousePressed(mouseEvent);
                initPoint.setLocation(mouseEvent.getPoint());
            }//End of mousePressed
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                super.mouseDragged(mouseEvent);

                if(optionsPanel.getBox().equals("Move")){

                    for(Line2D line: lineList){

                        if (line.ptLineDist(mouseEvent.getX(), mouseEvent.getY()) < 8
                                && line.getBounds().contains(mouseEvent.getPoint())) {

                            System.out.println("Moving?");
                            newPoint.setLocation(mouseEvent.getPoint());
                            double deltaX = findDelta(initPoint.getX(),newPoint.getX());
                            double deltaY = findDelta(initPoint.getY(),newPoint.getY());
                            line.setLine( new Line2D.Double(
                                    line.getX1() + deltaX, line.getY1() + deltaY,
                                    line.getX2() + deltaX, line.getY2() + deltaY
                            ));

                            repaint();
                            initPoint.setLocation(mouseEvent.getPoint());
                        }
                    }//End of for
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Polygon arrowHead = new Polygon();
        arrowHead.addPoint( 0,5);
        arrowHead.addPoint( -5, -5);
        arrowHead.addPoint( 5,-5);


        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setStroke(new BasicStroke(3));
        for (Line2D line : lineList) {
            System.out.println(line);
            g2d.draw(line);
            transform.setToIdentity();
            double angle = Math.atan2(line.getY2()-line.getY1(),
                    line.getX2()-line.getX1());
            transform.translate(line.getX2(), line.getY2());
            transform.rotate((angle-Math.PI/2d));

            Graphics2D g = (Graphics2D) g2d.create();
            g.setTransform(transform);
            g.fill(arrowHead);
            g.dispose();
        }


    }

    public double findDelta(double x1, double x2){
        return x2-x1;
    }
}
