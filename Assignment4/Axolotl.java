package Assignment4;

public class Axolotl extends Amphibians{
	private final String sound = "croak"; 
	private final String type = "Axolotl";
	
	/**
	 * Initialize a Axolotl Object
	 * @param name String, Name of Axolotl
	 * @param weight int, Weight of Axolotl
	 * @param age int, Age of Axolotl
	 */
	public Axolotl(String name,int weight, int age) {
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
