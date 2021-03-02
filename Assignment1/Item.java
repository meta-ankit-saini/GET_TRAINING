package Assignment1_SCFO;

/**
 * this class represents the architecture of item(id,name,price) stored in store or used by inventory.
 * @author ankit.saini_metacube
 *
 */
public class Item {
	private Integer id;
	private String name;
	private Double price;
	
	/**
	 * Constructor for creating Item instance
	 * @param id
	 * @param name
	 * @param price
	 */
	public Item(Integer id , String name , Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
		
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setPrice(Double price){
		this.price = price;
	}
	
	public Double getPrice(){
		return price;
	}

}
