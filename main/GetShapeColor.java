package main;

import model.ShapeColor;

import java.awt.*;
import java.util.EnumMap;

public class GetShapeColor {
    ShapeColor color;

    public java.awt.Color GetShapeColor(ShapeColor color){

        EnumMap<ShapeColor, java.awt.Color> colorMap = new EnumMap<>(ShapeColor.class);
        colorMap.put(ShapeColor.BLACK, Color.black);
        colorMap.put(ShapeColor.BLUE, Color.blue);
        colorMap.put(ShapeColor.CYAN, Color.cyan);
        colorMap.put(ShapeColor.DARK_GRAY, Color.darkGray);
        colorMap.put(ShapeColor.GRAY, Color.gray);
        colorMap.put(ShapeColor.GREEN, Color.green);
        colorMap.put(ShapeColor.LIGHT_GRAY, Color.lightGray);
        colorMap.put(ShapeColor.MAGENTA, Color.magenta);
        colorMap.put(ShapeColor.ORANGE, Color.orange);
        colorMap.put(ShapeColor.PINK, Color.pink);
        colorMap.put(ShapeColor.RED, Color.red);
        colorMap.put(ShapeColor.WHITE, Color.white);
        colorMap.put(ShapeColor.YELLOW, Color.yellow);

        this.color = color;
        return colorMap.get(color);



    }
}
