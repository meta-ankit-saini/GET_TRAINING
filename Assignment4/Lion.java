package Assignment4;

public class Lion extends Mammal{
	private final String sound = "Roar"; 
	private final String type = "Lion";
	
	/**
	 * Initialize a Lion Object
	 * @param name String, Name of Lion
	 * @param weight int, Weight of Lion
	 * @param age int, Age of Lion
	 */
	public Lion(String name,int weight, int age) {
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
