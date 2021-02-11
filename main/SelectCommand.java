package main;

import java.awt.*;
import java.io.IOException;
import java.util.Stack;


public class SelectCommand implements ICommand,IUndoable {

    public static Stack<ShapeCustom> SelectShapeList = new Stack<>();

    private ShapeCustom shape;



    RectangleDrawer rectangleDrawer = new RectangleDrawer();


    SelectCommand(ShapeCustom shape){
        this.shape = shape;
    }


    @Override
    public void run() throws IOException {
        SelectShapeList.clear();
        for (ShapeCustom s: AddShapeCommand.shapeList){
            if(shape.x < s.x2 && shape.x2 > s.x && shape.y < s.y2 && shape.y2>s.y){
                SelectShapeList.push(s);
            }
        }
        System.out.println(SelectShapeList.size());


        CommandHistory.add(this);


    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {


    }
}
