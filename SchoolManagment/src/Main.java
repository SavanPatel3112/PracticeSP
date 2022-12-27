import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Alltask at = new Alltask();

        HashMap<Integer,Departmentmodel>dmmodel = new HashMap<>();
        HashMap<Integer,Studentmodel>smmap = new HashMap<>();
        at.run(dmmodel,smmap);
    }
}
