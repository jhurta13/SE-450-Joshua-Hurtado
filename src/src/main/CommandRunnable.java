package main;

import java.io.IOException;

public class CommandRunnable implements IUndoable,ICommand{

    ShapeList shapeList;

    @Override
    public void run() throws IOException {
        CommandHistory.add(shapeList);
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
