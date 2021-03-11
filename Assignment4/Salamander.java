package Assignment4;

public class Salamander extends Amphibians{
	private final String sound = "Clicks"; 
	private final String type = "Salamander";
	
	/**
	 * Initialize a Salamander Object
	 * @param name String, Name of Salamander
	 * @param weight int, Weight of Salamander
	 * @param age int, Age of Salamander
	 */
	public  Salamander(String name,int weight, int age) {
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
