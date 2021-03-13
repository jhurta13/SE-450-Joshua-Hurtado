package main;

import model.ShapeType;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import static model.ShapeType.TRIANGLE;


public class PasteCommand implements ICommand,IUndoable {

    public static Stack<ShapeCustom> Clipboard = new Stack<>();

    private ShapeCustom shape;
    public int deltax;
    public int deltay;
    private ShapeCustom s_copy;
    ArrayList<ShapeCustom> group = new ArrayList<>();




    RectangleDrawer rectangleDrawer = new RectangleDrawer();
    GroupDrawer groupDrawer = new GroupDrawer();


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
                //AddShapeCommand.shapeList.push(s_copy);
                ArrayList<ShapeCustom> group = new ArrayList<>();
                this.group =  group;
                group.add(s_copy);
                GroupCommand.groupslist.add(group);
                //rectangleDrawer.draw();
                groupDrawer.draw();
            }
            else {
                s_copy.x = s_copy.getX()+100;
                s_copy.y = s_copy.getY()+100;
                //AddShapeCommand.shapeList.push(s_copy);
                ArrayList<ShapeCustom> group = new ArrayList<>();
                this.group = group;
                group.add(s_copy);
                //rectangleDrawer.draw();
                GroupCommand.groupslist.add(group);
                groupDrawer.draw();
            }
            CommandHistory.add(this);

        }
    }
    @Override
    public void undo() {
        // AddShapeCommand.shapeList.pop();
        GroupCommand.groupslist.remove(group);
        Graphics2D graphics2D = ClickHandler.canvas.getGraphics2D();
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0,0,ClickHandler.canvas.getWidth(),ClickHandler.canvas.getHeight());
        //rectangleDrawer.draw();
        groupDrawer.draw();


    }

    @Override
    public void redo() {
        //AddShapeCommand.shapeList.push(s_copy);
        GroupCommand.groupslist.add(group);
        Graphics2D graphics2D = ClickHandler.canvas.getGraphics2D();
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0,0,ClickHandler.canvas.getWidth(),ClickHandler.canvas.getHeight());
        groupDrawer.draw();
        //rectangleDrawer.draw();


    }
}
