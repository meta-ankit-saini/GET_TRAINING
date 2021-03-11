package Assignment4;

public class Tiger extends Mammal {
	private final String sound = "Growl"; 
	private final String type = "Tiger";
	
	/**
	 * Initialize a Tiger Object
	 * @param name String, Name of Tiger
	 * @param weight , Weight of Tiger
	 * @param age , Age of Tiger
	 */
	public Tiger(String name,int weight, int age) {
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
