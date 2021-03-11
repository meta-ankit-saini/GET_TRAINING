package Assignment4;

public class Alligator extends Reptiles {
	private final String sound = "Bellow"; 
	private final String type = "Alligator";
	
	/**
	 * Initialize a Alligator Object
	 * @param name String, Name of Alligator
	 * @param weight int, Weight of Alligator
	 * @param age int, Age of Alligator
	 */
	public Alligator(String name,int weight, int age) {
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
