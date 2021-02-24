package main;

import model.ShapeType;

import java.awt.*;
import java.io.IOException;
import java.util.Stack;

import static model.ShapeType.TRIANGLE;


public class PasteCommand implements ICommand,IUndoable {

    public static Stack<ShapeCustom> Clipboard = new Stack<>();

    private ShapeCustom shape;
    public int deltax;
    public int deltay;
    private ShapeCustom s_copy;



    RectangleDrawer rectangleDrawer = new RectangleDrawer();


    public PasteCommand(){

    }


    @Override
    public void run() throws IOException, CloneNotSupportedException {

        for (ShapeCustom s : CopyCommand.Clipboard) {
            ShapeCustom s_copy = s.clone();
            this.s_copy = s_copy;
            if (s_copy.shapeType.equals(TRIANGLE)){
                s_copy.x = s_copy.getX()+100;
                s_copy.y = s_copy.getY()+100;
                s_copy.x2 = s_copy.getX2()+100;
                s_copy.y2 = s_copy.getY2()+100;
                AddShapeCommand.shapeList.push(s_copy);
                rectangleDrawer.draw();
            }
            else {
                s_copy.x = s_copy.getX()+100;
                s_copy.y = s_copy.getY()+100;
                AddShapeCommand.shapeList.push(s_copy);
                rectangleDrawer.draw();
            }
            CommandHistory.add(this);

        }
    }
    @Override
    public void undo() {
        AddShapeCommand.shapeList.pop();
        Graphics2D graphics2D = ClickHandler.canvas.getGraphics2D();
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0,0,ClickHandler.canvas.getWidth(),ClickHandler.canvas.getHeight());
        rectangleDrawer.draw();


    }

    @Override
    public void redo() {
        AddShapeCommand.shapeList.push(s_copy);
        Graphics2D graphics2D = ClickHandler.canvas.getGraphics2D();
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0,0,ClickHandler.canvas.getWidth(),ClickHandler.canvas.getHeight());
        rectangleDrawer.draw();


    }
}
