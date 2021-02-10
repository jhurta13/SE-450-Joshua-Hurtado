package main;

import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.Iterator;

public class RectangleDrawer {
    public PaintCanvasBase paintCanvasBase;
    public int x;
    public int y;
    public int height;
    public int width;

    public RectangleDrawer( ) {


    }
    public void draw() {

        Graphics2D graphics2D = ClickHandler.canvas.getGraphics2D();
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0,0,ClickHandler.canvas.getWidth(),ClickHandler.canvas.getHeight());

        this.paintCanvasBase = ClickHandler.canvas;
        Graphics2D graphics2D1 = paintCanvasBase.getGraphics2D();
        graphics2D1.setColor(Color.green);



        for (ShapeCustom s: AddShapeCommand.shapeList){
            x = s.getX();
            y = s.getY();
            width = s.getWidth();
            height = s.getHeight();
            graphics2D1.fillRect(x, y, width, height);

        }
        System.out.println(AddShapeCommand.shapeList.size());
    }

}
