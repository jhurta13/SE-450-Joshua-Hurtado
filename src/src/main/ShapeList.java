package main;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ShapeList implements ICommand,IUndoable {

    public List<Shape> shapeList = new LinkedList<>();


    public ShapeList(){

    }
    public void addShape(Shape shape){
        shapeList.add(shape);
    }

    public List<Shape> getList(){
        return (shapeList);
    }

    @Override
    public void run() throws IOException {
    CommandHistory.add(this);

    }

    @Override
    public void undo() {
        shapeList.remove(0);
    }

    @Override
    public void redo() {

    }


    }

