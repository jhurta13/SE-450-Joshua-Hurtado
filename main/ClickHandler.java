package main;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


public class ClickHandler extends MouseAdapter {
    public static PaintCanvasBase canvas;
    PointCustom point1 = new PointCustom(); //starting point
    PointCustom point2 = new PointCustom(); //ending point
    public static int x;
    public static int y;
    public static int y2;
    public static int x2;
    public static int width;
    public static int height;
    public static ShapeType shapeType;


    public ClickHandler(PaintCanvasBase canvas) {
        super();
        this.canvas = canvas;



    }

    @Override
    public void mousePressed(MouseEvent e) {


        point1.x = e.getX();
        point1.y = e.getY();
        y = e.getY();
        x = e.getX();


    }

    @Override
    public void mouseReleased(MouseEvent e) {

        point2.x = e.getX();
        point2.y = e.getY();
        y2 = e.getY();
        x2 = e.getX();

        //width & height calculation
        width = Math.abs(point2.x - point1.x);
        height = Math.abs(point2.y - point1.y);

        //extract shapetype
        shapeType = Main.applicationState.getActiveShapeType();

        ShapeCustom shapeCustom = new ShapeCustom();
        shapeCustom.height = height;
        shapeCustom.width = width;
        shapeCustom.x = x;
        shapeCustom.y = y;
        shapeCustom.y2 = y2;
        shapeCustom.x2 = x2;
        shapeCustom.shapeType=shapeType;


        //ShapeFactory shapeFactory = new ShapeFactory();
        //IShape shape = shapeFactory.GetShape(null);

        ICommand command;
        command = new AddShapeCommand(shapeCustom);


        try {
            command.run();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }



}
