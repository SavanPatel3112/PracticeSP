package abc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Purchase {
	Scanner sc = new Scanner(System.in);
	public void m3(HashMap<Integer,categoryModel> cmap,HashMap<Integer,productModel> pmap,HashMap<Integer,partyModel> partyMap,
			HashMap<Integer,purchaseorderModel> purchaseMap,
			HashMap<Integer,salespurchaseModel> sales_purchasemap) {
		System.out.println("1.Party\n2.PurchaseOrder\n3.Exit");
		System.out.println("Enter the option");
		int p = sc.nextInt();
		switch(p) {
			case 1:
				Party party = new Party();
				party.m4(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
				break;
			case 2:
				Purchaseorder porder = new Purchaseorder();
				porder.m5(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
				break;
		
			case 3:
				new task().start(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
				break;
				
				
			default:
				break;
				
		}
		
		
	}

}
