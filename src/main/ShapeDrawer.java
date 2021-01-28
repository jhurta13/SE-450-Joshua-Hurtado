package main;

import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class ShapeDrawer {

    public ShapeDrawer(PaintCanvasBase canvas, ShapeList shapeList){

        for (Shape s: shapeList.getList()){
            s.draw(canvas, s.getPoint1(),s.getPoint2(),s.getWidth(),s.getHeight());
        }

    }
    //take in shapelist
    //for every shape in shapelist, pass in shape.draw

}
