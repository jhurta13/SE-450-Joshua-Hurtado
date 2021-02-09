package main;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ShapeList {

    public List<Shape> shapeList = new LinkedList<>();


    public ShapeList(){

    }
    public void addShape(Shape shape){
        shapeList.add(shape);
    }

    public List<Shape> getList(){
        return (shapeList);
    }



}
