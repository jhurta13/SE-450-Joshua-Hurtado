//needs work
package main;
import view.gui.PaintCanvas;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.io.IOException;

public class ShapeFactory {

    public ShapeFactory(PaintCanvasBase canvasBase, ShapeList shapeList){

        for (Shape s: shapeList.shapeList){
            s.draw();

        }
        System.out.println(shapeList.shapeList.size());
    }

}
