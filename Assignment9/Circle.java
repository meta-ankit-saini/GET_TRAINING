package Assignment9;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class for Shape Circle 
 * @author ankit.saini_metacube
 *
 */
public class Circle implements Shape {
	private double radius;
	private Point origin;
	private String timeStamp;

	/**
	 * Constructor to initialize Circle
	 * @param origin
	 * @param radius
	 */
	public Circle(Point origin,double radius) {
		this.origin = origin;
		this.radius = radius;
		this.timeStamp = DateTimeFormatter.ofPattern("yyyy--MM-dd HH:mm:ss").format(LocalDateTime.now());
	}
	
	@Override
	public double getArea(){
		return Math.PI * radius * radius;
	}
	
	@Override
	public double getPerimeter(){
		return 2 * Math.PI * radius; 
	}
	
	@Override
	public Point getOrigin(){
		return this.origin;
				
	}
	

	@Override
	public boolean isPointEnclosed(Point point) {
		
		boolean isPointEnclosed = false;
		Double xScreenOrigin = Screen.getOrigin().getX();
		Double yScreenOrigin = Screen.getOrigin().getY();
		Double xCentre = origin.getX() + radius * Math.sqrt(1 + Math.pow(((origin.getY() - yScreenOrigin) / (origin.getX() - xScreenOrigin)), 2));
		Double yCentre = origin.getY() + radius * Math.sqrt(1 + Math.pow(((origin.getY() - yScreenOrigin) / (origin.getX() - xScreenOrigin)), 2));
		Double distanceFromCentre = Math.sqrt(Math.pow(origin.getX() - xCentre, 2)
				+ Math.pow(origin.getY() - yCentre, 2));
		
		if(distanceFromCentre <= this.radius){
			isPointEnclosed = true;
		}
		return isPointEnclosed;
	}

	@Override
	public String getTimeStamp() {
		return this.timeStamp;
	}

	@Override
	public String getShapeType() {
		return "Circle";
	}
	
	@Override
	public boolean canBeAdeedInRegion(Point screenMax){
		Double xScreenOrigin = Screen.getOrigin().getX();
		Double yScreenOrigin = Screen.getOrigin().getY();
		Double XMAX = screenMax.getX();
		Double YMAX = screenMax.getY();
		Double xCentre = origin.getX() + radius * Math.sqrt(1 + Math.pow(((origin.getY() - yScreenOrigin) / (origin.getX() - xScreenOrigin)), 2));
		Double yCentre = origin.getY() + radius * Math.sqrt(1 + Math.pow(((origin.getY() - yScreenOrigin) / (origin.getX() - xScreenOrigin)), 2));
		if ( xScreenOrigin <= xCentre - radius && yScreenOrigin <= xCentre - radius && XMAX >= xCentre + radius && YMAX >= yCentre + radius )
			return true;
		return false;
	}
	
	@Override
	public Double distanceFromOrigin(){
		Point screenOrigin = Screen.getOrigin();
		return Math.sqrt(Math.pow(origin.getX() - screenOrigin.getX(), 2)
				+ Math.pow(origin.getY()- screenOrigin.getY(), 2));
	}
}
