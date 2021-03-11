package Assignment4;

public abstract class Fish extends Animal{
	private final String animalCatrgory = "Fish";
	private final boolean canFly = false;

	/**
	 * Initialize Mammal
	 * @param name String, name of Fish
	 * @param weight int, Weight of Fish
	 * @param age int, Age of Fish
	 */
	public Fish(String name,int weight, int age) {
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
