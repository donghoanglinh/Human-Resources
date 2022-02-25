// A class to represent Department in general
public class Department {
    private int departmentID;
    private String departmentName;
    private int totalStaff;

    public Department(int departmentID, String departmentName, int totalStaff){
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.totalStaff = totalStaff;
    }

    public void setDepartmentID(int departmentID){
        this.departmentID = departmentID;
    }

    public int getDepartmentID(){
        return departmentID;
    }

    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }

    public String getDepartmentName(){
        return departmentName;
    }

    public void setTotalStaff(int totalStaff){
        this.totalStaff = totalStaff;
    }

    public int getTotalStaff(){
        return totalStaff;
    }

    //method display information of department
    public String toString(){
        return "Department ID: " + departmentID + " | Department Name: " + departmentName + " | Total Staff: " + totalStaff;
    }
}
