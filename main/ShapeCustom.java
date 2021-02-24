package main;

import model.MouseMode;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

public class ShapeCustom implements Cloneable {
    public int x;
    public int y;
    public int x2;
    public int y2;
    public int width;
    public int height;
    private PaintCanvasBase paintCanvasBase;
    public ShapeType shapeType;
    public Color color;
    public Color color2;
    public ShapeShadingType shapeShadingType;
    public MouseMode mouseMode;
    public int deltax;
    public int deltay;



    public ShapeCustom  ()
    {
        this.x = x;
        this.y = y;
        this.y2 = y2;
        this.x2 = x2;
        this.width = width;
        this.height = height;
        this.shapeShadingType = shapeShadingType;
        this.mouseMode = mouseMode;
        this.deltax = deltax;
        this.deltay = deltay;


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
    public Color getColor(){return color;}
    public Color getColor2(){return color2;}
    public ShapeShadingType getShapeShadingType(){return shapeShadingType;}
    public MouseMode getMouseMode(){return mouseMode;}
    public int getDeltax(){return deltax;}
    public int getDeltay(){return deltay;}
    @Override protected ShapeCustom clone() throws CloneNotSupportedException {
        return (ShapeCustom) super.clone();
    }




}
