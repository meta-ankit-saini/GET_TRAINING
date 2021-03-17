package Assignment9;

import Assignment9.Shape.ShapeType;

/**
 * Class for creating Object of different shape
 * @author ankit.saini_metacube
 *
 */
public class ShapeFactory {
	public static Shape createShape(String shapeType, Point origin, int[] shapeParameters) throws AssertionError{
		if(shapeType == null){
			throw new AssertionError("ShapeType Cannot be null");
		}
		if(origin == null){
			throw new AssertionError("Origin Cannot be null");
		}
		if(shapeParameters.length == 0 || shapeParameters == null){
			throw new AssertionError("ShapeParameters Invalid");
		}
		Shape shape = null;
		
		
		switch (ShapeType.valueOf(shapeType)) { 
        case Circle : shape = new Square(origin,shapeParameters[0]);
            		  break; 
        case Square : shape = new Square(origin,shapeParameters[0]);
           			  break;  
        default     : throw new AssertionError("ShapeType Not Supported");
        } 
		return shape;
	}
}
