//needs work

package main;

import view.gui.PaintCanvas;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.io.IOException;

public class ShapeFactory implements IUndoable, ICommand{

    public ShapeFactory(PaintCanvasBase canvasBase, ShapeList shapeList){

        for (Shape s: shapeList.getList()){
            s.draw();

        }

    }

    @Override
    public void run() throws IOException {
        CommandHistory.add(this);
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
