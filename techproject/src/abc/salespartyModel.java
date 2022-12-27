package abc;

import java.io.Serializable;

public class salespartyModel implements Serializable{

	
	int id;
	private String contactNumber;
	private String partyName;
	private int oaccount;
	public salespartyModel(int id, String contactNumber, String partyName, int oaccount) {
		super();
		this.id = id;
		this.contactNumber = contactNumber;
		this.partyName = partyName;
		this.oaccount = oaccount;
	}
	public salespartyModel() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
	
	
}
