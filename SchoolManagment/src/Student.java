import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Student{
    int b=0;
    int s;
    Scanner sc = new Scanner(System.in);
    public Departmentmodel method2 (HashMap<Integer,Departmentmodel>dmmodel,HashMap<Integer,Studentmodel>smmap){
        System.out.println("The list of department: ");
        Department department = new Department();
        department.View(dmmodel);
        System.out.println("--------------------------------------------------------------\nEnter the department id where you want student add: ");
        int departmentId = sc.nextInt();sc.nextLine();
        Departmentmodel departmentmodel=null;
        if (!dmmodel.isEmpty()){
            boolean departmentExist = false;
            for (Map.Entry<Integer,Departmentmodel> departmentmodel1 : dmmodel.entrySet()){
                if (departmentmodel1.getValue().getId()!=0 && departmentmodel1.getValue().getId() == departmentId){
                    departmentmodel = departmentmodel1.getValue();
                    departmentExist = true;
                    break;
                }
            }
            if (!departmentExist){
                System.out.println("!!..Department not found..!!\n------------------------------");
            }
        }/*else{
            System.out.println("!!..Please Enter Department First..!!");
            Alltask alltask = new Alltask();
            alltask.run(dmmodel,smmap);
        }*/
        return departmentmodel;
    }
    public void studentDetailOperations(HashMap<Integer,Departmentmodel>dmmodel,HashMap<Integer,Studentmodel>smmap){
        System.out.println("-----------StudentDetails-----------\n1)Add\n2)View\n3)Update\n4)Search\n5)Delete\n6)Exit\n->Select option:-");
        s = sc.nextInt();
        switch (s) {
            case 1 -> {
                smmap = Add(dmmodel, smmap);
                studentDetailOperations(dmmodel,smmap);
            }
            case 2 -> {
                smmap = View(dmmodel,smmap);
                studentDetailOperations(dmmodel,smmap);
            }
            case 3 -> {
                smmap = Update(dmmodel,smmap);
                studentDetailOperations(dmmodel,smmap);
            }
            case 4 -> {
                smmap = Search(dmmodel,smmap);
                studentDetailOperations(dmmodel,smmap);
            }
            case 5 -> {
                smmap = Delete(dmmodel, smmap);
                studentDetailOperations(dmmodel,smmap);
            }
            default -> {
            }
        }
    }
    public HashMap<Integer,Studentmodel> Add (HashMap<Integer,Departmentmodel>dmmodel,HashMap<Integer,Studentmodel>smmap){
        Departmentmodel departmentmodel = method2(dmmodel,smmap);
        if (departmentmodel!=null) {
            System.out.println("Enter the student id: ");
            int studentId = sc.nextInt();sc.nextLine();

            System.out.println("Enter the student name: ");
            String studentName = sc.nextLine();

            System.out.println("Enter the student number: ");
            String studentNumber = sc.nextLine();
            if (studentNumber.length() == 10) {
                System.out.println(" ");
            }
            Studentmodel sm = new Studentmodel(departmentmodel.getDepartmentName(), studentId, studentName, studentNumber, departmentmodel.getId());
            smmap.put(b, sm);
            b++;

            System.out.println("You want add more Yes/No");
            String check = sc.next();
            if (check.equalsIgnoreCase("Yes")) {
                smmap = Add(dmmodel, smmap);
            }
            return smmap;
        }
       return null;
    }
    public  HashMap<Integer,Studentmodel> View (HashMap<Integer,Departmentmodel> ignoredDmmodel, HashMap<Integer,Studentmodel>smmap){
        for (Map.Entry<Integer,Studentmodel> obj:smmap.entrySet()){
            System.out.println("-----------All Student-----------"+"\n"+"DepartmentId:-> "+obj.getValue().getDepartmentId()+"\n"+"DepartmentName:-> "+obj.getValue().getDepartmentName()+"\n"+"Id:-> "+obj.getValue().getStudentId()+"\n"+"Name:-> "+obj.getValue().getStudentName()+"\n"+"Number:-> "+obj.getValue().getStudentNumber());
        }
        return smmap;
    }
    public HashMap<Integer,Studentmodel> Update (HashMap<Integer,Departmentmodel>dmmodel,HashMap<Integer,Studentmodel>smmap){
        Departmentmodel departmentmodel = method2(dmmodel,smmap);
        if (departmentmodel!=null) {
            System.out.println("Enter the student id:");
            int a = sc.nextInt();
            for (Map.Entry<Integer, Studentmodel> obj : smmap.entrySet()) {
                if (a == obj.getValue().getStudentId()) {
                    System.out.println("What do you want to change: \n1)StudentName\n2)Number\nEnter your choice: ");
                    int update = sc.nextInt();
                    if (update == 1) {
                        System.out.println("Enter the Student new name:  ");
                        String studentName = sc.next();
                        obj.getValue().setStudentName(studentName);
                    } else if (update == 2) {
                        System.out.println("Enter the student new number: ");
                        String studentNumber = sc.nextLine();
                        obj.getValue().setStudentNumber(studentNumber);
                    }
                    break;
                }
            }
            return smmap;
        }
        return null;
    }
    public HashMap<Integer,Studentmodel> Search (HashMap<Integer,Departmentmodel>dmmodel,HashMap<Integer,Studentmodel>smmap){
        System.out.println("Enter the student id you want to search: ");
        int search = sc.nextInt();
        for (Map.Entry<Integer,Studentmodel> obj:smmap.entrySet()){
            if (search==obj.getValue().getStudentId()){
                System.out.println("-----------------------------------------------------------"+"\n"+"Department id:->"+obj.getValue().getDepartmentId()+"\n"+"Student Id:-> "+obj.getValue().getStudentId()+"\n"+"Student Name:-> "+obj.getValue().getStudentName()+"\n"+"Student Number:-> "+obj.getValue().getStudentNumber());
                break;
            }
        }
        return smmap;
    }
    public HashMap<Integer, Studentmodel> Delete (HashMap<Integer,Departmentmodel> dmmodel,HashMap<Integer,Studentmodel>smmap){
        System.out.println("The list of department: ");
        Department department = new Department();
        department.View(dmmodel);
        System.out.println("Enter student id you want to delete: ");
        int de =sc.nextInt();sc.nextLine();
        if (!smmap.isEmpty()) {
            boolean studentExist = false;
            for (Map.Entry<Integer, Studentmodel> obj : smmap.entrySet()) {
                if (de == obj.getValue().getStudentId()) {
                    smmap.remove(obj.getKey());
                    System.out.println("Deleted...");
                    studentExist = true;
                    break;
                }
            }
            if (!studentExist){
                System.out.println("!!..Student id not exist..!!");
            }
        }
        return  smmap;
    }
}