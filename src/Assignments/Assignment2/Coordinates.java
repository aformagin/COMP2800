package Assignments.Assignment2;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Coordinates {
    int x, y;
//    private Ellipse2D point;
//    private Rectangle pointFrame;
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
//        point = new Ellipse2D.Double();

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
