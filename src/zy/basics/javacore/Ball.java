package zy.basics.javacore;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by kaiser_zhao on 2019/1/7.
 */
public class Ball {
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;

    public void move(Rectangle2D bounds){
        x += dx;
        if(x < bounds.getMinX()){
            x = bounds.getMinX();
            dx = -dx;
        }

        if(x+XSIZE>=bounds.getMaxY()){
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }

        y += dy;
        if(y<bounds.getMinY()){
            y = bounds.getMinY();
            dy = -dy;
        }

        if(y+YSIZE >= bounds.getMaxY()){
            y = bounds.getMaxY() - YSIZE;
            dy = -dy;
        }

        System.out.println("move : " + x + y);
    }

    public Ellipse2D getShape(){
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }
}
