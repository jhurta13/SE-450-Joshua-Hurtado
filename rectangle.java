package main;

import java.awt.*;

public class rectangle {
    private int x;
    private int y;
    private int width;
    private int height;

    public rectangle (int x, int y, int width, int height){
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    //draw the rectangle
    public void draw(Graphics2D g) {
        g.setColor(Color.blue);
        g.fillRect(x,y,width,height);
    }
}
