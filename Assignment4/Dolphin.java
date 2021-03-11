package Assignment4;

public class Dolphin extends Fish{
	private final String sound = "clicks"; 
	private final String type = "Dolphin";
	
	/**
	 * Initialize a Dolphin Object
	 * @param name String, Name of Dolphin
	 * @param weight int, Weight of Dolphin
	 * @param age int, Age of Dolphin
	 */
	public Dolphin(String name,int weight, int age) {
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
