package main;

import java.awt.*;
import java.io.IOException;
import java.util.Stack;
import java.util.StringJoiner;

import static model.ShapeType.TRIANGLE;


public class SelectCommand implements ICommand,IUndoable {

    public static Stack<ShapeCustom> SelectShapeList = new Stack<>();
    public static Stack<ShapeCustom> OutlineList = new Stack<>();


    private ShapeCustom shape;



    OutlineDrawer outlineDrawer = new OutlineDrawer();
    RectangleDrawer rectangleDrawer = new RectangleDrawer();



    SelectCommand(ShapeCustom shape){
        this.shape = shape;
    }


    @Override
    public void run() throws IOException, CloneNotSupportedException {
        OutlineList.clear();
        SelectShapeList.clear();
        rectangleDrawer.draw();
        for (ShapeCustom s: AddShapeCommand.shapeList){
            if(shape.x < s.x2 && shape.x2 > s.x && shape.y < s.y2 && shape.y2>s.y){
                SelectShapeList.push(s);
            }
        }
        for (ShapeCustom s: SelectShapeList){
            OutlineList.push(s);
        }
        for (ShapeCustom s: OutlineList){
            outlineDrawer.draw();
        }



    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {


    }
}
