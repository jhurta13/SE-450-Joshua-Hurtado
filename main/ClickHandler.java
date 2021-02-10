package main;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
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
    public static ShapeColor shapeColor;
    public static ShapeColor shapeColor2;
    public static ShapeShadingType shapeShading;


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

        shapeType = Main.applicationState.getActiveShapeType();
        shapeColor = Main.applicationState.getActivePrimaryColor();
        shapeColor2 = Main.applicationState.getActiveSecondaryColor();

        GetShapeColor getShapeColor = new GetShapeColor();
        Color color = getShapeColor.GetShapeColor(shapeColor);

        GetShapeColor getShapeColor2 = new GetShapeColor();
        Color color2 = getShapeColor2.GetShapeColor(shapeColor2);

        shapeShading = Main.applicationState.getActiveShapeShadingType();

        ShapeCustom shapeCustom = new ShapeCustom();
        shapeCustom.height = height;
        shapeCustom.width = width;
        shapeCustom.x = x;
        shapeCustom.y = y;
        shapeCustom.y2 = y2;
        shapeCustom.x2 = x2;
        shapeCustom.shapeType=shapeType;
        shapeCustom.color = color;
        shapeCustom.color2 = color2;
        shapeCustom.shapeShadingType = shapeShading;


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
