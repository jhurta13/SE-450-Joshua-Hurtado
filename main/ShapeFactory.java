package main;

public class ShapeFactory {


    public IShape GetShape(String ShapeType) {
        if (ShapeType == null) {
            return new Rectangle();
        }
       else{
                return null;
            }
        }
}