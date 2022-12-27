import java.util.HashMap;
import java.util.Scanner;
public class Alltask {
    int a;
public void run(HashMap<Integer,Departmentmodel>dmmodel,HashMap<Integer,Studentmodel>smmap){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------College Details-----------\n1)Department\n2)StudentDetails\n3)Exit\nSelect the number: ");
        a = sc.nextInt();
        switch (a) {
            case 1 -> {
                Department department = new Department();
                department.method1(dmmodel, smmap);
                run(dmmodel, smmap);
            }
            case 2 -> {
                Student student = new Student();
                student.studentDetailOperations(dmmodel, smmap);
                run(dmmodel, smmap);
            }
            default -> {
            }
        }
    }
}
















