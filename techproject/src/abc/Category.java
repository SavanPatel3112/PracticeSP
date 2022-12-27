package abc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Category{

	int a;
	String categoryname,categorydes;
	List<categoryModel> list;
	int aa;
	int k=0;
	Scanner sc = new Scanner(System.in);
	public void m1(HashMap<Integer,categoryModel> cmap,HashMap<Integer,productModel> pmap,HashMap<Integer,partyModel> partyMap,
			HashMap<Integer,purchaseorderModel> purchaseMap,HashMap<Integer,salespurchaseModel> sales_purchasemap) {
		
		System.out.println("1.Insert\n2.Search\n3.View\n4.update\n5.Delete\n6.Exit");
		System.out.println("Select Option");
		a = sc.nextInt();
		
		switch(a) {
			case 1:
				cmap= insert(cmap);
				//System.out.println(cmap);
				break;
			case 2:
				cmap=search(cmap);
				break;
			case 3:
				cmap=view(cmap);
				
				break;
			case 4:
				cmap=update(cmap);
				break;
			case 5:
				cmap=delete(cmap);
				break;
			case 6:
				//System.exit(0);
				new task().start(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
				break;
			default:
				break;
		}
		m1(cmap,pmap,partyMap,purchaseMap,sales_purchasemap);
	}

	
	public HashMap<Integer,categoryModel> insert(HashMap<Integer,categoryModel> cmap) {
		
		System.out.println("Enter the name of category::");
		String categoryname = sc.next();
		System.out.println("Enter the category description::");
		String categorydes = sc.next();
		categoryModel c = new categoryModel(k,categoryname,categorydes);
		cmap.put(k,c);
		k++;
		System.out.println("Do you want to store more?y/n");
		String check = sc.next();
		if(check.equalsIgnoreCase("y")) {
			cmap = insert(cmap);
		}
		return cmap;
	}
	
	public HashMap<Integer,categoryModel> view(HashMap<Integer,categoryModel> cmap) {
		
		for(Map.Entry<Integer,categoryModel> obj: cmap.entrySet()) {
			
			System.out.println("Id"+obj.getKey()+" "+"Name:"+obj.getValue().getCategoryname()+" "+"Des"+obj.getValue().getCategorydes());
			
		}
		return cmap;
		//		for(categoryModel obj:clist) {
		//			int id = obj.getId();
		//			String name = obj.getCategoryname();
		//			String des = obj.getCategorydes();
		//			
		//			System.out.println("id"+id+""+"name:"+name+""+"des"+des+"\n");
		//		}
		//		return clist;
	}
	
	public HashMap<Integer,categoryModel> search(HashMap<Integer,categoryModel> cmap) {
		System.out.println("Enter your choice:\n1id\n2.name");
		int q = sc.nextInt();
		if(q==1) {
			System.out.println("Enter Id you want to search:");
			//int i =clist.size();
			//System.out.println(i);
			int m = sc.nextInt();
			for(Map.Entry<Integer,categoryModel> obj: cmap.entrySet()) {
				System.out.println(obj.getKey());
				if(m==obj.getKey()){
					System.out.println("Name:"+obj.getValue().getCategoryname());
					System.out.println("Des:"+obj.getValue().getCategorydes());
					break;
				}
			}
		}
		else if(q==2) {
			System.out.println("Enter Category name:");
			String n = sc.next();
			for(Map.Entry<Integer,categoryModel> obj: cmap.entrySet()) {
			if(n.equals(obj.getValue().getCategoryname())) {
				System.out.println("ID:"+obj.getKey());
				System.out.println("Des:"+obj.getValue().getCategorydes());
				break;
			}
		 }	
	  }
		else {
			System.out.println("Enter Valid Name And Id");
		}
		
		
		return cmap;
	}
	
	public HashMap<Integer,categoryModel> update(HashMap<Integer,categoryModel> cmap){
		
		System.out.println("Enter Id:");
		int a = sc.nextInt();
		for(Map.Entry<Integer,categoryModel> obj: cmap.entrySet()) {
		if(a==obj.getKey()){
			System.out.println("What do you want to change?");
			System.out.println("1.CategoryName\n2.CategoryDes");
			System.out.println("Enter choice");
			int c = sc.nextInt();
			if(c==1) {
			System.out.println("Enter New Name:");
			String name = sc.next();
			obj.getValue().setCategoryname(name);
			}
			else if(c==2) {
				System.out.println("Enter CateGoryDes to change:");
				String cdes_change = sc.next();
				obj.getValue().setCategorydes(cdes_change);
			}
			break;
		}
		
		
	 }
	 return cmap;
	}
	
	public HashMap<Integer,categoryModel> delete(HashMap<Integer,categoryModel> cmap) {
		
		System.out.println("Enter Id you want to delete");
		int o = sc.nextInt();
		for(Map.Entry<Integer,categoryModel> obj: cmap.entrySet()) {
			if(o==obj.getKey()){
				cmap.remove(o);
				break;
			}
			
		}
		return cmap;
	}
	
//	public categoryModel getObj(int aa,HashMap<Integer,categoryModel> cmap){
//		int aaa=-1;
//		int j;
//		j=aa;
//		
//		for(Map.Entry<Integer, categoryModel> obj1 : cmap.entrySet()) {
//			if(j==obj1.getKey()) {
//				 aaa=j;
//				break;
//			}
//			
//		}
//		categoryModel cdata = null;
//		if(aaa!=-1) {
//			cdata = cmap.get(aaa);
//		}
//		else {
//			System.out.println("Record Not found:");
//			cdata = getObj(aa,cmap);
//		}
//		
//		return cdata;
//	}


	
}
