package Assignment6;


public class Area {
	
	/**
	 * function to calculate are of Triangle
	 * @param base
	 * @param hight
	 * @return -> Double representing area of Triangle
	 */
	public static Double areaOfTriangle(Double base, Double hight){
		return 0.5 * base * hight;
	}
	
	/**
	 * function to calculate are of Rectangle
	 * @param width
	 * @param hight
	 * @return -> Double representing area of Rectangle
	 */
	public static  Double areaOfRectangle(Double width , Double hight){
		return width * hight;
	}
	
	/**
	 * function to calculate are of square
	 * @param side
	 * @return -> Double representing area of square 
	 */
	public static Double areaOfSquare(Double side){
		return Math.pow(side, 2);
	}
	
	/**
	 * function to calculate are of circle
	 * @param radius
	 * @return Double representing area of circle
	 */
	public static  Double areaOfCircle(Double radius){
		return Math.PI * Math.pow(radius, 2);
	}
}
