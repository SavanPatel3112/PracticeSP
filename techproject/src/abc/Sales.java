package abc;

import java.util.HashMap;
import java.util.Scanner;

public class Sales {

	Scanner sc = new Scanner(System.in);
	public void m4(HashMap<Integer,categoryModel> cmap,HashMap<Integer,productModel> pmap,
			HashMap<Integer,partyModel> partyMap,HashMap<Integer,purchaseorderModel> purchaseMap,HashMap<Integer,salespurchaseModel> sales_purchasemap) {
		
		
		
		System.out.println("1.Party\n2.PurchaseOrder_Sales\n3.Exit");
		System.out.println("Enter the option");
		int p = sc.nextInt();
		switch(p) {
			case 1:
				Party party= new Party();
				party.m4(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
				break;
			case 2:
				Purchaseorder_sales porder_sales = new Purchaseorder_sales();
				porder_sales.m7(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
				break;
		
			case 3:
				new task().start(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
				break;
				
			default:
				break;
				
		}
		
	}
}
