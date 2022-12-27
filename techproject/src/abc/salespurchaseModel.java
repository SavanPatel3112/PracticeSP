package abc;

import java.io.Serializable;
import java.sql.Date;

public class salespurchaseModel implements Serializable {

	private int id;
	private int order_no;
	private Date order_date;
	private int quantity;
	private int price;
	public salespurchaseModel(int id, int order_no, Date order_date, int quantity, int price) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.order_date = order_date;
		this.quantity = quantity;
		this.price = price;
	}
	public salespurchaseModel(int id, int order_no, int quantity, int price) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.quantity = quantity;
		this.price = price;
	}
	public salespurchaseModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrder_no() {
		return order_no;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
