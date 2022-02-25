//interface calculator of employee and manager
public interface ICalculator {
    int businessLeader = 8000000;
    int projectLeader = 5000000;
    int technicalLeader = 6000000;
    int employeeBaseSalary = 3000000;
    int managerBaseSalary = 5000000;
    int getEmployeeHoursOverSalary = 200000;

    double calculateSalary();
}
