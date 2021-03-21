package Assignment5_DBMS;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws SQLException{
		String host = "jdbc:mysql://localhost:3306/", dbName = "storefront", userId = "root", password = "Harry@p0tter123";
		JDBC_Connection jdbc = new JDBC_Connection(host, dbName, userId, password);
		jdbc.connect();
		
		ArrayList<Order> orders = jdbc.selectShippedOrderByShopperId(2);
		for (Order order : orders){
			order.PrintOrder();
		}
		
		Image[] images = {
			new Image(12, "image12_1"),	
			new Image(12, "image12_2"),
			new Image(12, "image12_3"),
			new Image(12, "image12_4"),
			new Image(12, "image12_5"),
		};
		jdbc.addImages(images);
		
		System.out.println( "deleted product no : " + jdbc.deleteProductNotOrderedInLastOneYear());
		
		ArrayList<Category> categories = jdbc.getCategoryWithNoOfSubCategory();
		for(Category category : categories){
			category.printCategory();
		}
		
		jdbc.close();
	}
}
