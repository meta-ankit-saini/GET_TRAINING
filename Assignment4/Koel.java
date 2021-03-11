package Assignment4;

public class Koel extends Bird{
	private final String sound = "Koo-ooo"; 
	private final String type = "Koel";
	
	/**
	 * Initialize a Koel Object
	 * @param name String, Name of Koel
	 * @param weight int, Weight of Koel
	 * @param age int, Age of Koel
	 */
	public Koel(String name,int weight, int age) {
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
