package abc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Account {
	Scanner sc = new Scanner(System.in);
	int p;
	
	public void acc(HashMap<Integer,purchaseorderModel> purchaseMap
			,HashMap<Integer,salespurchaseModel> sales_purchasemap) {
		
		System.out.println("1.purchase\n2.sales_purchase");
		System.out.println("Enter Choice:");
		p=sc.nextInt();
	
		switch(p) {
		
			case 1:
				view(purchaseMap);
				
				break;
			case 2:
				view1(sales_purchasemap);
				
				break;
		
		
		}
		
	}

	private void view1(HashMap<Integer, salespurchaseModel> sales_purchasemap) {
		for(Map.Entry<Integer, salespurchaseModel> obj2:sales_purchasemap.entrySet()) {
		System.out.println("ID:"+obj2.getKey()+" "+"orderID"+obj2.getValue().getOrder_no()+" "+"quantity:"+obj2.getValue().getQuantity());
		}
	
	}

	private void view(HashMap<Integer, purchaseorderModel> purchaseMap) {

		for(Map.Entry<Integer, purchaseorderModel> obj2: purchaseMap.entrySet()) {
			System.out.println("ID:"+obj2.getKey()+" "+"orderID"+obj2.getValue().getOrder_no()+" "+"quantity:"+obj2.getValue().getQuantity());
			}
		
	}
	
	

	
	
	
	
}
