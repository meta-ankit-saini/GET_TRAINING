package Assignment5_DBMS;

/**
 * class to store product id and imagePath
 * @author ankit.saini_metacube
 *
 */
public class Image {
	private final int productId;
	private final String imagePath;
	
	
	public Image( int productId, String imagePath) {
		this.productId = productId;
		this.imagePath = imagePath;
	}
	
	public int getProductID(){
		return productId;
	}
	
	public String getImagePath(){
		return imagePath;
	}
}
