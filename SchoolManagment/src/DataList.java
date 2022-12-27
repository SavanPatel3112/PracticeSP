import java.util.Map;

public class DataList {

    Map<Integer,Departmentmodel> departmentmodelMap;

    Map<Integer,Studentmodel> studentmodelMap;


    public DataList() {
    }



    public DataList(Map<Integer, Departmentmodel> departmentmodelMap, Map<Integer, Studentmodel> studentmodelMap) {
        this.departmentmodelMap = departmentmodelMap;
        this.studentmodelMap = studentmodelMap;
    }

    public Map<Integer, Studentmodel> getStudentmodelMap() {
        return studentmodelMap;
    }

    public void setStudentmodelMap(Map<Integer, Studentmodel> studentmodelMap) {
        this.studentmodelMap = studentmodelMap;
    }
}
