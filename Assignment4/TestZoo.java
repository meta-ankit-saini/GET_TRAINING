package Assignment4;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestZoo {

	/**
	 * Method For testing addZone method of ZooManagementSystem Class
	 */
	@Test
	public void addZoneTest() {
        ZooManagementSystem zooManagementSystem = new ZooManagementSystem(2);
		Zone zone1 = new Zone("Bird",2,false,false);
		assertEquals(true, zooManagementSystem.addZone(zone1));
	}
	
	/**
	 * Method For testing Exception in addZone method of ZooManagementSystem Class
	 */
	@Test(expected = AssertionError.class)
	public void addZoneExceptionTest(){
		ZooManagementSystem zooManagementSystem = new ZooManagementSystem(1);
		Zone zone1 = new Zone("Bird",1,false,false);
		Zone zone2 = new Zone("Bird",2,false,false);
		zooManagementSystem.addZone(zone1);
		zooManagementSystem.addZone(zone2);
	}
	
	/**
	 * Method For testing getAvailableZoneCapacity method of ZooManagementSystem Class
	 */
	@Test
	public void getAvailableZoneCapacityTest(){
		ZooManagementSystem zooManagementSystem = new ZooManagementSystem(5);
		Zone zone1 = new Zone("Bird",2,false,false);
		zooManagementSystem.addZone(zone1);
		
		assertEquals(4,zooManagementSystem.getAvailableZoneCapacity());
	}
	
	/**
	 * Method For testing addAnimal method of ZooManagementSystem Class
	 */
	@Test
	public void addAnimalTest() {
		
		ZooManagementSystem zooManagementSystem = new ZooManagementSystem(2);
		
		Animal animal1 = new Lion("L1", 45, 3);
		Animal animal2 = new Peacock("P1", 22, 3);

		
		assertEquals(true,zooManagementSystem.addAnimal(animal1));
		assertEquals(true,zooManagementSystem.addAnimal(animal2));
	}
	
	/**
	 * Method For testing Exception in addAnimal method of ZooManagementSystem Class
	 */
	@Test(expected = AssertionError.class)
	public void addAnimalExceptionTest() {
		
		ZooManagementSystem zooManagementSystem = new ZooManagementSystem(1);
		
		Animal animal1 = new Lion("L1", 45, 3);
		Animal animal2 = new Peacock("P1", 22, 3);
		
		zooManagementSystem.addAnimal(animal1);
		zooManagementSystem.addAnimal(animal2);
	}
	
	/**
	 * Method For testing removeAnimal method of ZooManagementSystem Class
	 */
	@Test
	public void removeAnimalTest() {
		
		ZooManagementSystem zooManagementSystem = new ZooManagementSystem(2);
		
		Animal animal1 = new Lion("L1", 45, 3);
		Animal animal2 = new Peacock("P1", 22, 3);
		
		assertEquals(true,zooManagementSystem.addAnimal(animal2));
		assertEquals(true,zooManagementSystem.addAnimal(animal1));
		
		assertEquals(true,zooManagementSystem.removeAnimal(animal1));
	}
	
}
