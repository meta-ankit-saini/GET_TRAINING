package Assignment5_DBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBC_Connection {
	private Connection connection;
	private String host, dbName, mysqlURL, userId, password;

	public JDBC_Connection(String host, String dbName, String userId, String password) {
		this.host = host;
		this.dbName = dbName;
		this.mysqlURL = host + dbName;
		this.userId = userId;
		this.password = password;
	}
	
	public void connect(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException cnfe) {
			System.out.println("Error loading driver: " + cnfe);
		}
		try {
			connection = DriverManager.getConnection(mysqlURL, userId,password);
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void close(){
		try {
			connection.close();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Given the id of a user, fetch all orders(Id, Order Date, Order Total) 
	 * of that user which are in shipped state. Orders should 
	 * be sorted by order date column in chronological order.
	 * @param shopperId
	 * @throws SQLException 
	 * @return -> ArrayList of Order
	 */
	public ArrayList<Order> selectShippedOrderByShopperId(int shopperId) throws SQLException{
		ArrayList<Order> orders = new ArrayList<Order>(); 
		try {
			String query = "SELECT ordertable.orderid , ordertable.orderdate  , "
					+ "ordertable.quantity * producttable.price  "
					+ "FROM ordertable "
					+ "INNER JOIN producttable "
					+ "ON ordertable.productid = producttable.productid "
					+ "WHERE ordertable.shopperid = " + shopperId
					+ " AND ordertable.shipped IS true " 
					+ "ORDER BY orderdate DESC;";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
			orders.add(new Order(rs.getInt(1) , rs.getDate(2) , rs.getDouble(3)));  
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return orders;
	}
	
	/**
	 * Insert images of a product using batch insert technique.
	 * @param images
	 */
	public void addImages(Image[] images){
		try {
			Statement statement = connection.createStatement();
			for(Image image : images){
				String query = "INSERT INTO imagetable(title , productid) "
						+ "VALUES( " + image.getImagePath()
						+ " , " + image.getProductID()
						+ ")";
				statement.addBatch(query);
			}	
			System.out.println("SuccessFully Added");
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Delete all those products which were not ordered by any Shopper in last 1 year. 
	 * @return -> Return the number of products deleted.
	 */
	public int deleteProductNotOrderedInLastOneYear(){
		int noOfProductDeleted = 0;
		try {
			Statement statement = connection.createStatement();
			
			//setting safe update 0;
			String query = "SET SQL_SAFE_UPDATES = 0;";
			statement.execute(query);
			
			//deleting references from subcategorytable
			query = "DELETE FROM subcategorytable "
					+ "WHERE subcategorytable.productid NOT IN "
					+ "( SELECT DISTINCT ordertable.productid FROM ordertable "
					+ "WHERE ordertable.orderdate >= ( DATE_SUB( CURDATE(), INTERVAL 1 YEAR) ));";
			statement.execute(query);
			
			//deleting references from imagetable
			query = "DELETE FROM imagetable "
					+ "WHERE imagetable.productid NOT IN "
					+ "( SELECT DISTINCT ordertable.productid FROM ordertable "
					+ "WHERE ordertable.orderdate >= ( DATE_SUB( CURDATE(), INTERVAL 1 YEAR) ));";
			statement.execute(query);
			
			//deleting references from stocktable
			query = "DELETE FROM stocktable "
					+ "WHERE stocktable.productid NOT IN "
					+ "( SELECT DISTINCT ordertable.productid FROM ordertable "
					+ "WHERE ordertable.orderdate >= ( DATE_SUB( CURDATE(), INTERVAL 1 YEAR) ));";
			
			statement.execute(query);
			
			query = "DELETE FROM producttable "
					+ "WHERE producttable.productid NOT IN "
					+ "( SELECT DISTINCT ordertable.productid FROM ordertable "
					+ "WHERE ordertable.orderdate >= ( DATE_SUB( CURDATE(), INTERVAL 1 YEAR) ));";
			noOfProductDeleted = statement.executeUpdate(query);
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return noOfProductDeleted;
	}
	
	/**
	 * Select and display the category title of all top parent categories sorted 
	 * alphabetically and the count of their child categories.
	 * @return -> ArrayList of Category
	 */
	public ArrayList<Category> getCategoryWithNoOfSubCategory(){
		ArrayList<Category> categories = new ArrayList<Category>();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT categorytable.title , COUNT(categorytable.title) "
					+ "FROM categorytable INNER JOIN subcategorytable "
					+ "ON categorytable.categoryid = subcategorytable.categoryid "
					+ "GROUP BY categorytable.title "
					+ "Order BY categorytable.title; ";
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
			categories.add(new Category(rs.getString(1) , rs.getInt(2)));  
			}
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return categories;
	}
}
