
// A class to represent Staff in general
public abstract class Staff {
    private String idStaff;
    private String nameStaff;
    private int age;
    private double coefficientsSalary;
    private String startDay;
    private String department;
    private int vacationDay;
    private double salary;

    // constructor
    public Staff(String idStaff, String nameStaff, int age, double coefficientsSalary, String startDay, String department, int vacationDay){
        this.idStaff = idStaff;
        this.nameStaff = nameStaff;
        this.age = age;
        this.coefficientsSalary =  coefficientsSalary;
        this.startDay = startDay;
        this.department = department;
        this.vacationDay = vacationDay;
    }

    public void setIdStaff(String idStaff){
        this.idStaff = idStaff;
    }

    public String getIdStaff(){
        return idStaff;
    }

    public void setNameStaff(String nameStaff){
        this.nameStaff = nameStaff;
    }

    public String getNameStaff(){
        return nameStaff;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setCoefficientsSalary(double coefficientsSalary){
        this.coefficientsSalary = coefficientsSalary;
    }

    public double getCoefficientsSalary(){
        return coefficientsSalary;
    }

    public void setStartDay(String startDay){
        this.startDay = startDay;
    }

    public String getStartDay(){
        return startDay;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public String getDepartment(){
        return department;
    }

    public void setVacationDay(int vacationDay){
        this.vacationDay = vacationDay;
    }

    public int getVacationDay() {
        return vacationDay;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public double getSalary(){
        return this.salary;
    }

    //abstract display information
    public abstract void displayInformation();

}
