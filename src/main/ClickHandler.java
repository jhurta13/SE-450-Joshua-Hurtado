package main;

import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ClickHandler extends MouseAdapter {
    private PaintCanvasBase canvas;



    public ClickHandler(PaintCanvasBase canvas) {
        super();
        this.canvas = canvas;



    }

    @Override
    public void mousePressed(MouseEvent e) {

        System.out.println(e.getX()+", "+e.getY());


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println(e.getX()+", "+e.getY());
        Graphics2D graphics2D = canvas.getGraphics2D();
        graphics2D.setColor(Color.blue);
        graphics2D.fillRect(0,0,100,100);



    }


}
