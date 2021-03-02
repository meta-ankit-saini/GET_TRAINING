package Assignment1_SCFO;


/**
 * this class keeps record of all the items stored in the store.
 */
import java.util.Map;
import java.util.HashMap;

public class Inventory {
	private Map<Integer, Item> items = new HashMap<>();
	
	/**
	 * this function is used to add new Item in the store.
	 * @param item
	 */
	public void add(Item item){
		this.items.put(item.getId(), item);
	}
	
	/**
	 * this function is used to fetch item details with specific ID
	 * @param id
	 * @return Item with given Id
	 */
	public Item get(Integer id){
		return items.get(id);
	}

}
