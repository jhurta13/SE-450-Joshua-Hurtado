package main;

import model.ShapeType;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class ShapeCustom {
    public int x;
    public int y;
    public int x2;
    public int y2;
    public int width;
    public int height;
    private PaintCanvasBase paintCanvasBase;
    public ShapeType shapeType;


    public ShapeCustom ()
    {
        this.x = x;
        this.y = y;
        this.y2 = y2;
        this.x2 = x2;
        this.width = width;
        this.height = height;




    }
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public ShapeType getShapeType() { return shapeType;}


}
