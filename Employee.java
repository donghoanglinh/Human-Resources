// A class to represent employee
public class Employee extends Staff implements ICalculator {
    // field
    private int getHoursOver;

    public Employee(String idStaff, String name, int age, double coefficientsSalary, String startDay, String department, int vacationDay,int getHoursOver){
        super(idStaff, name, age, coefficientsSalary, startDay, department, vacationDay);
        this.getHoursOver = getHoursOver;
    }

    public void setGetHour(int getHoursOver){
        this.getHoursOver = getHoursOver;
    }

    public int getGetHour(int getHoursOver){
        return getHoursOver;
    }

    // display Information employee
    @Override
    public void displayInformation(){
        System.out.println("Staff ID: " + super.getIdStaff());
        System.out.println("Staff Name: " + super.getNameStaff());
        System.out.println("Age: " + super.getAge());
        System.out.println("Coefficients Salary: " + super.getCoefficientsSalary());
        System.out.println("Start Day: " + super.getStartDay());
        System.out.println("Department: " + super.getDepartment());
        System.out.println("Vacation Day: " + super.getVacationDay());
        System.out.println("Get Hour: " + getHoursOver);

    }

    // calculate Salary
    @Override
    public double calculateSalary(){
        return super.getCoefficientsSalary()*employeeBaseSalary + getHoursOver*getEmployeeHoursOverSalary;
    }
}
