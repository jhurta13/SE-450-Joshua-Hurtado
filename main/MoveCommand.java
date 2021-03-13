package main;

import model.ShapeType;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;


public class MoveCommand implements ICommand,IUndoable {

    public static Stack<ShapeCustom> SelectShapeList = new Stack<>();

    private ShapeCustom shape;
    public int deltax;
    public int deltay;



    RectangleDrawer rectangleDrawer = new RectangleDrawer();
    GroupDrawer groupDrawer = new GroupDrawer();


    public MoveCommand(ShapeCustom shape){
        this.shape = shape;
    }


    @Override
    public void run() throws IOException {
        for (ArrayList<ShapeCustom> g: SelectCommand.selectGroupslist){
            for(ShapeCustom s: g){
                if (!s.shapeType.equals(ShapeType.TRIANGLE)){
                    s.x = s.x + shape.getDeltax();
                    s.y = s.y +shape.getDeltay();

                }
                else if(s.shapeType.equals(ShapeType.TRIANGLE)){
                    s.x = s.x +shape.getDeltax();
                    s.y = s.y +shape.getDeltay();
                    s.x2 = s.x2 + shape.getDeltax();
                    s.y2 = s.y2 + shape.getDeltay();
                }
            }
            }
            //implement

        //rectangleDrawer.draw();
        groupDrawer.draw();
        CommandHistory.add(this);


    }

    @Override
    public void undo() {

        for (ArrayList<ShapeCustom> g: SelectCommand.selectGroupslist){
            for(ShapeCustom s:g){
                if (!s.shapeType.equals(ShapeType.TRIANGLE)){
                    s.x = s.x + -1*shape.getDeltax();
                    s.y = s.y +-1*shape.getDeltay();

                }
                else if(s.shapeType.equals(ShapeType.TRIANGLE)){
                    s.x = s.x +-1*shape.getDeltax();
                    s.y = s.y +-1*shape.getDeltay();
                    s.x2 = s.x2 + -1*shape.getDeltax();
                    s.y2 = s.y2 + -1*shape.getDeltay();
                }

            }
            //implement

        }
        //rectangleDrawer.draw();
        groupDrawer.draw();


    }

    @Override
    public void redo() {
        for (ArrayList<ShapeCustom> g: SelectCommand.selectGroupslist){
            for (ShapeCustom s: g){
                if (!s.shapeType.equals(ShapeType.TRIANGLE)){
                    s.x = s.x + shape.getDeltax();
                    s.y = s.y +shape.getDeltay();

                }
                else if(s.shapeType.equals(ShapeType.TRIANGLE)){
                    s.x = s.x +shape.getDeltax();
                    s.y = s.y +shape.getDeltay();
                    s.x2 = s.x2 + shape.getDeltax();
                    s.y2 = s.y2 + shape.getDeltay();
                }
            }
            }
            //implement

        //rectangleDrawer.draw();
        groupDrawer.draw();


    }
}
