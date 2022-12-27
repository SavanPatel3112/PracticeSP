package abc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Purchaseorder {
	int k=0,m=0,quantity,quantity1,p_id,p_purchaseprice,balance,price1,p,price;
	String date,check2,name;
	int oaccount;
	Scanner sc = new Scanner(System.in);
	Purchaseorder porder;
	public void m5(HashMap<Integer,categoryModel> cmap,HashMap<Integer,productModel> pmap,HashMap<Integer,partyModel> partyMap,
			HashMap<Integer,purchaseorderModel> purchaseMap,HashMap<Integer, salespurchaseModel> sales_purchasemap) {
		
			System.out.println("1.Insert\n2.Search\n3.Update\n4.View\n5.Delete\n6.Exit");
			System.out.println("Enter Option:");
			int p = sc.nextInt();
			switch(p) {
				case 1:
					purchaseMap = insert(cmap,pmap,partyMap,purchaseMap);
					break;
				
					
				case 2:
					purchaseMap = search(cmap,pmap,partyMap,purchaseMap);
					break;
				
				case 3:
					purchaseMap = update(cmap,pmap,partyMap,purchaseMap);
					break;
				
				case 4:
					purchaseMap = view(cmap,pmap,partyMap,purchaseMap);
					break;
					
				case 5:
					purchaseMap = delete(cmap,pmap,partyMap,purchaseMap);
					break;
				
				case 6:
					new Purchase().m3(cmap, pmap, partyMap, purchaseMap, sales_purchasemap);
					break;
					
				default :
					break;
			
			}
			m5(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);

			
	}
	
	private HashMap<Integer, purchaseorderModel> insert(HashMap<Integer,categoryModel> cmap,HashMap<Integer,productModel> pmap,HashMap<Integer,partyModel> partyMap,HashMap<Integer,purchaseorderModel> purchaseMap) {
		
		System.out.println("The List Of Party:");
		Party party = new Party();
		party.view(partyMap);
		
		System.out.println("Enter Party ID:");
		 p = sc.nextInt();
		
		for(Map.Entry<Integer, partyModel> obj:partyMap.entrySet()) {
			
			if(p==obj.getKey()) {
			
				System.out.println("List Of Product");
				
				Product product = new Product();
				product.view(cmap, pmap);
				break;
							
			}
		}
		
		System.out.println("Enter The product id:");
		p_id = sc.nextInt();
		System.out.println("Enter the quantity:");
		quantity = sc.nextInt();
		
		System.out.println("Do you want to store more?y/n");
		
		String check = sc.next();
		
		if(check.equalsIgnoreCase("y")) {
	
			System.out.println("Enter more quantity:");
			quantity1 = sc.nextInt();
			quantity = quantity+quantity1;
			System.out.println("do you want to store more?y/n");
			check2 = sc.next();
			while(!check2.equalsIgnoreCase("n")) {
				
				System.out.println("Enter more quantity:");
				quantity1 = sc.nextInt();
				quantity = quantity+quantity1;
				System.out.println("do you want to store more?y/n");
				check2 = sc.next();
			}
		}
		
		
		
		for(Map.Entry<Integer, productModel> obj4 : pmap.entrySet()) {
			if(p_id == obj4.getKey()) {
				 p_purchaseprice = obj4.getValue().getP_purchaseprice();
				 break;
			}
			
		}
		
		for(Map.Entry<Integer, partyModel> obj6:partyMap.entrySet()) {
			
			if(p==obj6.getKey()) {
				oaccount = obj6.getValue().getOaccount();
				name = obj6.getValue().getPartyName();
			}
			
		}
		price = p_purchaseprice*quantity;
		
		if(price>oaccount) {
			
			System.out.println("low balance");
			
		}
		else {
			oaccount = oaccount - price;
			if(oaccount==0) {
				
				System.out.println("balance over");
				
			}
			else {
				for(Map.Entry<Integer, partyModel> obj7:partyMap.entrySet()) {
					obj7.getValue().setOaccount(oaccount);
					System.out.println("Id"+obj7.getKey()+" "+"Name:"+obj7.getValue().getPartyName()+" "+"OpeningAccount:"+obj7.getValue().getOaccount()+"ContactNumber:"+obj7.getValue().getContactNumber());
				}
			}
			
			
		}
		
		
		
		
		
		purchaseorderModel purchase = new purchaseorderModel(k,m,quantity,price);
		purchaseMap.put(k, purchase);
		for(Map.Entry<Integer, purchaseorderModel> obj2: purchaseMap.entrySet()) {
			
			System.out.println("ID:"+obj2.getKey()+" "+"orderID"+obj2.getValue().getOrder_no()+" "+"quantity:"+obj2.getValue().getQuantity()+" "+"partyName: "+name+"  "+"Price"+ price);
		}
		k++;
		m++;
		
		return purchaseMap;
	}
	
	
	
	private HashMap<Integer, purchaseorderModel> update(HashMap<Integer, categoryModel> cmap,
			HashMap<Integer, productModel> pmap, HashMap<Integer, partyModel> partyMap,
			HashMap<Integer, purchaseorderModel> purchaseMap) {
	
		System.out.println("1.partyName\n2.quantity");
		System.out.println("Enter choice:");
		int c = sc.nextInt();
		if(c==1) {
			for(Map.Entry<Integer, partyModel> obj : partyMap.entrySet()) {
				System.out.println("Id"+obj.getKey()+" "+"Name:"+obj.getValue().getPartyName()+" "+"OpeningAccount:"+obj.getValue().getOaccount()+"ContactNumber:"+obj.getValue().getContactNumber());;

			}
			System.out.println("Enter party id:");
			int id = sc.nextInt();
			for(Map.Entry<Integer, partyModel> obj : partyMap.entrySet()) {
				if(id==obj.getKey()) {
				System.out.println("Enter PartyName:");
				String pname = sc.next();
				obj.getValue().setPartyName(pname);
				break;
				}
			}
		}
		else if(c==2) {
			
			for(Map.Entry<Integer, purchaseorderModel> obj: purchaseMap.entrySet()) {
				System.out.println("ID:"+obj.getKey()+" "+"orderID"+obj.getValue().getOrder_no()+" "+"quantity:"+obj.getValue().getQuantity()+" "+"partyName: "+name+"  "+"Price"+ price);

			}
			System.out.println("Enter purchase id:");
			int id = sc.nextInt();
			for(Map.Entry<Integer, purchaseorderModel> obj: purchaseMap.entrySet()) {
				if(id==obj.getKey()) {
					System.out.println("Enter quantity:");
					int quant = sc.nextInt();
					obj.getValue().setQuantity(quant);
					break;
					
				}
				
			}
		}
		return purchaseMap;
	}
	
	HashMap<Integer, purchaseorderModel> view(HashMap<Integer, categoryModel> cmap,
			HashMap<Integer, productModel> pmap, HashMap<Integer, partyModel> partyMap,
			HashMap<Integer, purchaseorderModel> purchaseMap) {
		
		for(Map.Entry<Integer, partyModel> obj : partyMap.entrySet()) {
			System.out.println("Id"+obj.getKey()+" "+"Name:"+obj.getValue().getPartyName()+" "+"OpeningAccount:"+obj.getValue().getOaccount()+"ContactNumber:"+obj.getValue().getContactNumber());;

		}
		System.out.println("Enter party id:");
		int id = sc.nextInt();
		for(Map.Entry<Integer, purchaseorderModel> obj5 : purchaseMap.entrySet()) {
			for(Map.Entry<Integer, partyModel> obj6:partyMap.entrySet()) {
				
				if(id==obj6.getKey()) {
					
					name = obj6.getValue().getPartyName();
					System.out.println("ID:"+obj5.getKey()+" "+"order_no:"+obj5.getValue().getOrder_no()+" "+"Quantity:"+obj5.getValue().getQuantity()+" "+"Price"+obj5.getValue().getPrice()+" "+"partyName"+name);
					break;
				}
				
				
			}
			
			
		}
		return purchaseMap;
	}
	
	private HashMap<Integer, purchaseorderModel> search(HashMap<Integer,categoryModel> cmap,HashMap<Integer,productModel> pmap,HashMap<Integer,partyModel> partyMap,HashMap<Integer,purchaseorderModel> purchaseMap) {
		
		System.out.println("Enter ID:");
		int id = sc.nextInt();
		for(Map.Entry<Integer, purchaseorderModel> obj5 : purchaseMap.entrySet()) {
			if(id==obj5.getKey()) {
				
				System.out.println("ID:"+obj5.getKey()+" "+"order_no:"+obj5.getValue().getOrder_no()+" "+"Quantity:"+obj5.getValue().getQuantity()+" "+"Price"+obj5.getValue().getPrice());
				
			}
		}
		return purchaseMap;
	}
	
	private HashMap<Integer, purchaseorderModel> delete(HashMap<Integer, categoryModel> cmap,
			HashMap<Integer, productModel> pmap, HashMap<Integer, partyModel> partyMap,
			HashMap<Integer, purchaseorderModel> purchaseMap) {
		System.out.println("Enter Id you want to delete");
		int o = sc.nextInt();
		for(Map.Entry<Integer,purchaseorderModel> obj: purchaseMap.entrySet()) {
			if(o==obj.getKey()){
				purchaseMap.remove(o);
				break;
			}
		}
		return purchaseMap;
	}



	
	
}	
