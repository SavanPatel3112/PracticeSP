package abc;

import java.io.Serializable;

public class partyModel implements Serializable{

	private int id;
	private String contactNumber;
	private String partyName;
	private int oaccount;
	public partyModel(int id, String contactNumber, String partyName, int oaccount) {
		super();
		this.id = id;
		this.contactNumber = contactNumber;
		this.partyName = partyName;
		this.oaccount = oaccount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public int getOaccount() {
		return oaccount;
	}
	public void setOaccount(int oaccount) {
		this.oaccount = oaccount;
	}
	public partyModel() {
		super();
		// TODO Auto-gxenerated constructor stub
	}
	public partyModel(int id, int oaccount) {
		super();
		this.id = id;
		this.oaccount = oaccount;
	}
	
	
	
	
	
	
	
	
}
