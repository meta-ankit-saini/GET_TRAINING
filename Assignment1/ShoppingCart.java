package Assignment1_SCFO;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * this class is the main block of the system has the implementation for adding/removing items and printing the content/bill of cart 
 * @author ankit.saini_metacube
 *
 */

public class ShoppingCart {
	private Map<Integer , UnitItem> shoppingCart = new LinkedHashMap<>();
	
	
	/**
	 * this function is used to add unitItem in the Shopping cart
	 * @param unitItem
	 */
	public void addItem(UnitItem unitItem){
		if(shoppingCart.containsKey(unitItem.getItemId())){
			UnitItem unitItemInCart = shoppingCart.get(unitItem.getItemId());
			unitItemInCart.addQuantity(unitItem.getQuantity());
		}
		else{
			this.shoppingCart.put(unitItem.getItemId() , unitItem);
		}
		
	}
	
	/**
	 * 
	 * @return Total No of items in ShoppingCart
	 */
	public int totalItem(){
		int totalItems = 0;
		for(UnitItem unitItem : shoppingCart.values()){
			totalItems += unitItem.getQuantity();
		}
		return totalItems;
	}
	
	
	/**
	 * this function is used to remove unitItems from ShoppingCart 
	 * @param unitItemToRemove
	 */
	public void remove(UnitItem unitItemToRemove){
		boolean deleteUnitItem = false;
		for (UnitItem unitItem : shoppingCart.values()){
			if(Objects.equals(unitItem.getItemId(), unitItemToRemove.getItemId())){
				if(unitItemToRemove.getQuantity() == unitItem.getQuantity()){
					deleteUnitItem = true;
				}
				else{
					unitItem.subtractQuantity(unitItemToRemove.getQuantity());
				}
			}
		}
		if (deleteUnitItem){
			this.shoppingCart.remove(unitItemToRemove.getItemId());
		}
	}
	
	/**
	 * this function is used to print content of shoppingCart
	 */
	public void shoppingCartContent(){
		int serialNumber = 1;
		System.out.println("-----------------------------------------------");
		System.out.printf("%10s %16s %10s","S. No", "Item", "Quantity");
		System.out.println();
		System.out.println("-----------------------------------------------");
		for(UnitItem unitItem : shoppingCart.values()){
			System.out.printf("%10d %16s %10d",serialNumber , unitItem.getName() , unitItem.getQuantity());
			System.out.println();
			serialNumber += 1;
		}
		System.out.println("-----------------------------------------------");
	
	}
	
	/**
	 * this function generates the Bill of ShoppingCart Items 
	 */
	public void shoppingCartBill(){
		int serialNumber = 1;
		Double totalPrice = 0.0,currentItemPrice = 0.0 ;
		System.out.println("-------------------------------------------------------");
		System.out.printf("%10s %16s %10s %10s","S. No", "Item", "Quantity" , "Price");
		System.out.println();
		System.out.println("-------------------------------------------------------");
		for(UnitItem unitItem : shoppingCart.values()){
			currentItemPrice = unitItem.totalPrice();
			System.out.printf("%10d %16s %10d %10f",serialNumber , unitItem.getName() , unitItem.getQuantity(), currentItemPrice);
			System.out.println();
			serialNumber += 1;
			totalPrice += currentItemPrice;
		}
		System.out.println("-------------------------------------------------------");
		
		System.out.printf("%10s %16s %10s %10f","Total" , " " , " ", totalPrice);
		System.out.println();
		
		System.out.println("-------------------------------------------------------");
	}

}
