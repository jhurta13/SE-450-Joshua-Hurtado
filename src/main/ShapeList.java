package main;

import java.util.LinkedList;
import java.util.List;

public class ShapeList {

    public ShapeList(){

    }

    public List<Shape> shapeList = new LinkedList<Shape>();

    public void addShape(Shape shape){
        shapeList.add(shape);
    }
    public List<Shape> getList(){
        return (shapeList);
    }

}
