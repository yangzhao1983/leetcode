package zy.basics.javacore;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by kaiser_zhao on 2019/1/7.
 */
public class BallComponent extends JPanel {
    @Override
    public void repaint() {
        super.repaint();
        System.out.println("============== repaint");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("================== paint");
    }

    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;
    private java.util.List<Ball> balls = new ArrayList<>();

    public void add(Ball ball){
        balls.add(ball);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        for(Ball b: balls){
            g2.fill(b.getShape());
        }
    }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
