package Assignment4;

import java.util.ArrayList;

public class ZooManagementSystem {
	private ArrayList<Zone> zones = new ArrayList<Zone>(); 
	private final int maxZones;
	private int numberOfZone = 0;
	private int default_cage_capacity = 5 ;
	private int default_zone_capacity = 5;
	private boolean hasParkDefault = false;
	private boolean hasCanteenDefault = false;
	
	/**
	 * Initialize ZooMAnagemetSystem Object
	 * @param maxZoneLimit int, maximum number of Zones can be added to Zoo
	 */
	public ZooManagementSystem(int maxZones) {
		this.maxZones = maxZones;
	}
	
	/**
	 * Get Available Capacity for Zones
	 * @return  available capacity
	 */
	public int getAvailableZoneCapacity(){
		return this.maxZones - this.numberOfZone;
	}
	
	
	/**
	 * Method to add ZOne to zoo
	 * @param zone Zone, zone object to be added
	 * @return boolean, true if successfully added zone 
	 * @throws AssertionError if no more zones can be added
	 */
	public boolean addZone(Zone zone) throws AssertionError{
		if( this.getAvailableZoneCapacity() < 1  ){
			throw new AssertionError("No more Zones can be Added");
		}
		zones.add(zone);
		this.numberOfZone += 1;
		return true;
	}
	
	
	
	/**
	 * Method to add Animal to Zoo
	 * @param animal Animal, animal object to be added
	 * @return boolean, true in case of successfully Added
	 * @throws AssertionError if Animal cannot be added to Zoo
	 */
	public boolean addAnimal (Animal animal) throws AssertionError{
		
		boolean isAnimalAdded = false;
		
		for(Zone zone: this.zones){
			if(zone.getAnimalCategory().equals(animal.getCategory())){
				if(zone.getAvailableCapcityForAnimalOfType(animal.getType()) > 0){
					isAnimalAdded = zone.addAnimal(animal);
					break;
				}
				else if(zone.getAvailableCapacityForCages() > 0){
					Cage newCage = new Cage(this.default_cage_capacity, animal.getType());
					zone.addCage(newCage);
					isAnimalAdded = newCage.addAnimal(animal);
					break;
				}
			}
		}
		if(!isAnimalAdded && this.getAvailableZoneCapacity() > 0){
			Zone newZone = new Zone(animal.getCategory(),this.default_zone_capacity ,this.hasParkDefault, this.hasCanteenDefault);
			this.addZone(newZone);
			Cage newCage = new Cage(this.default_cage_capacity, animal.getType());
			newZone.addCage(newCage);
			isAnimalAdded = newCage.addAnimal(animal);
			
		}
		else if(!isAnimalAdded){
			throw new AssertionError("No more Animal Can be Added");
		}
		
		return isAnimalAdded;
	}
	
	/**
	 * Method to remove animal from Zoo
	 * @param animal Animal, animal object to be removed
	 * @return boolean, if Animal is removed otherwise false
	 */
	public boolean removeAnimal(Animal animal) throws AssertionError{
		for(Zone zone : this.zones){
			if(zone.getAnimalCategory().equals(animal.getCategory()))
				if(zone.removeAnimal(animal))
					return true;
		}
		return false;
	}
	
	/**
	 * Method for printing Zoo Info 
	 */
	public void printZooInfo(){
		int zoneNumber = 1;
		for(Zone zone: this.zones){
			System.out.println("Zone Number : " + zoneNumber + "   Type : " + zone.getAnimalCategory());
			int cageNumber = 1;
			for(Cage cage : zone.getArrayListOfCages()){
				System.out.println("         Cage Number" + cageNumber + "Type : " + cage.getTypeOfAnimal());
				for(Animal animal : cage.getArrayListOfAnimals() ){
					System.out.println("                  Animal  : " + animal.getName());
				}
				cageNumber += 1;
			}
			zoneNumber += 1;
		}
	}
}
