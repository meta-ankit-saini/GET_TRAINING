package Asssignment3_DSA;

/**
 * Class Stores information about the bowler
 * @author ankit.saini_metacube
 *
 */
public class Bowler {
	private String name;
	private int noOfBalls;
	
	public Bowler(String name , int noOfBalls){
		this.noOfBalls = noOfBalls;
		this.name = name;
	}
	
	public void subtractNoOFBalls(int quantity){
		this.noOfBalls -= quantity;
	}
	
	public String getName(){
		return name;
	}
	
	public int getNoOfBallsLeft(){
		return noOfBalls;
	}
}
