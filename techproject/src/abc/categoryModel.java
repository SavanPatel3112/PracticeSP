package abc;
import java.io.Serializable;
public class categoryModel implements Serializable{
	
	int id;
	String categoryname;
	String categorydes;
	
	public categoryModel(int id, String categoryname, String categorydes) {
		super();
		this.id = id;
		this.categoryname = categoryname;
		this.categorydes = categorydes;
	}
	
	public categoryModel(String categoryname, String categorydes) {
		super();
		this.categoryname = categoryname;
		this.categorydes = categorydes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getCategorydes() {
		return categorydes;
	}
	public void setCategorydes(String categorydes) {
		this.categorydes = categorydes;
	}
	
	
	

}
