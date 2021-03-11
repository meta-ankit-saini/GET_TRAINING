package Assignment9;

/**
 * Interface For different Shapes
 * @author ankit.saini_metacube
 *
 */
public interface Shape {
	enum ShapeType {
		Square,
		Circle
	}
	
	/**
	 * method for computing area of Shape
	 * @return area of Shape
	 */
	public double getArea();
	
	/**
	 * method for computing perimeter of Shape
	 * @return perimeter of Shape
	 */
	public double getPerimeter();
	
	/**
	 * 
	 * @return Origin
	 */
	public Point getOrigin();
	
	/**
	 * method tom find out if a point lies within the shape or not
	 * @param point
	 * @return boolean representing yes or no
	 */
	public boolean isPointEnclosed(Point point);
	
	/**
	 * 
	 * @return Category Of Shape
	 */
	public String getShapeType();
	
	/**
	 * 
	 * @return Time at Which Shape is created
	 */
	public String getTimeStamp();
	
	/**
	 * 
	 * @param screenMax -> XMAX , YMAX
	 * @return -> if shape can be added into screen
	 */
	public boolean canBeAdeedInRegion(Point screenMax);
}
