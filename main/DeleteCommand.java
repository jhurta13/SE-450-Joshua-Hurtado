package main;

import model.ShapeType;

import java.awt.*;
import java.io.IOException;
import java.util.Stack;


public class DeleteCommand implements ICommand,IUndoable {

    public static Stack<ShapeCustom> Clipboard = new Stack<>();

    private ShapeCustom shape;
    public int deltax;
    public int deltay;
    private ShapeCustom s;


    RectangleDrawer rectangleDrawer = new RectangleDrawer();


    public DeleteCommand(){
    }


    @Override
    public void run() throws IOException {

        for (ShapeCustom s: SelectCommand.SelectShapeList){
            this.s = s;
            AddShapeCommand.shapeList.pop();

        }
        rectangleDrawer.draw();
        CommandHistory.add(this);


    }

    @Override
    public void undo() {

        AddShapeCommand.shapeList.push(s);
        rectangleDrawer.draw();


    }


    @Override
    public void redo() {

        AddShapeCommand.shapeList.pop();
        rectangleDrawer.draw();

    }
}
