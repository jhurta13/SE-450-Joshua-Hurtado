package main;

import view.interfaces.PaintCanvasBase;

public interface IShape {

    void draw(PaintCanvasBase paintCanvasBase, PointCustom point1, PointCustom point2, int width, int height);

    //create class to incrementally build object, builder pattern, shape factory
}
