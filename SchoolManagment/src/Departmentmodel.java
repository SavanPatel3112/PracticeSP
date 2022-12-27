public class Departmentmodel{
    int departmentId;
    String departmentName;
    String departmentDesc;
    public Departmentmodel(int departmentId,String departmentName, String departmentDesc){
        //super();
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentDesc = departmentDesc;

    }
    public int getId(){
        return departmentId;
    }
    public String getDepartmentName(){
        return departmentName;
    }
    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }
    public String getDepartmentDesc(){
        return departmentDesc;
    }
    public void setDepartmentDesc(String departmentDesc){
        this.departmentDesc = departmentDesc;
    }


}












