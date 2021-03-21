package Assignment5_DBMS;

import java.sql.Date;

/**
 * class to store the  orderId, orderdate, totalPrice
 * @author ankit.saini_metacube
 *
 */
public class Order {
	private final int orderId;
	private final Date orderdate;
	private final Double totalPrice;
	
	
	public Order(int orderId, Date orderdate, Double totalPrice) {
		this.orderId = orderId;
		this.orderdate = orderdate;
		this.totalPrice = totalPrice;
	}

	
	
	public int getOrderId() {
		return orderId;
	}
	
	public Double getTotalPrice() {
		return totalPrice;
	}
	
	public Date getOrderdate() {
		return orderdate;
	}
	
	public void PrintOrder(){
		System.out.println("ID : " + orderId + "   Date : " + orderdate + "  totalPrice : " + totalPrice);
	}
}
