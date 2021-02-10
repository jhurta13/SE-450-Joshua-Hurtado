package main;

import view.interfaces.PaintCanvasBase;

import java.util.List;

public class RectangleDrawer {



    public RectangleDrawer(PaintCanvasBase canvasBase){
        for (IShape s: AddShapeCommand.shapeList){
            s.draw();

        }
        System.out.println(AddShapeCommand.shapeList.size());
    }

}
