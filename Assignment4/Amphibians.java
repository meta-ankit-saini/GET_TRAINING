package Assignment4;

public abstract class Amphibians extends Animal{
	private final String animalCatrgory = "Amphibians";
	private final boolean canFly = false;

	/**
	 * Initialize Amphibians
	 * @param name String, name of Amphibians
	 * @param weight int, Weight of Amphibians
	 * @param age int, Age of Amphibians
	 */
	public Amphibians(String name,int weight, int age) {
		super(name,weight,age);
	}
	
	@Override
	public String getCategory(){
		return this.animalCatrgory;
	}
	
	@Override
	public boolean canFly(){
		return this.canFly;
	}
}
