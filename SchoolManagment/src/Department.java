import java.util.*;
public class Department extends Student{
    int a;
    int b = 0;
    Scanner sc = new Scanner(System.in);
    public void method1(HashMap<Integer,Departmentmodel> dmmodel, HashMap<Integer,Studentmodel>smmap){
        System.out.println("-----------DepartmenttDetails-----------\n1)Add\n2)View\n3)Delete\n4)Update\n5)Search\n6)Exit\n->Select option:-");
        a=sc.nextInt();sc.nextLine();
        switch (a) {
            case 1 -> dmmodel = Add(dmmodel);
            case 2 -> dmmodel = View(dmmodel);
            case 3 -> smmap = Delete(dmmodel,smmap);
            case 4 -> dmmodel = Update(dmmodel);
            case 5 -> dmmodel = Search(dmmodel);
            case 6 ->new Alltask().run(dmmodel, smmap);
            default -> {
            }
        }
        method1(dmmodel,smmap);
    }
    public HashMap<Integer,Departmentmodel> Add (HashMap<Integer,Departmentmodel>dmmodel){
        System.out.println("Enter the department id: ");
        int departmentId = sc.nextInt();sc.nextLine();

        System.out.println("Enter the department name: ");
        String departmentName =sc.next();

        System.out.println("Enter the department description: ");
        String departmentDescription = sc.next();

        Departmentmodel dm = new Departmentmodel(departmentId,departmentName,departmentDescription);
        dmmodel.put(b,dm);
        b++;
        System.out.println("You Want add more department?Yes/No");
        String check = sc.next();
        if (check.equalsIgnoreCase("yes")){
            dmmodel = Add(dmmodel);
        }
        return dmmodel;
    }
    public HashMap<Integer, Studentmodel> Delete (HashMap<Integer,Departmentmodel>dmmodel, HashMap<Integer,Studentmodel>smmap){
        System.out.println("--------------------------------------------\n->The list of department: ");
        Department department = new Department();
        department.View(dmmodel);
        System.out.println("->Enter department id you want to delete: ");
        int departmentId =sc.nextInt();sc.nextLine();
        if (!dmmodel.isEmpty()) {
            boolean departmentExist = false;
            for (Map.Entry<Integer,Departmentmodel> obj : dmmodel.entrySet()) {
                if (departmentId==obj.getValue().getId()) {
                    smmap.remove(obj.getKey());
                    System.out.println("Deleted...");
                    departmentExist = true;
                    break;
                }
            }
            if(!departmentExist) {
                System.out.println("!!..department not found..!!");
            }
            Set<Integer> integerSet = new HashSet<>();
            for (Map.Entry<Integer, Studentmodel> studentmodelEntry : smmap.entrySet()) {
                if (studentmodelEntry.getValue().getDepartmentId() != 0 && studentmodelEntry.getValue().getDepartmentId() == departmentId) {
                    integerSet.add(studentmodelEntry.getValue().getDepartmentId());
                }
            }
            if (!integerSet.isEmpty()){
                smmap.keySet().removeAll(integerSet);
            }
        }
        return smmap;
    }
    HashMap<Integer,Departmentmodel> View(HashMap<Integer, Departmentmodel> dmmodel){
        for (Map.Entry<Integer,Departmentmodel> obj:dmmodel.entrySet()){
            System.out.println("-----------Department-----------"+"\n"+"Id:-> "+obj.getValue().getId()+"\n"+"Name:-> "+obj.getValue().getDepartmentName()+"\n"+"Description:-> "+obj.getValue().getDepartmentDesc());
        }
        return dmmodel;
    }
    public HashMap<Integer,Departmentmodel> Update (HashMap<Integer,Departmentmodel> dmmodel){
        System.out.println("->The list of department: ");
        Department department = new Department();
        department.View(dmmodel);
        System.out.println("Enter the DepartmentId: ");
        int a = sc.nextInt();
        for (Map.Entry<Integer,Departmentmodel> obj :dmmodel.entrySet()){
            if (a==obj.getValue().getId()){
                System.out.println("What do you want change in department: \n1)DepartmentName\n2)DepartmentDescription\nEnter your choice: ");
                int update = sc.nextInt();
                if (update==1){
                    System.out.println("Enter the new department name: ");
                    String departmentName = sc.next();
                    obj.getValue().setDepartmentName(departmentName);
                }else if (update==2){
                    System.out.println("Enter the new department description: ");
                    String departmentDesc = sc.next();
                    obj.getValue().setDepartmentDesc(departmentDesc);
                }
                break;
            }
        }
        return dmmodel;
    }
    public HashMap<Integer,Departmentmodel> Search (HashMap<Integer,Departmentmodel>dmmodel){
        System.out.println("Enter the department id you want to search: ");
        int search = sc.nextInt();
        for (Map.Entry<Integer,Departmentmodel>obj:dmmodel.entrySet()){
            if (search==obj.getValue().getId()){
                System.out.println("Id:-> "+obj.getValue().getId()+"\n"+"Name:-> "+obj.getValue().getDepartmentName()+"\n"+"Description:-> "+obj.getValue().getDepartmentDesc());
            break;
            }else {
                System.out.println("!!..student id not found..!!");
            }
        }
        return dmmodel;
    }
}