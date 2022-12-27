package abc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Product {
	int k=0;
	int c,p_purchaseprice,p_salesprice;
	String pname,pdes,p_stock,p_status;
	Scanner sc = new Scanner(System.in);
	public void m2(HashMap<Integer,categoryModel> cmap,HashMap<Integer,productModel> pmap) {
	
        //HashMap<Integer, String> hm1 = new HashMap<>(); 

		System.out.println("1.Insert\n2.Search\n3.View\n4.Update\n5.Delete\n6.Exit");
		System.out.println("Select option");
		c = sc.nextInt();
		
		//Category cat = new Category();
		//cat.show(alist);
		
		switch(c) {
			case 1:
				pmap= insert(cmap,pmap);
				m2(cmap,pmap);
				break;
			case 2:
				pmap=search(pmap);
				m2(cmap,pmap);
				break;
			case 3:
				pmap=view(cmap,pmap);
				m2(cmap,pmap);
				break;
			case 4:
				pmap=update(pmap);
				m2(cmap,pmap);
				break;
			case 5:
				pmap=delete(pmap);
				m2(cmap,pmap);
				break;
			case 6:
				break;
			default:
				break;
		}
		
		
	}
	public HashMap<Integer,productModel> insert(HashMap<Integer,categoryModel> cmap,HashMap<Integer,productModel> pmap) {
		
		System.out.println("The List Of Category:");
		Category category = new Category();
		category.view(cmap);
		
		//System.out.println("Enter Category Id to store deatils:");
		//int a = sc.nextInt();
		
		//categoryModel as = category.getObj(a, cmap);
		//System.out.println(as);
		System.out.println("Enter ProductName");
		pname = sc.next();
		System.out.println("Enter ProductDes");
		pdes = sc.next();
		System.out.println("Enter Product Purchaseprice");
		p_purchaseprice = sc.nextInt();
		System.out.println("Enter Product Saleseprice");
		p_salesprice = sc.nextInt();
		System.out.println("Enter Product Stock");
		p_stock = sc.next();
		System.out.println("Enter Product Status");
		p_status = sc.next();
		
		productModel p = new productModel(k,pname,pdes,p_purchaseprice,p_salesprice,p_stock,p_status);
		pmap.put(k,p);
		k++;
		System.out.println("Do you want to store more?y/n");
		String check = sc.next();
		if(check.equalsIgnoreCase("y")) {
			pmap = insert(cmap,pmap);
		}
		
		return pmap;
		
	}
	public HashMap<Integer,productModel> search(HashMap<Integer,productModel> pmap) {
		System.out.println("Search By 1.ID\n2.Name");
		System.out.println("Enter choice");
		int l = sc.nextInt();
		if(l==1) {
			System.out.println("Enter ID:");
			int m = sc.nextInt();
			for(Map.Entry<Integer,productModel> obj: pmap.entrySet()) {
				if(m==obj.getKey()) {
					int id = obj.getKey();
					String name = obj.getValue().getPname();
					String des = obj.getValue().getPdes();
					System.out.println("Id"+id+""+"name"+name+""+"des"+des);
					break;
				}
			}
		}
		else if(l==2) {
			
			System.out.println("Enter Name:");
			String n = sc.next();
			for(Map.Entry<Integer,productModel> obj: pmap.entrySet()) {
				if(n.equals(obj.getValue().getPname())) {
					int id = obj.getKey();
					String name = obj.getValue().getPname();
					String des = obj.getValue().getPdes();
					System.out.println("Id"+id+""+"name"+name+""+"des"+des);
					break;
				}
			}
		}
		return pmap;
		
	}
	
	public HashMap<Integer,productModel> view(HashMap<Integer,categoryModel> cmap,HashMap<Integer,productModel> pmap) {
		//view category list:
//		for(Map.Entry<Integer, categoryModel> obj1 : cmap.entrySet()) 
//		{
//			if(cmap.isEmpty()) {
//				System.out.println("Enterparty")
//			}
//			System.out.println("Id"+obj1.getKey()+" "+"Name:"+obj1.getValue().getCategoryname()+"Des"+obj1.getValue().getCategorydes());
//		}
		
		for(Map.Entry<Integer,productModel> obj: pmap.entrySet()) 
		{
			
			int id = obj.getKey();
			String name = obj.getValue().getPname();
			String des = obj.getValue().getPdes();
			int purchaseprice = obj.getValue().getP_purchaseprice();
			int salesprice = obj.getValue().getP_salesprice();
			String stock = obj.getValue().getP_stock();
			String status = obj.getValue().getP_status();
			System.out.println("id:"+id+" "+"name:"+name+" "+"des"+des+" "+"purchaseprice"+purchaseprice+"salesprice"+salesprice+"stock:"+stock+"Status:"+status+"Category:");        
		}
		return pmap;
	}
	
	public HashMap<Integer,productModel> update(HashMap<Integer,productModel> pmap)
	{
		System.out.println("Enter Id:");
		int h = sc.nextInt();
		for(Map.Entry<Integer,productModel> obj: pmap.entrySet()) 
		{
			if(h==obj.getKey()) 
			{
				System.out.println("What do you want to change?");
				System.out.println("1.ProductName\n2.ProductDes\n3.ProductPurchasePrice\n4.ProductSalesPrice\n5.ProductStock");
				System.out.println("Enter choice");
				int c = sc.nextInt();
				if(c==1) 
				{
					System.out.println("Enter ProductName to change:");
					String pchange = sc.next();
					obj.getValue().setPname(pchange);
					
				}
				else if(c==2) 
				{
					System.out.println("Enter ProductDes to change:");
					String pdeschange = sc.next();
					obj.getValue().setPdes(pdeschange);
					
				}
				else if(c==3) 
				{
					System.out.println("Enter ProductPurchasePrice to change:");
					int ppurchaseprice_change = sc.nextInt();
					obj.getValue().setP_purchaseprice(ppurchaseprice_change);
					
				}
				else if(c==4) 
				{
					System.out.println("Enter ProductSalesPrice to change:");
					int psalesprice_change = sc.nextInt();
					obj.getValue().setP_salesprice(psalesprice_change);
					
				}
				else if(c==5) 
				{
					System.out.println("Enter ProductStock to change:");
					String pstock_change = sc.next();
					obj.getValue().setP_stock(pstock_change);
					
				}
				break;
			}
			
		}
		return pmap;
		
	}
	public HashMap<Integer,productModel> delete(HashMap<Integer,productModel> pmap) 
	{
		System.out.println("Enter Id you want to delete");
		int q = sc.nextInt();
		for(Map.Entry<Integer,productModel> obj: pmap.entrySet()) {
			if(q==obj.getKey()) {
				pmap.remove(q);
			}
		}
		
		return pmap;
	}
	

}
