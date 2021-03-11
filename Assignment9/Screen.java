package Assignment9;

import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;

public class Screen {
	private Point origin; 
	private Point  maxPoint;
	private ArrayList<Shape> listOfShapes = new ArrayList<Shape>();
	
	/**
	 * Constructor toi nitialize Screen Object
	 */
	public Screen(){
		this.origin = new Point(0. , 0.);
		this.maxPoint = new Point(200. , 200.);
	}
	
	/**
	 * method to add Shape into Screen
	 * @param shape
	 * @return -> true if successfully added otherwise false
	 * @throws AssertionError
	 */
	public boolean addShape(Shape shape) throws AssertionError{
		if(shape == null){
			throw new AssertionError("Shape Value cannot be null");
		}
		Point originOfShape = shape.getOrigin();
		Double xShape =  originOfShape.getX(), yShape = originOfShape.getY();
		if (shape.canBeAdeedInRegion(maxPoint)){
			this.listOfShapes.add(shape);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * method to print all shapes
	 * @throws AssertionError
	 */
	public void printShapeList() throws AssertionError{
		if (listOfShapes.size() == 0){
			throw new AssertionError("No shapes in listOfShapes");
		}
		for (Shape shape : listOfShapes){
			System.out.println("Shape : " + shape.getShapeType());
			System.out.print("Origin :  " );
			shape.getOrigin().printPoint();
		}
	}
	
	/**
	 * method to delete specific shape
	 * @param shape
	 * @return
	 * @throws AssertionError
	 */
	public boolean deleteShape(Shape shape) throws AssertionError{
		if(shape == null)
			throw new AssertionError("Shape Value cannot be null");
		
		return this.listOfShapes.remove(shape);
	}
	
	/**
	 * method to count all shape of specific type
	 * @param type ->  type of shape
	 * @return
	 */
	public int countShapeOfSpecificType(String type){
		int count = 0;
		for (Shape shape : listOfShapes){
			if(shape.getShapeType().equals(type))
				count += 1;
		}
		return count;
	}
	
	/**
	 * method to delete all shape of specific type 
	 * @param type -> type of shape
	 */
	public void deleteAllShapesOfSpecificType(String type) {
		if(type == null){
			throw new AssertionError("Type Value cannot be null");
		}
		boolean hasShape = true;
		while(hasShape){
			for(Shape shape : listOfShapes){
				if(type.equals(shape.getShapeType())){
				hasShape = true;
				this.listOfShapes.remove(shape);
				break;
			    }
				hasShape = false;
		    }
	  	}
	}
	
	/**
	 * Method to get Shapes sorted by area
	 */
	public void getShapesSortedByArea(){
		Shape[] shapeArray = this.listOfShapes.toArray(new Shape[this.listOfShapes.size()]);
		for(int firstIndex = 0; firstIndex < shapeArray.length - 1; firstIndex++ ){
			for(int secondIndex = 0 ; secondIndex < shapeArray.length-firstIndex-1; secondIndex++){
				if(shapeArray[secondIndex].getArea() > shapeArray[secondIndex+1].getArea() ){
					Shape tempShape = shapeArray[secondIndex];
					shapeArray[secondIndex] = shapeArray[secondIndex+1];
					shapeArray[secondIndex+1] = tempShape;
				}
			}
		}
		for(Shape shape : shapeArray){
			System.out.println("Shape : "+ shape.getShapeType() + "   Area   : " + shape.getArea());
		}
	}
	
	/**
	 * Method to get Shapes sorted by Perimeter
	 */
	public void getShapesSortedByPerimeter(){
		Shape[] shapeArray = this.listOfShapes.toArray(new Shape[this.listOfShapes.size()]);
		for(int firstIndex = 0; firstIndex < shapeArray.length - 1; firstIndex++ ){
			for(int secondIndex = 0 ; secondIndex < shapeArray.length-firstIndex-1; secondIndex++){
				if(shapeArray[secondIndex].getPerimeter() > shapeArray[secondIndex+1].getPerimeter() ){
					Shape tempShape = shapeArray[secondIndex];
					shapeArray[secondIndex] = shapeArray[secondIndex+1];
					shapeArray[secondIndex+1] = tempShape;
				}
			}
		}
		for(Shape shape : shapeArray){
			System.out.println("Shape : "+ shape.getShapeType() + "   Perimeter   : " + shape.getPerimeter());
		}
	}
	
	/**
	 * Method to get Shapes sorted by origin distance
	 */
	public void getShapesSortedByOriginDistance(){
		Shape[] shapeArray = this.listOfShapes.toArray(new Shape[this.listOfShapes.size()]);
		for(int firstIndex = 0; firstIndex < shapeArray.length - 1; firstIndex++ ){
			for(int secondIndex = 0 ; secondIndex < shapeArray.length-firstIndex-1; secondIndex++){
				double distanceOfShape1 = Math.sqrt(Math.pow(shapeArray[secondIndex].getOrigin().getX() - origin.getX(), 2)
						+ Math.pow(shapeArray[secondIndex].getOrigin().getY()- origin.getY(), 2));
				double distanceOfShape2 = Math.sqrt(Math.pow(shapeArray[secondIndex+1].getOrigin().getX() - origin.getX(), 2)
						+ Math.pow(shapeArray[secondIndex+1].getOrigin().getY()- origin.getY(), 2));
				if( distanceOfShape1  > distanceOfShape2){
					Shape tempShape = shapeArray[secondIndex];
					shapeArray[secondIndex] = shapeArray[secondIndex+1];
					shapeArray[secondIndex+1] = tempShape;
				}
			}
		}
		for(Shape shape : shapeArray){
			double distanceFormOrigin = Math.sqrt(Math.pow(shape.getOrigin().getX() - origin.getX(), 2)
					+ Math.pow(shape.getOrigin().getY()- origin.getY(), 2));
			System.out.println("Shape : "+ shape.getShapeType() + "   Origin Distance   : " + distanceFormOrigin);
		}
	}
	
	/**
	 * Method to get Shapes sorted by timestamp
	 */
	public void getShapesSortedByTimeStamp(){
		
		Shape[] shapeArray = this.listOfShapes.toArray(new Shape[this.listOfShapes.size()]);
		for(int firstIndex = 0; firstIndex < shapeArray.length - 1; firstIndex++ ){
			for(int secondIndex = 0 ; secondIndex < shapeArray.length-firstIndex-1; secondIndex++){
				if(shapeArray[secondIndex].getTimeStamp().compareTo(shapeArray[secondIndex+1].getTimeStamp()) > 0 ){
					Shape tempShape = shapeArray[secondIndex];
					shapeArray[secondIndex] = shapeArray[secondIndex+1];
					shapeArray[secondIndex+1] = tempShape;
				}
			}
		}
		for(Shape shape : shapeArray){
			System.out.println("Shape : "+ shape.getShapeType() + "   TimeStamp   : " + shape.getTimeStamp());
		}
	}

	
	/**
	 * method to get Shapes that enclose a Specific Point
	 * @param point
	 * @return
	 * @throws AssertionError
	 */
	public ArrayList<Shape> getShapesEnclosingAPoint(Point point) throws AssertionError{
		if(point == null){
			throw new AssertionError("Point Cannot be null");
		}
		ArrayList<Shape> listOfShapesWithEnclosingPoint = new ArrayList<Shape>(); 
		for(Shape shape : this.listOfShapes){
			if(shape.isPointEnclosed(point)){
				listOfShapesWithEnclosingPoint.add(shape);
			}
		}
		return listOfShapesWithEnclosingPoint;
	}
}
