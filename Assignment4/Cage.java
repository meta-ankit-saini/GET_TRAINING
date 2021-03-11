package Assignment4;

import java.util.ArrayList;

public class Cage {
	private final String typeOfAnimal;
	private final int maxAnimals;
	private int numberOAnimals = 0;
	private ArrayList<Animal> animals = new ArrayList<Animal>();
	
	
	public Cage(int maxAnimals, String typeOfAnimal) {
		this.maxAnimals = maxAnimals;
		this.typeOfAnimal= typeOfAnimal;
	}
	
	
	public int getAvailableCapacity(){
		return maxAnimals - numberOAnimals;
	}
	
	/**
	 * Method to add animal to cage
	 * @param animal Animal, animal to be added
	 * @return boolean, true if successfully added otherwise false
	 * @throws AssertionError if type of Animal is not supported
	 */
	public boolean addAnimal(Animal animal){
		if(this.getAvailableCapacity() < 1 ){
			return false;
		}
		animals.add(animal);
		numberOAnimals +=1 ;
		return true;
	}
	
	/**
	 * Method to remove Animal form Cage
	 * @param animal Animal, animal to be removed
	 * @return boolean, true if successfully removed Animal otherwise false
	 */
	public boolean removeAnimal(Animal animal){
		if (animals.contains(animal)){
			animals.remove(animal);
			numberOAnimals--;
			return true;
		}
		else 
			return false;		
	}
	
	/**
	 * Method to get Type of Animal supported by Cage
	 * @return String, category of Animal
	 */
	public String getTypeOfAnimal(){
		return this.typeOfAnimal;
	}
	
	/**
	 * Method to get list Of Animals in Cage
	 * @return ArrayList<Animal>, ArrayList of Animals
	 */
	public ArrayList<Animal> getArrayListOfAnimals(){
		return this.animals;
	}
}
