package Assignment1_SCFO;

import java.util.Scanner;

public class Main {
	
	public static void addItemInInventory(Inventory inventory){
		Scanner scan = new Scanner(System.in); 
		int noOfItem;
		System.out.println("Enter number of Items to Store in inventory: ");
	    noOfItem = scan.nextInt();
	    
	    Integer id;
		String name;
		Double price;
		
		for (int i = 1 ; i <= noOfItem ; i++ ){
			System.out.println("Enter ID (Integer) : ");
			id = scan.nextInt();
			System.out.println("Enter Name : ");
			name = scan.next();
			System.out.println("Enter Price : ");
			price = scan.nextDouble();
			inventory.add(new Item(id,name,price));
		}
		UnitItem.setInventory(inventory);
	}
	
	public static  void addItemInShoppingCart( ShoppingCart cart ) {
		Scanner scan = new Scanner(System.in); 
		int noOfItem ,id , quantity;
		
		System.out.println("Enter number of Items to add in ShoppinCart : ");
	    noOfItem = scan.nextInt();
	    
	    
		
		for (int i = 1 ; i <= noOfItem ; i++ ){
			System.out.println("Enter ID (Integer) : ");
			id = scan.nextInt();
			System.out.println("Enter quantity : ");
			quantity = scan.nextInt();
			cart.addItem(new UnitItem(id,quantity));
		}
		
	}
	
	public static  void removeItemFromShoppingCart( ShoppingCart cart ){
		Scanner scan = new Scanner(System.in); 
		int noOfItem ,id , quantity;
		System.out.println("Enter number of Items to remove from ShoppinCart : ");
	    noOfItem = scan.nextInt();
	    
		for (int i = 1 ; i <= noOfItem ; i++ ){
			System.out.println("Enter ID (Integer) : ");
			id = scan.nextInt();
			System.out.println("Enter quantity : ");
			quantity = scan.nextInt();
			cart.remove(new UnitItem(id,quantity));
		}
		
	}
	
		
    public static void main(String args[]){
	    
    	Scanner scan = new Scanner(System.in); 
		Inventory inventory = new Inventory();
		ShoppingCart cart = new ShoppingCart();			
		int choice = 0 ;
		
		while (choice != 7){
			System.out.println("Enter 1 for adding item in inventory" );
			System.out.println("Enter 2 for adding item in ShoppingCart" );
			System.out.println("Enter 3 for removing item from ShoppingCart" );
			System.out.println("Enter 4 for printing total no of items in ShoppingCart" );
			System.out.println("Enter 5 for printing ShoppingCart content" );
			System.out.println("Enter 6 for printing ShoopingCart bill" );
			System.out.println("Enter 7 for closing the application" );
			System.out.println("Enter choice");
			choice = scan.nextInt();
			
			 switch (choice) { 
		        case 1: 
		        	addItemInInventory(inventory);
		        	break;
		        case 2: 
		        	addItemInShoppingCart(cart); 
		            break; 
		        case 3: 
		        	removeItemFromShoppingCart(cart); 
		            break; 
		        case 4: 
		        	System.out.println("Total item in ShoppingCart : " + cart.totalItem());; 
		            break; 
		        case 5: 
		        	cart.shoppingCartContent();; 
		            break; 
		        case 6: 
		        	cart.shoppingCartBill();; 
		            break;
		        case 7:
		        	break;
		        default: 
		        	System.out.println(choice +" is invalid choice");  
		        }        
			}
		System.out.println("App closed.");
		}
}
