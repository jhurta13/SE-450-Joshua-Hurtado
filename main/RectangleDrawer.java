/*
Rename to ShapeDrawer, since this class implements all shapes
 */

package main;

import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

import static model.ShapeType.*;

public class RectangleDrawer implements IShapeDrawer{
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

    public RectangleDrawer( ) {


    }
    public void draw() {

        Graphics2D graphics2D = ClickHandler.canvas.getGraphics2D();
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0,0,ClickHandler.canvas.getWidth(),ClickHandler.canvas.getHeight());

        this.paintCanvasBase = ClickHandler.canvas;
        Graphics2D graphics2D1 = paintCanvasBase.getGraphics2D();
        graphics2D1.setColor(Color.green);



        for (ShapeCustom s: AddShapeCommand.shapeList){
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
            xarray[0]=x;
            xarray[1]=x2;
            xarray[2]=x;
            yarray[0]=y;
            yarray[1]=y2;
            yarray[2]=y2;

            if (shapeType.equals(RECTANGLE)){
                if (shapeShadingType.equals(ShapeShadingType.FILLED_IN)){
                    graphics2D1.setColor(color);
                    graphics2D1.fillRect(x, y, width, height);
                }
                else if(shapeShadingType.equals(ShapeShadingType.OUTLINE)){
                    graphics2D1.setColor(color);
                    graphics2D1.drawRect(x, y, width, height);
                }
                else if (shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)){
                    graphics2D1.setColor(color);
                    graphics2D1.fillRect(x,y,width,height);
                    graphics2D1.setColor(color2);
                    graphics2D1.drawRect(x,y,width,height);
                }
            }
            else if (shapeType.equals(ELLIPSE)){
                if (shapeShadingType.equals(ShapeShadingType.FILLED_IN)){
                    graphics2D1.setColor(color);
                    graphics2D1.fillOval(x, y, width, height);
                }
                else if(shapeShadingType.equals(ShapeShadingType.OUTLINE)){
                    graphics2D1.setColor(color);
                    graphics2D1.drawOval(x, y, width, height);
                }
                else if (shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)){
                    graphics2D1.setColor(color);
                    graphics2D1.fillOval(x,y,width,height);
                    graphics2D1.setColor(color2);
                    graphics2D1.drawOval(x,y,width,height);
                }

            }
            else if (shapeType.equals(TRIANGLE)){
                if (shapeShadingType.equals(ShapeShadingType.FILLED_IN)){
                    graphics2D1.setColor(color);
                    graphics2D1.fillPolygon(xarray,yarray,3);
                }
                else if(shapeShadingType.equals(ShapeShadingType.OUTLINE)){
                    graphics2D1.setColor(color);
                    graphics2D1.drawPolygon(xarray,yarray,3);
                }
                else if (shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)){
                    graphics2D1.setColor(color);
                    graphics2D1.fillPolygon(xarray,yarray,3);
                    graphics2D1.setColor(color2);
                    graphics2D1.drawPolygon(xarray,yarray,3);
                }
            }
        }
        System.out.println(AddShapeCommand.shapeList.size());
    }

}
