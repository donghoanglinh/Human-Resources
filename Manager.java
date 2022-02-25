// A class to represent manager
public class Manager extends Staff implements ICalculator{
    //field
    private String position;

    public Manager(String idStaff, String nameStaff, int age, double coefficientsSalary, String startDay, String department, int vacationDay, String position){
        super(idStaff, nameStaff, age, coefficientsSalary, startDay, department, vacationDay);
        this.position = position;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public String getPosition(){
        return position;
    }

    // method display information
    @Override
    public void displayInformation(){
        System.out.println("Staff ID: " + super.getIdStaff());
        System.out.println("Staff Name: " + super.getNameStaff());
        System.out.println("Age: " + super.getAge());
        System.out.println("Coefficients Salary: " + super.getCoefficientsSalary());
        System.out.println("Start Day: " + super.getStartDay());
        System.out.println("Department: " + super.getDepartment());
        System.out.println("Vacation Day: " + super.getVacationDay());
        System.out.println("Position: " + position);
    }

    // method calculate salary
    @Override
    public double calculateSalary(){
        return switch (position) {
            case "Business Leader" -> super.getCoefficientsSalary() * managerBaseSalary * businessLeader;
            case "Project Leader" -> super.getCoefficientsSalary() * managerBaseSalary * projectLeader;
            case "Technical Leader" -> super.getCoefficientsSalary() * managerBaseSalary * technicalLeader;
            default -> throw new IllegalStateException("Unexpected value: " + position);
        };
    }

}
