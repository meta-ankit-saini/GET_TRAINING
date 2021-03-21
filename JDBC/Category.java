package Assignment5_DBMS;

/**
 * class to store title and number of sub category
 * @author ankit.saini_metacube
 *
 */
public class Category {
	private final int noOfSubCategory;
	private final String title;
	
	
	public Category(String title, int noOfSubCategory) {
		this.noOfSubCategory = noOfSubCategory;
		this.title = title;
	}
	
	public int getNoOfSubCategory(){
		return noOfSubCategory;
	}
	
	public String getCategory(){
		return title;
	}
	
	public void printCategory(){
		System.out.println("category : " + title + "    No Of SubCategories : " + noOfSubCategory);
	}
}
