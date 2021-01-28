package main;

import view.interfaces.PaintCanvasBase;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ClickHandler extends MouseAdapter {
    public PaintCanvasBase canvas;
    PointCustom point1 = new PointCustom(); //starting point
    PointCustom point2 = new PointCustom(); //ending point
    int width;
    int height;


    public ClickHandler(PaintCanvasBase canvas) {
        super();
        this.canvas = canvas;



    }

    @Override
    public void mousePressed(MouseEvent e) {

        System.out.println(e.getX()+", "+e.getY());

        point1.x = e.getX();
        point1.y = e.getY();


    }

    @Override
    public void mouseReleased(MouseEvent e) {

        point2.x = e.getX();
        point2.y = e.getY();

        //width & height calculation
        width = Math.abs(point2.x - point1.x);
        height = Math.abs(point2.y - point1.y);

        //to do: filler pattern for setting shape attributes
        Shape shape = new Shape() {

           @Override
            public void draw(PaintCanvasBase paintCanvasBase, PointCustom point1, PointCustom point2, int width, int height) {
                super.draw(canvas,point1,point2,width,height);
            }
        };
        //shape.draw(canvas,point1,point2,width,height);

        ShapeList shapeList = new ShapeList();
        shape.setPoint1(point1);
        shape.setPoint2(point2);
        shape.setWidth(width);
        shape.setHeight(height);
        shapeList.addShape(shape);
        ShapeDrawer shapeDrawer = new ShapeDrawer(canvas,shapeList);
    }



}
