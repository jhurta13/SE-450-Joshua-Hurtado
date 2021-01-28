package main;

import view.interfaces.PaintCanvasBase;
import java.awt.*;

public class Shape implements IShape {

    private PointCustom point1;
    private PointCustom point2;
    private int width;
    private int height;
    private PaintCanvasBase paintCanvasBase;

    public Shape(PaintCanvasBase paintCanvasBase, PointCustom point1, PointCustom point2, int width, int height) {
    this.paintCanvasBase=paintCanvasBase;
    this.point1=point1;
    this.point2=point2;
    this.width=width;
    this.height=height;
    }

    @Override
    public void draw() {
        Graphics2D graphics2D = paintCanvasBase.getGraphics2D();
       graphics2D.setColor(Color.green);
   graphics2D.fillRect(point1.x, point1.y, width, height);

    }


    //public void setPoint1(PointCustom point1){
      //  this.point1 = point1;
    //}
    //public void setPoint2(PointCustom point2){
      //  this.point2 = point2;
    //}
    //public void setWidth(int width){
      //  this.width = width;
    //}
    //public void setHeight(int height){
      //  this.height = height;
    //}
    public PointCustom getPoint1(){
        return (point1);
    }
    public PointCustom getPoint2(){
        return (point2);
    }
    public int getWidth(){
        return (width);
    }
    public int getHeight(){
        return (height);
    }


}