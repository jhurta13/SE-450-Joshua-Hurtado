package main;

import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AddShapeCommand implements ICommand,IUndoable {

    public static Stack<ShapeCustom> shapeList = new Stack<>();
    private ShapeCustom shape;



    RectangleDrawer rectangleDrawer = new RectangleDrawer();


    AddShapeCommand(ShapeCustom shape){
        this.shape = shape;
    }


    @Override
    public void run() throws IOException {
        shapeList.push(shape);
        RectangleDrawer rectangleDrawer = new RectangleDrawer();
        rectangleDrawer.draw();
        CommandHistory.add(this);


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
        shapeList.add(shape);

    }
}
