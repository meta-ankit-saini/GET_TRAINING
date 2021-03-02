package Assignment1_SCFO;

/**
 * this class extend the Item class and keeps track of number of Item required and also implements abstraction.
 * @author ankit.saini_metacube
 *
 */

public class UnitItem {
	private Integer itemId;
	private Integer quantity;
	private static Inventory inventory;
	
	public UnitItem(Integer itemId,int quantity){
		this.itemId = itemId;
		this.quantity = quantity;
	}
	
	public UnitItem(Integer itemId){
		this.itemId = itemId;
		this.quantity = 1;
	}
	
	/**
	 * this function sets inventory for use 
	 * @param inventory
	 */
	public static void setInventory(Inventory inventory){
		UnitItem.inventory = inventory;
	}
	
	public Integer getQuantity(){
		return quantity;
	}
	
	public Integer getItemId(){
		return itemId;
	}
		
	public String getName(){
		return inventory.get(itemId).getName();
	}
	
	
	public Double getPrice(){
		return inventory.get(itemId).getPrice();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnitItem other = (UnitItem) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
	
	/**
	 * this function is used to remove quantity of specific Item. 
	 * @param quantityToSubtract
	 */
	public void subtractQuantity(Integer quantityToSubtract){
		this.quantity -= quantityToSubtract;
	}
	
	/**
	 * this function is used to increase the quantity of a specific Item
	 * @param quantityToAdd
	 */
	public void addQuantity(Integer quantityToAdd){
		this.quantity += quantityToAdd;
	}
	
	/**
	 * this function is used to calculate the cost of UnitItem
	 * @return A double which represents the cost of UnitItem
	 */
	public Double totalPrice(){
		return getPrice() * Double.valueOf(quantity);
	}
	
	
}
