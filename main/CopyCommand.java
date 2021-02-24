package main;

import model.ShapeType;

import java.awt.*;
import java.io.IOException;
import java.util.Stack;


public class CopyCommand implements ICommand,IUndoable {

    public static Stack<ShapeCustom> Clipboard = new Stack<>();

    private ShapeCustom shape;
    public int deltax;
    public int deltay;



    RectangleDrawer rectangleDrawer = new RectangleDrawer();


    public CopyCommand(){
    }


    @Override
    public void run() throws IOException {

        for (ShapeCustom s: SelectCommand.SelectShapeList){

            Clipboard.push(s);

        }

        System.out.println("Copied" + Clipboard.size());

        CommandHistory.add(this);


    }

    @Override
    public void undo() {


            }


    @Override
    public void redo() {

    }
}
