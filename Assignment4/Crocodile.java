package Assignment4;

public class Crocodile extends Reptiles{
	private final String sound = "Hiss"; 
	private final String type = "Crocodile";
	
	/**
	 * Initialize a Crocodile Object
	 * @param name String, Name of Crocodile
	 * @param weight int, Weight of Crocodile
	 * @param age int, Age of Crocodile
	 */
	public Crocodile(String name,int weight, int age) {
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
