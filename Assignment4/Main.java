package Assignment4;

import static org.junit.Assert.assertEquals;

public class Main {
	public static void main(String[] args) {
		ZooManagementSystem zooManagementSystem = new ZooManagementSystem(5);
		
		Animal animal1 = new Lion("L1", 45, 3);
		Animal animal2 = new Peacock("P1", 22, 3);
		Animal animal3 = new Crocodile("C1", 23, 1);
		Animal animal4 = new Lion("L2", 45, 3);
		Animal animal5 = new Peacock("P2", 22, 3);
		Animal animal6 = new Crocodile("C2", 23, 1);
		Animal animal7 = new Lion("L3", 45, 3);
		Animal animal8 = new Lion("L4", 45, 3);
		Animal animal9 = new Lion("L5", 45, 3);
		Animal animal10 = new Lion("L6", 45, 3);
		Animal animal11 = new Lion("L7", 45, 3);
		Animal animal12 = new Lion("L8", 45, 3);
		
		System.out.println("Before Adding Animals : ");
		zooManagementSystem.printZooInfo();
		
		System.out.println();
		System.out.println();
		
		zooManagementSystem.addAnimal(animal1);
		zooManagementSystem.addAnimal(animal2);
		zooManagementSystem.addAnimal(animal3);
		zooManagementSystem.addAnimal(animal4);
		zooManagementSystem.addAnimal(animal5);
		zooManagementSystem.addAnimal(animal6);
		zooManagementSystem.addAnimal(animal7);
		zooManagementSystem.addAnimal(animal8);
		zooManagementSystem.addAnimal(animal9);
		zooManagementSystem.addAnimal(animal10);
		zooManagementSystem.addAnimal(animal11);
		zooManagementSystem.addAnimal(animal12);
		
		System.out.println("After Adding Animals : ");
		zooManagementSystem.printZooInfo();
		
		System.out.println();
		System.out.println();
		
		zooManagementSystem.removeAnimal(animal1);
		zooManagementSystem.removeAnimal(animal2);
		zooManagementSystem.removeAnimal(animal3);
		
		System.out.println("After Removing Animals : ");
		zooManagementSystem.printZooInfo();
		
		
	}
}
