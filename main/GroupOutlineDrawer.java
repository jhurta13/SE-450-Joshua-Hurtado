/*
Rename to ShapeDrawer, since this class implements all shapes
 */

package main;

import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

import java.util.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static model.ShapeType.*;

public class GroupOutlineDrawer extends ShapeDecorator{
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
    int minx;
    int miny;
    int maxx2;
    int maxy2;

    public GroupOutlineDrawer( ) {


    }
    public void draw() {


        this.paintCanvasBase = ClickHandler.canvas;
        Graphics2D graphics2D1 = paintCanvasBase.getGraphics2D();
        graphics2D1.setColor(Color.green);

        List<Integer> Xlist = new ArrayList<Integer>();
        try {
            for (ArrayList<ShapeCustom> g: SelectCommand.groupOutlinelist2) {
                for (ShapeCustom s : g) {
                    Xlist.add(s.getX());
                }
            }

            int minx = (Collections.min(Xlist));
            this.minx = minx;

        } catch (NoSuchElementException exception) {

        } catch (Exception exception) {
        }

        List<Integer> Ylist = new ArrayList<Integer>();
        try {
            for (ArrayList<ShapeCustom> g: SelectCommand.groupOutlinelist2) {
                for (ShapeCustom s : g) {
                    Ylist.add(s.getY());
                }
            }
            int miny = (Collections.min(Ylist));
            this.miny = miny;

        } catch (NoSuchElementException exception) {

        } catch (Exception exception) {
        }

        List<Integer> X2list = new ArrayList<Integer>();
        try {
            for (ArrayList<ShapeCustom> g: SelectCommand.groupOutlinelist2) {
                for (ShapeCustom s : g) {
                    X2list.add(s.getX2());
                }
            }
            int maxx2 = (Collections.max(X2list));
            this.maxx2 = maxx2;

        } catch (NoSuchElementException exception) {

        } catch (Exception exception) {
        }

        List<Integer> Y2list = new ArrayList<Integer>();
        try {
            for (ArrayList<ShapeCustom> g: SelectCommand.groupOutlinelist2) {
                for (ShapeCustom s : g) {
                    Y2list.add(s.getX());
                }
            }
            int maxy2 = (Collections.max(Y2list));
            this.maxy2 = maxy2;

        } catch (NoSuchElementException exception) {

        } catch (Exception exception) {
        }

        for (ArrayList<ShapeCustom> g: SelectCommand.groupOutlinelist2){
            for (ShapeCustom s: g){
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

                graphics2D1.setColor(Color.red);
                Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                graphics2D1.setStroke(dashed);
                graphics2D1.drawRect(minx, miny, maxx2, maxy2);



            }

        }

    }


}
