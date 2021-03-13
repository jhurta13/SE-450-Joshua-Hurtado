package main;

import model.ShapeType;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;


public class DeleteCommand implements ICommand,IUndoable {

    public static Stack<ShapeCustom> Clipboard = new Stack<>();
    public static Stack<ShapeCustom> deleteList = new Stack<>();


    private ShapeCustom shape;
    public int deltax;
    public int deltay;
    private ShapeCustom s;


    RectangleDrawer rectangleDrawer = new RectangleDrawer();


    public DeleteCommand(){
    }


    @Override
    public void run() throws IOException {


        for (ArrayList<ShapeCustom> g: SelectCommand.selectGroupslist){
            for(ShapeCustom s : g){
                this.s = s;
                deleteList.add(s);
                AddShapeCommand.shapeList.remove(s);
            }

        }
        rectangleDrawer.draw();
        CommandHistory.add(this);


    }

    @Override
    public void undo() {
        for (ShapeCustom s: deleteList){
            this.s = s;
            AddShapeCommand.shapeList.add(s);
        }
        rectangleDrawer.draw();


    }


    @Override
    public void redo() {

        for (ShapeCustom s: deleteList){
            this.s = s;
            AddShapeCommand.shapeList.remove(s);
        }
        rectangleDrawer.draw();

    }
}
