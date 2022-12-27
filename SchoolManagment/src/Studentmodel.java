public class Studentmodel{
    String departmentName;
    int studentId;
    String studentName;
    String studentNumber;
    int departmentId;

    public Studentmodel(String departmentName, int studentId, String studentName, String studentNumber, int departmentId) {
        this.departmentName = departmentName;
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.departmentId = departmentId;
    }

    public int getDepartmentId(){
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getStudentId(){
        return studentId;
    }
    public String getStudentName(){
        return studentName;
    }
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    public String getStudentNumber(){
        return studentNumber;
    }
    public  void setStudentNumber(String studentNumber){
        this.studentNumber = studentNumber;
    }

}
