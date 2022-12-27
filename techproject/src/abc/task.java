package abc;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class task {

	int a;
	
	public void start(HashMap<Integer,categoryModel> cmap,HashMap<Integer, productModel> pmap,HashMap<Integer,partyModel> partyMap,HashMap<Integer,purchaseorderModel> purchaseMap
			,HashMap<Integer,salespurchaseModel> sales_purchasemap) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Category\n2.Product\n3.Purchase\n4.Sales\n5.Account\n6.Exit");
		System.out.println("Select option");
		a = sc.nextInt();	
		//System.out.println(a);
		
		switch(a) {
		
		case 1:
			Category category = new Category();
			category.m1(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
			start(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);

			break;
		
		case 2:
			Product product = new Product();
			product.m2(cmap, pmap);
			start(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
			break;
			
		
		case 3:
			Purchase purchase  = new Purchase();
			purchase.m3(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
			start(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
			break;
		
		case 4:
			Sales sales = new Sales();
			sales.m4(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
			start(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
			break;
		
		case 5:
			Account account = new Account();
			account.acc(purchaseMap,sales_purchasemap);
			break;
			
		case 6:
			System.exit(0);
			break;
			
		
		default:
			break;
		
		}
		
		
	}
}
