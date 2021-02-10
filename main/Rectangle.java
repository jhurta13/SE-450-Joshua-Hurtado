package main;

import view.interfaces.PaintCanvasBase;
import java.awt.*;

public class Rectangle implements IShape {

    private  int x;
    private  int y;
    private PointCustom point1;
    private PointCustom point2;
    private int width;
    private int height;
    private PaintCanvasBase paintCanvasBase;


    public void Rectangle (){

    }


    @Override
    public void draw() {
        this.paintCanvasBase = ClickHandler.canvas;
        this.width = ClickHandler.width;
        this.height = ClickHandler.height;
        this.x = ClickHandler.x;
        this.y = ClickHandler.y;


        Graphics2D graphics2D = paintCanvasBase.getGraphics2D();
       graphics2D.setColor(Color.green);
   graphics2D.fillRect(x, y, width, height);

    }


}