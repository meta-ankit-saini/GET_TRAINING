package Assignment9;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Square implements Shape {
	private Point origin;
	private double side;
	private String timeStamp;
	
	/**
	 * Initialize Square object 
	 * @param origin Point, Point of Origin
	 * @param side double
	 */
	public Square(Point origin,double side) {
		this.origin = origin;
		this.side = side;
		this.timeStamp = DateTimeFormatter.ofPattern("yyyy--MM-dd HH:mm:ss").format(LocalDateTime.now());
	}
	
	
	@Override
	public double getArea() {
		return side * side;
	}

	@Override
	public double getPerimeter() {
		return 4 * side;
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		
		boolean isPointEnclosed = false;
		double xPoint = point.getX();
		double yPoint = point.getY();
		double yOrigin = origin.getY();
		double xOrigin = origin.getX();
		
		if( xPoint >= xOrigin && xPoint <= xOrigin + side && yPoint >= yOrigin && yPoint <= yOrigin + side ){
			isPointEnclosed = true ;
		}
		
		return isPointEnclosed;
	}

	@Override
	public String getTimeStamp() {
		return this.timeStamp;
	}
	
	@Override
	public String getShapeType() {
		return "Square";
	}
	
	@Override
	public boolean canBeAdeedInRegion(Point maxScreen){
		Double xScreenOrigin = 0.0;
		Double yScreenOrigin = 0.0;
		Double XMAX = maxScreen.getX();
		Double YMAX = maxScreen.getY();
		if ( xScreenOrigin <= origin.getX() && yScreenOrigin <= origin.getY() && XMAX >= origin.getX() + side   && YMAX >= origin.getY() + side )
			return true;
		return false;
	}
}
