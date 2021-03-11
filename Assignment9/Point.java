package Assignment9;

/**
 * class representing coordinates of screen
 * @author ankit.saini_metacube
 *
 */
public class Point {
	private Double x,y;
	
	Point(Double x , Double y){
		this.x = x;
		this.y = y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public void printPoint(){
		System.out.print("X-coordinate : " + x);
		System.out.println("         Y-coordinate : "+ y);
	}
}
