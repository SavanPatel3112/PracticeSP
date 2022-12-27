package abc;

import java.io.Serializable;
import java.sql.Date;

public class purchaseorderModel implements Serializable{
	
	
	private int id;
	private int order_no;
	private Date order_date;
	private int quantity;
	private int price;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public purchaseorderModel(int id, int order_no, int quantity, int price) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.quantity = quantity;
		this.price = price;
	}
	public purchaseorderModel(int id, int order_no, Date date) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.order_date = date;
	}
	public int getId() {
		return id;
	}
	public purchaseorderModel(int quantity) {
		super();
		this.quantity = quantity;
	}
	public purchaseorderModel(int id, int order_no, int quantity) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public purchaseorderModel(int id, int order_no, Date order_date, int quantity) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.order_date = order_date;
		this.quantity = quantity;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrder_no() {
		return order_no;
	}
	public purchaseorderModel(int id, int order_no) {
		super();
		this.id = id;
		this.order_no = order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public purchaseorderModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
