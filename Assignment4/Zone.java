package Assignment4;

import java.util.ArrayList;

public class Zone {

	private final String typeOfAnimal;
	private final int maxCages;
	private ArrayList<Cage> cages = new ArrayList<Cage>();
	private int numberOfCage = 0;
	public final boolean hasPark;
	public final boolean hasCanteen;
	
	/**
	 * Initialize Zoo Object
	 * @param animalCategory String, Category of Animal that can be added to Zones like mammals,bird etc.
	 * @param maxCages , max number of cages supported by zone
	 * @param hasPark boolean, true if zone has a Park otherwise false
	 * @param hasCanteen boolean, true if zone has a Canteen otherwise false
	 */
	public Zone(String typeOfAnimal, int maxCages, boolean hasPark, boolean hasCanteen) {
		this.typeOfAnimal = typeOfAnimal;
		this.maxCages = maxCages;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
	}
	
	
	public int getAvailableCapacityForCages(){
		return maxCages - numberOfCage;
	}
	
	/**
	 * Method to get Available Capacity for an animal Type
	 * @param type String, type of ANimal
	 * @return , available capacity
	 */
	public int getAvailableCapcityForAnimalOfType(String type){
		int capacity = 0 ;
		for(Cage cage: this.cages){
			if(cage.getTypeOfAnimal().equals(type)){
				capacity += cage.getAvailableCapacity();
			}
		}
		return capacity;
	}
	
	/**
	 * Method to add Cage to Zone
	 * @param cage Cage, Cage Object to be added to Zone
	 * @return boolean, true if cage successfully addded
	 * @throws AssertionError if there is no capacity
	 */
	public void addCage(Cage cage) throws AssertionError{
		if(this.getAvailableCapacityForCages()==0){
			throw new AssertionError("No Space For New Cage");
		}
		else{
			this.cages.add(cage);
			this.numberOfCage ++;
		}
	}
	
	/**
	 * Method to add ANimal to a Zone
	 * @param animal Animal, animal Object to be Added
	 * @return boolean, true if Animal successfully Added
	 * @throws AssertionError, if Animal Cannot be Added 
	 */
	public boolean addAnimal(Animal animal) {
		for(Cage cage : this.cages){
			if(cage.getAvailableCapacity() > 0){
				cage.addAnimal(animal);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to remove animal from zone
	 * @param animal Animal, animal object to be removed
	 * @return boolean, if Animal is removed otherwise false
	 */
	public boolean removeAnimal(Animal animal) {
		for(Cage cage : this.cages){
			if(cage.getTypeOfAnimal().equals(animal.getType())){
				if(cage.removeAnimal(animal)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Method to get if Zone has a park
	 * @return boolean, true if has Park otherwise false
	 */
	public boolean getHasPark(){
		return this.hasPark;
	}
	
	/**
	 * Method to get if Zone has a Canteen
	 * @return boolean, true if has Canteen otherwise false
	 */
	public boolean getHasCanteen(){
		return this.hasCanteen;
	}
	
	/**
	 * Method to get Animal Category supported by Zone
	 * @return String, Category of Animal
	 */
	public String getAnimalCategory(){
		return this.typeOfAnimal;
	}
	
	/**
	 * Get List of Cages in ZOne
	 * @return ArrayList<Cage>, list of Cages
	 */
	public ArrayList<Cage> getArrayListOfCages(){
		return this.cages;
	}
}
