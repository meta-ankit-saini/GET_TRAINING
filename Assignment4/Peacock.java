package Assignment4;

public class Peacock extends Bird{
	private final String sound = "Squawk"; 
	private final String type = "Peacock";
	
	/**
	 * Initialize a Lion Object
	 * @param name String, Name of Peacock
	 * @param weight int, Weight of Peacock
	 * @param age int, Age of Peacock
	 */
	public Peacock(String name,int weight, int age) {
		super(name,weight,age);

	}

	@Override
	public String getSound(){
		return this.sound;
	}
	
	@Override
	public String getType(){
		return this.type;
	}
}
