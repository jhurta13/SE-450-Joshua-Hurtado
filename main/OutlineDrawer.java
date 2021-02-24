/*
Rename to ShapeDrawer, since this class implements all shapes
 */

package main;

import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

import static model.ShapeType.*;

public class OutlineDrawer implements IShapeDrawer{
    public PaintCanvasBase paintCanvasBase;
    public int x;
    public int y;
    public int x2;
    public int y2;
    public int height;
    public int width;
    public ShapeType shapeType;
    public Color color;
    public ShapeShadingType shapeShadingType;
    public Color color2;

    public OutlineDrawer( ) {


    }
    public void draw() {


        this.paintCanvasBase = ClickHandler.canvas;
        Graphics2D graphics2D1 = paintCanvasBase.getGraphics2D();
        graphics2D1.setColor(Color.green);




        for (ShapeCustom s: SelectCommand.OutlineList){
            x = s.getX();
            y = s.getY();
            y2 = s.getY2();
            x2 = s.getX2();

            width = s.getWidth();
            height = s.getHeight();
            shapeType = s.getShapeType();
            color = s.getColor();
            color2 = s.getColor2();
            shapeShadingType = s.getShapeShadingType();


            int[] xarray = new int[3];
            int[] yarray = new int[3];
            xarray[0]=x-10;
            xarray[1]=x2+30;
            xarray[2]=x-10;
            yarray[0]=y-20;
            yarray[1]=y2+10;
            yarray[2]=y2+10;

            if (shapeType.equals(RECTANGLE)){
                graphics2D1.setColor(Color.blue);
                Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                graphics2D1.setStroke(dashed);
                graphics2D1.drawRect(x-5, y-5, width+10, height+10);
            }
            else if (shapeType.equals(ELLIPSE)){
                graphics2D1.setColor(Color.blue);
                Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                graphics2D1.setStroke(dashed);
                graphics2D1.drawOval(x-5, y-5, width+10, height+10);

            }
            else if (shapeType.equals(TRIANGLE)){
                graphics2D1.setColor(Color.blue);
                Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                graphics2D1.setStroke(dashed);
                graphics2D1.drawPolygon(xarray,yarray,3);
            }
        }
    }

}
