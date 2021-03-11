package Assignment9;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main Class
 * @author ankit.saini_metacube
 *
 */
public class Main {
	
	
	public static void main(String[] args){
		Screen screen = new Screen();
		Shape c1 = ShapeFactory.createShape("Circle", new Point(30., 30.),new int[] {20} );
		Shape c2 = ShapeFactory.createShape("Circle", new Point(60., 60.),new int[] {30} );
		Shape s1 = ShapeFactory.createShape("Square", new Point(160., 160.),new int[] {30} );
		Shape s2 = ShapeFactory.createShape("Square", new Point(70., 70.),new int[] {50} );
		
		screen.addShape(c1);
		screen.addShape(c2);
		screen.addShape(s1);
		screen.addShape(s2);
		screen.printShapeList();
		
		System.out.println("Sorted by Area : ");
		screen.getShapesSortedByArea();
		
		System.out.println("Sorted by Perimeter : ");
		screen.getShapesSortedByPerimeter();
		
		System.out.println("Sorted by Origin : ");
		screen.getShapesSortedByOriginDistance();

		System.out.println("Sorted by Time : ");
		screen.getShapesSortedByTimeStamp();
		
		System.out.println("After removing s1 : ");
		screen.deleteShape(s1);
		screen.printShapeList();
		
		System.out.println("After Removing All Circle : ");
		screen.deleteAllShapesOfSpecificType("Circle");
		screen.printShapeList();
		
	}

}
