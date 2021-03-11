package Assignment4;

public abstract class Reptiles extends Animal{
	private final String animalCatrgory = "Reptiles";
	private final boolean canFly = false;

	/**
	 * Initialize Reptiles
	 * @param name String, name of Reptiles
	 * @param weight int, Weight of Reptiles
	 * @param age int, Age of Reptiles
	 */
	public Reptiles(String name,int weight, int age) {
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
