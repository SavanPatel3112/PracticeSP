package abc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Purchaseorder_sales {
	Scanner sc = new Scanner(System.in);
	
	int party_id,product_id,quantity,q1,q2,purchase_price,price,oaccount;
	int k=0,m=0;
	String check,partyName,name;
	
	public void m7(HashMap<Integer, categoryModel> cmap, HashMap<Integer, productModel> pmap,
			HashMap<Integer, partyModel> partyMap,HashMap<Integer, purchaseorderModel> purchaseMap, HashMap<Integer, salespurchaseModel> sales_purchasemap) {
		
		System.out.println("1.Insert\n2.Search\n3.Update\n4.View\n5.Delete\n6.Exit");
		System.out.println("Enter Option:");
		int p = sc.nextInt();
		
		switch(p) {
		
			case 1:
				sales_purchasemap = insert(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
				break;
			
			case 2:
				sales_purchasemap = search(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
				break;
			
			case 3:
				sales_purchasemap = update(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
				break;
				
			case 4:
				sales_purchasemap = view(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
				break;
			
			case 5:
				sales_purchasemap = delete(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
				break;
			
			case 6:
				new Sales().m4(cmap, pmap, partyMap, purchaseMap, sales_purchasemap);
				break;
		
		}
		m7(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
		
		
	}
	
	

	private HashMap<Integer, salespurchaseModel> insert(HashMap<Integer, categoryModel> cmap,
			HashMap<Integer, productModel> pmap, HashMap<Integer, partyModel> partyMap,
			HashMap<Integer, purchaseorderModel> purchaseMap, HashMap<Integer, salespurchaseModel> sales_purchasemap) {
		
			System.out.println("Party List");
			for(Map.Entry<Integer, partyModel> obj : partyMap.entrySet()) {
				
				System.out.println("Id"+obj.getKey()+" "+"Name:"+obj.getValue().getPartyName()+" "+"OpeningAccount:"+obj.getValue().getOaccount()+"ContactNumber:"+obj.getValue().getContactNumber());
				
			}
			System.out.println("party id:");
			party_id = sc.nextInt();
			

			System.out.println("Product List");
			for(Map.Entry<Integer, productModel> obj : pmap.entrySet()) {
				
				System.out.println("id:"+obj.getKey()+" "+"name:"+obj.getValue().getPname()+" "+"des"+obj.getValue().getPdes()+" "+
				"purchaseprice"+obj.getValue().getP_purchaseprice()+"salesprice"+obj.getValue().getP_salesprice()+
				"stock:"+obj.getValue().getP_stock()+"Status:"+obj.getValue().getP_status());        
				
			}
			System.out.println("product id:");
			product_id = sc.nextInt();
			
			System.out.println("Enter quantity:");
			quantity = sc.nextInt();
			
			System.out.println("Do you want to store more?y/n");
			check = sc.next();
			
			if(check.equalsIgnoreCase("y")) {
				System.out.println("Enter quantity:");
				q1 = sc.nextInt();
				quantity = q1+quantity;
				System.out.println("Do you want to store more?y/n");
				check = sc.next();
				while(!check.equalsIgnoreCase("n")) {
					
					System.out.println("Enter quantity:");
					q2 = sc.nextInt();
					quantity = q2+quantity;
					System.out.println("Do you want to store more?y/n");
					check = sc.next();
				}
				for(Map.Entry<Integer, productModel> obj : pmap.entrySet()) {
					if(product_id==obj.getKey()) {
						
						purchase_price = obj.getValue().getP_salesprice();
						break;
					}
				}
				price = purchase_price*quantity;
				for(Map.Entry<Integer, partyModel> obj : partyMap.entrySet())
				{
					if(party_id==obj.getKey()) {
						oaccount = obj.getValue().getOaccount();
						partyName = obj.getValue().getPartyName();
						break;
					}
				}
				
				oaccount = oaccount+price;
				for(Map.Entry<Integer, partyModel> obj : partyMap.entrySet()) {
					
					if(party_id==obj.getKey()) {
						obj.getValue().setOaccount(oaccount);
						break;
					}
				}
				
				for(Map.Entry<Integer, salespurchaseModel> obj2: sales_purchasemap.entrySet()) {
					
					System.out.println("ID:"+obj2.getKey()+" "+"orderID"+obj2.getValue().getOrder_no()+" "+"quantity:"+obj2.getValue().getQuantity()+" "+"partyName: "+partyName+"  "+"Price"+ price);
				}
			
			
			
			salespurchaseModel purchase = new salespurchaseModel(k,m,quantity,price);
			sales_purchasemap.put(k, purchase);
			for(Map.Entry<Integer, salespurchaseModel> obj2: sales_purchasemap.entrySet()) {
				
				System.out.println("ID:"+obj2.getKey()+" "+"orderID"+obj2.getValue().getOrder_no()+" "+"quantity:"+obj2.getValue().getQuantity()+" "+"partyName: "+partyName+"  "+"Price"+ price);
			}
			k++;
			m++;
				
				
				
			}
			else {
				//System.out.println("Hello");
				
				for(Map.Entry<Integer, productModel> obj : pmap.entrySet()) {
					///System.out.println("Hello");

					if(product_id==obj.getKey()) {
						//System.out.println("Hello");

						purchase_price = obj.getValue().getP_salesprice();

						break;
					}

				}
				price = purchase_price*quantity;

				for(Map.Entry<Integer, partyModel> obj : partyMap.entrySet())
				{
					if(party_id==obj.getKey()) {
						oaccount = obj.getValue().getOaccount();
						partyName = obj.getValue().getPartyName();
						break;
					}
				}
				
				oaccount = oaccount+price;
				for(Map.Entry<Integer, partyModel> obj : partyMap.entrySet()) {
					
					if(party_id==obj.getKey()) {
						obj.getValue().setOaccount(oaccount);
						break;
					}
				}
				
			salespurchaseModel purchase = new salespurchaseModel(k,m,quantity,price);
			sales_purchasemap.put(k, purchase);
			for(Map.Entry<Integer, salespurchaseModel> obj2: sales_purchasemap.entrySet()) {
				
				System.out.println("ID:"+obj2.getKey()+" "+"orderID"+obj2.getValue().getOrder_no()+" "+"quantity:"+obj2.getValue().getQuantity()+" "+"partyName: "+partyName+"  "+"Price"+ price);
			}
			k++;
			m++;
				
		}
	return sales_purchasemap;
	}
	
	private HashMap<Integer, salespurchaseModel> search(HashMap<Integer, categoryModel> cmap,
			HashMap<Integer, productModel> pmap, HashMap<Integer, partyModel> partyMap,
			HashMap<Integer, purchaseorderModel> purchaseMap, HashMap<Integer, salespurchaseModel> sales_purchasemap) {
		
		
		System.out.println("Enter ID:");
		int id = sc.nextInt();
		for(Map.Entry<Integer, salespurchaseModel> obj5 : sales_purchasemap.entrySet()) {
			if(id==obj5.getKey()) {
				
				System.out.println("ID:"+obj5.getKey()+" "+"order_no:"+obj5.getValue().getOrder_no()+" "+"Quantity:"+obj5.getValue().getQuantity()+" "+"Price"+obj5.getValue().getPrice());
				
			}
		}
		
		
		
		
		
		return sales_purchasemap;
	
	
	
	}
	
	HashMap<Integer, salespurchaseModel> view(HashMap<Integer, categoryModel> cmap,
			HashMap<Integer, productModel> pmap, HashMap<Integer, partyModel> partyMap,
			HashMap<Integer, purchaseorderModel> purchaseMap, HashMap<Integer, salespurchaseModel> sales_purchasemap) {
		
		
		
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
		return sales_purchasemap;
	}
	
	
	private HashMap<Integer, salespurchaseModel> update(HashMap<Integer, categoryModel> cmap,
			HashMap<Integer, productModel> pmap, HashMap<Integer, partyModel> partyMap,
			HashMap<Integer, purchaseorderModel> purchaseMap, HashMap<Integer, salespurchaseModel> sales_purchasemap) {
		
		
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
			
			for(Map.Entry<Integer, salespurchaseModel> obj: sales_purchasemap.entrySet()) {
				System.out.println("ID:"+obj.getKey()+" "+"orderID"+obj.getValue().getOrder_no()+" "+"quantity:"+obj.getValue().getQuantity()+" "+"partyName: "+partyName+"  "+"Price"+ price);

			}
			System.out.println("Enter purchase id:");
			int id = sc.nextInt();
			for(Map.Entry<Integer, salespurchaseModel> obj: sales_purchasemap.entrySet()) {
				if(id==obj.getKey()) {
					System.out.println("Enter quantity:");
					int quant = sc.nextInt();
					obj.getValue().setQuantity(quant);
					break;
					
				}
				
			}
		}
		return sales_purchasemap;
	}
	
	private HashMap<Integer, salespurchaseModel> delete(HashMap<Integer, categoryModel> cmap,
			HashMap<Integer, productModel> pmap, HashMap<Integer, partyModel> partyMap,
			HashMap<Integer, purchaseorderModel> purchaseMap, HashMap<Integer, salespurchaseModel> sales_purchasemap) {
		
		System.out.println("Enter Id you want to delete");
		int o = sc.nextInt();
		for(Map.Entry<Integer,salespurchaseModel> obj: sales_purchasemap.entrySet()) {
			if(o==obj.getKey()){
				sales_purchasemap.remove(o);
				break;
			}
		}
		
		
		
		return sales_purchasemap;
	}
}
