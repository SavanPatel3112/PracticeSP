package abc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Party {
	String partyName;
	String contactNumber;
	int oaccount;
	int k =0;
	Scanner sc = new Scanner(System.in);
	public void m4(HashMap<Integer,categoryModel> cmap,HashMap<Integer,productModel> pmap,HashMap<Integer,partyModel> partyMap,
			HashMap<Integer,purchaseorderModel> purchaseMap,HashMap<Integer,salespurchaseModel> sales_purchasemap) {
		
		
		System.out.println("1.Insert\n2.View\n3.Update\n4.Delete\n5.search\n6.exit1\n7.exit2:");
		System.out.println("Enter The Option:");
		int p = sc.nextInt();
		
		
		switch(p) {
		
		case 1:
			partyMap=insert(partyMap);
			
			break;
		
		case 2:
			partyMap=view(partyMap);
			break;
			
		case 3:
			partyMap=update(partyMap);
			break;	
			
		case 4:
			partyMap=delete(partyMap);
			break;
			
		case 5:
			partyMap=search(partyMap);
			break;	
		
		case 6:
			new Purchase().m3(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
			
			break;
			
		case 7:
			new Sales().m4(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
			
			break;
				
			
		default :
			break;
		}
		m4(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
	}
	
	
	
	
	private HashMap<Integer, partyModel> insert(HashMap<Integer, partyModel> partyMap) {
		System.out.println("Enter Party Name");
		partyName = sc.next();
		System.out.println("Enter Party OpeningAccount");
		oaccount = sc.nextInt();
		System.out.println("Enter Party ContactNumber");
		contactNumber = sc.next();
		partyModel pmodel  = new partyModel(k, contactNumber, partyName, oaccount);
		partyMap.put(k,pmodel);
		k++;
		System.out.println("Do you want to store more?y/n");
		String check = sc.next();
		if(check.equalsIgnoreCase("y")) {
			partyMap = insert(partyMap);
		}
		return partyMap;
	}
	
	
	public HashMap<Integer, partyModel> view(HashMap<Integer, partyModel> partyMap) {
		
		for(Map.Entry<Integer,partyModel> obj: partyMap.entrySet()) {
			
			System.out.println("Id"+obj.getKey()+" "+"Name:"+obj.getValue().getPartyName()+" "+"OpeningAccount:"+obj.getValue().getOaccount()+"ContactNumber:"+obj.getValue().getContactNumber());;
		}
		return partyMap;
	}
	
	
	private HashMap<Integer, partyModel> update(HashMap<Integer, partyModel> partyMap) {
		
		System.out.println("Enter Id:");
		int a = sc.nextInt();
		for(Map.Entry<Integer,partyModel> obj: partyMap.entrySet()) {
		if(a==obj.getKey()){
			System.out.println("What do you want to change?");
			System.out.println("1.ConatctNumber\n2.PartyName\n3.OpeningAccount");
			System.out.println("Enter choice");
			int c = sc.nextInt();
			if(c==1) {
			System.out.println("Enter New ContactNumber:");
			String no = sc.next();
			obj.getValue().setContactNumber(no);
			}
			else if(c==2) {
				System.out.println("Enter New PartyName to change:");
				String partname_change = sc.next();
				obj.getValue().setPartyName(partname_change);
			}
			else if(c==3) {
				System.out.println("Enter New OpeningAccount to change:");
				int oaccount_change = sc.nextInt();
				obj.getValue().setOaccount(oaccount_change);;
			}
			break;
		}
		
		
	 }
		
		
		return partyMap;
	}
	private HashMap<Integer, partyModel> search(HashMap<Integer, partyModel> partyMap) {
		
		
		System.out.println("Enter your choice:\n1id\n2.Partyname");
		int q = sc.nextInt();
		if(q==1) {
			System.out.println("Enter Id you want to search:");
			//int i =clist.size();
			//System.out.println(i);
			int m = sc.nextInt();
			for(Map.Entry<Integer,partyModel> obj: partyMap.entrySet()) {
				System.out.println(obj.getKey());
				if(m==obj.getKey()){
					System.out.println("ContactNumber:"+obj.getValue().getContactNumber());
					System.out.println("PartyName:"+obj.getValue().getPartyName());
					System.out.println("OpeningAccount:"+obj.getValue().getOaccount());

					break;
				}
			}
		}
		else if(q==2) {
			System.out.println("Enter Party name:");
			String n = sc.next();
			for(Map.Entry<Integer,partyModel> obj: partyMap.entrySet()) {
			if(n.equals(obj.getValue().getPartyName())) {
				System.out.println("ID:"+obj.getKey());
				System.out.println("contactNumver:"+obj.getValue().getContactNumber());
				System.out.println("OpeningAccount:"+obj.getValue().getOaccount());

				break;
				}
			}	
		}
		else{
			System.out.println("::Enter Valid Name And Id::");
		}
		return partyMap;
	}
	
	private HashMap<Integer, partyModel> delete(HashMap<Integer, partyModel> partyMap) {
		
		System.out.println("Enter Id you want to delete");
		int o = sc.nextInt();
		for(Map.Entry<Integer,partyModel> obj: partyMap.entrySet()) {
			if(o==obj.getKey()){
				partyMap.remove(o);
				break;
			}
		}
		return partyMap;
	}
}
	
	


