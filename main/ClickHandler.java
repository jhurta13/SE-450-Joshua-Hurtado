package main;

import view.interfaces.PaintCanvasBase;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class ClickHandler extends MouseAdapter {
    public static PaintCanvasBase canvas;
    PointCustom point1 = new PointCustom(); //starting point
    PointCustom point2 = new PointCustom(); //ending point
    public static int x;
    public static int y;
    public static int width;
    public static int height;

    public ClickHandler(PaintCanvasBase canvas) {
        super();
        this.canvas = canvas;



    }

    @Override
    public void mousePressed(MouseEvent e) {

        System.out.println(e.getX()+", "+e.getY());

        point1.x = e.getX();
        point1.y = e.getY();
        y = e.getY();
        x = e.getX();


    }

    @Override
    public void mouseReleased(MouseEvent e) {

        point2.x = e.getX();
        point2.y = e.getY();

        //width & height calculation
        width = Math.abs(point2.x - point1.x);
        height = Math.abs(point2.y - point1.y);


        ShapeFactory shapeFactory = new ShapeFactory();
        IShape shape = shapeFactory.GetShape(null);

        ICommand command;
        command = new AddShapeCommand(shape);


        try {
            command.run();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }



}
