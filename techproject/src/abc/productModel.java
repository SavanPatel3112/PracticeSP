package abc;

import java.io.Serializable;

public class productModel implements Serializable {
	
	int id;
	String pname;
	String pdes;
	public categoryModel categoryModel;
	int p_purchaseprice;
	int p_salesprice;
	String p_stock;
	String p_status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdes() {
		return pdes;
	}
	public void setPdes(String pdes) {
		this.pdes = pdes;
	}
	public int getP_purchaseprice() {
		return p_purchaseprice;
	}
	public void setP_purchaseprice(int p_purchaseprice) {
		this.p_purchaseprice = p_purchaseprice;
	}
	public int getP_salesprice() {
		return p_salesprice;
	}
	public void setP_salesprice(int p_salesprice) {
		this.p_salesprice = p_salesprice;
	}
	public String getP_stock() {
		return p_stock;
	}
	public void setP_stock(String p_stock) {
		this.p_stock = p_stock;
	}
	
	public String getP_status() {
		return p_status;
	}
	public void setP_status(String p_status) {
		this.p_status = p_status;
	}

	public productModel(int id, String pname, String pdes) {
		super();
		this.id = id;
		this.pname = pname;
		this.pdes = pdes;
	}
	public productModel(int id, String pname, String pdes, int p_purchaseprice, int p_salesprice, String p_stock,
			String p_status) {
		super();
		this.id = id;
		//this.categoryModel = categoryModel;
		this.pname = pname;
		this.pdes = pdes;
		this.p_purchaseprice = p_purchaseprice;
		this.p_salesprice = p_salesprice;
		this.p_stock = p_stock;
		this.p_status = p_status;
	}
	public categoryModel getCategoryModel() {
		return categoryModel;
	}
	public void setCategoryModel(categoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}
	
	

}
