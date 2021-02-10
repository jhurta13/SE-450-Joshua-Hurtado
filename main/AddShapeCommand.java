package main;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AddShapeCommand implements ICommand,IUndoable {

    public static List<IShape> shapeList = new LinkedList<>();
    private IShape shape;


    AddShapeCommand(IShape shape){
        this.shape = shape;
    }


    @Override
    public void run() throws IOException {
        shapeList.add(shape);
        RectangleDrawer rectangleDrawer = new RectangleDrawer(ClickHandler.canvas);
        CommandHistory.add(this);


    }
    public List getList(){
        return shapeList;
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
