package Assignment4;

public class Goldfish extends Fish{
	private final String sound = "hums"; 
	private final String type = "Goldfish";
	
	/**
	 * Initialize a Goldfish Object
	 * @param name String, Name of Goldfish
	 * @param weight int, Weight of Goldfish
	 * @param age int, Age of Goldfish
	 */
	public Goldfish(String name,int weight, int age) {
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
