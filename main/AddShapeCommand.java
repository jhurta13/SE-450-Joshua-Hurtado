package main;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;


public class AddShapeCommand implements ICommand,IUndoable {

    public static Stack<ShapeCustom> shapeList = new Stack<>();
    private ShapeCustom shape;
    ArrayList<ShapeCustom> group = new ArrayList<>();



   // RectangleDrawer drawer = new RectangleDrawer();
   GroupDrawer groupDrawer = new GroupDrawer();



    AddShapeCommand(ShapeCustom shape) {
        this.shape = shape;
    }


    @Override
    public void run() throws IOException {

        ArrayList<Object> tempList = new ArrayList<>();

        //add all items from grouplist to templist as shapecustom objects
        for (ArrayList g : GroupCommand.groupslist) {
            for (Object s2 : g) {
                tempList.add(s2);
            }
        }
        shapeList.push(shape);
        for (ShapeCustom s : shapeList) {
            if ((!tempList.contains(s))) {
                ArrayList<ShapeCustom> group = new ArrayList<>();
                this.group = group;
                group.add(s);
                GroupCommand.groupslist.add(group);
            }
        }

        //RectangleDrawer rectangleDrawer = new RectangleDrawer();
        //rectangleDrawer.draw();
        groupDrawer.draw();
        CommandHistory.add(this);


    }

        @Override
        public void undo () {
           // AddShapeCommand.shapeList.pop();
            GroupCommand.groupslist.remove(group);
            Graphics2D graphics2D = ClickHandler.canvas.getGraphics2D();
            graphics2D.setColor(Color.white);
            graphics2D.fillRect(0, 0, ClickHandler.canvas.getWidth(), ClickHandler.canvas.getHeight());
            groupDrawer.draw();

        }

        @Override
        public void redo () {
            //AddShapeCommand.shapeList.push(shape);
            GroupCommand.groupslist.add(group);
            Graphics2D graphics2D = ClickHandler.canvas.getGraphics2D();
            graphics2D.setColor(Color.white);
            graphics2D.fillRect(0, 0, ClickHandler.canvas.getWidth(), ClickHandler.canvas.getHeight());
            groupDrawer.draw();
    }
}
