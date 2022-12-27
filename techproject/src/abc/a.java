package abc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a {

	public static void main(String args[]) {
		
		task t = new task();
		
		HashMap<Integer,categoryModel> cmap = new HashMap<Integer,categoryModel>();
		HashMap<Integer,productModel> pmap = new HashMap<Integer,productModel>();
		HashMap<Integer,partyModel> partyMap = new HashMap<Integer,partyModel>();
		HashMap<Integer,purchaseorderModel> purchaseMap = new HashMap<Integer,purchaseorderModel>();
		HashMap<Integer,salespurchaseModel> sales_purchasemap = new HashMap<Integer,salespurchaseModel>();
		t.start(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
		}
}
