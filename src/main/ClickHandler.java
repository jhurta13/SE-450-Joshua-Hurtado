package main;

import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ClickHandler extends MouseAdapter {
    private PaintCanvasBase canvas;
    Point point1 = new Point(); //starting point
    Point point2 = new Point(); //ending point
    int width;
    int height;


    public ClickHandler(PaintCanvasBase canvas) {
        super();
        this.canvas = canvas;



    }

    @Override
    public void mousePressed(MouseEvent e) {

        System.out.println(e.getX()+", "+e.getY());

        point1.x = e.getX();
        point1.y = e.getY();


    }

    @Override
    public void mouseReleased(MouseEvent e) {

        point2.x = e.getX();
        point2.y = e.getY();

        //width & height calculation
        width = Math.abs(point2.x - point1.x);
        height = Math.abs(point2.y - point1.y);

        int x = (int) e.getX();
        System.out.println(e.getX()+", "+e.getY());
        Graphics2D graphics2D = canvas.getGraphics2D();
        graphics2D.setColor(Color.blue);
        graphics2D.fillRect( point1.x,point1.y,width,height);



    }
    public void dimensions(){

    }


}
