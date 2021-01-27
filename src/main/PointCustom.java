package main;

import java.awt.*;

public class PointCustom {
    public int x;
    public int y;

    public PointCustom (Point point)
    {
       // this.x = x;
        //this.y = y;
        x = (int) point.getX();
        y = (int) point.getY();

    }
 //   public String toString(){
    //     String result = String.valueOf(x);
     //   return result;
    //}


}
