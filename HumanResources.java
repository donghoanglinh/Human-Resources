/* Function of program
1. display employees in company
2. display departments in company
3. display employees follow department
4. add new employee to company (2 employee type: normal and manager - have position)
5. search employee information follow name or id
6. display salary table of all employee
7. display salary follow increasing
*/

/* input
id, name, age, coefficients salary, starting day, department, position, HoursOver
 */

import java.util.ArrayList;
import java.util.Scanner;

public class HumanResources {
    //method scanner
    public static final Scanner sc = new Scanner(System.in);

    public static String[] POSITION = new String[]{"Business Leader","Project Leader","Technical Leader"};

    //main method
    public static void main(String[] args) {

        // create list of employee in company
        ArrayList<Staff> employeeList = new ArrayList<>();

        //some example for List employee
        employeeList.add(new Employee("1", "Nguyen Van Quang", 25, 1.3, "23/02/2021", "Kho", 3, 2));
        employeeList.add(new Employee("2", "Tran Vien Dong", 30, 2.1, "02/05/2005", "Boc Do", 2, 1));
        employeeList.add(new Manager("3", "Ly Thong", 32, 1.0, "12/02/2000", "Ke Toan", 5, "Business Leader"));
        employeeList.add(new Employee("4", "Thanh Mac", 20, 1.2, "05/8/2019", "Thu Ngan", 3, 4));
        employeeList.add(new Manager("5", "Dien Gia", 40, 1.0, "21/03/1999", "Ke Toan", 5, "Project Leader"));

        // create list of department in company
        ArrayList<Department> departmentList = new ArrayList<>();

        //some example for List department
        departmentList.add(new Department(1, "Ke Toan", 2));
        departmentList.add(new Department(2, "Thu Ngan", 1));
        departmentList.add(new Department(3, "Kho", 1));
        departmentList.add(new Department(4, "Boc Do", 1));

        // calculate staff salary for example
        addSalary(employeeList);

        // input option user want
        String answer;
        do {
            showMenu();

            // user choose option
            int choice;
            do {
                choice = sc.nextInt();

                // Display employees in company
                if (choice == 1) {
                    displayEmployee(employeeList);
                }

                // Display departments in company
                if (choice == 2) {
                    displayDepartment(departmentList);
                }

                // display employee follow department
                if (choice == 3) {
                    displayEmployeeFollowDepartment(employeeList, departmentList);
                }

                // add employee
                if (choice == 4) {
                    addEmployee(employeeList, departmentList);
                }

                // remove employee
                if (choice == 5) {
                    removeEmployee(employeeList, departmentList);
                }

                // search information employee
                if (choice == 6) {
                    searchEmployeeInformation(employeeList);
                }

                // display salary table
                if (choice == 7) {
                    displaySalaryTable(employeeList);
                }

                // display increasing salary table
                if (choice == 8) {
                    displayIncreasingSalaryTable(employeeList);
                    displaySalaryTable(employeeList);
                }

                // display decreasing salary table
                if (choice == 9) {
                    displayDecreasingSalaryTable(employeeList);
                    displaySalaryTable(employeeList);
                }
            } while (choice < 1 || choice > 9);

            addSalary(employeeList);

            System.out.println();

            // ask turn back main menu or not
            do {
            System.out.print("Do you want to turn back main menu or exit (Y/N)");
            answer = sc.next();
            }
            while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"));
        } while (answer.equalsIgnoreCase("y"));
    }

    // display menu
    public static void showMenu() {
        System.out.println("             HUMAN RESOURCE OF COMPANY");
        System.out.println("-------please choose function which you want-------");
        System.out.println("| 1. Display employees in company                 |");
        System.out.println("| 2. Display departments in company               |");
        System.out.println("| 3. Display employees follow department          |");
        System.out.println("| 4. Add new employee                             |");
        System.out.println("| 5. Remove employee                              |");
        System.out.println("| 6. Search employee information                  |");
        System.out.println("| 7. Display salary table of all employee         |");
        System.out.println("| 8. Display salary table follow Increasing order |");
        System.out.println("| 9. Display salary table follow Decreasing order |");
        System.out.println("---------------------------------------------------");
    }

    /* display employee - choice = 1;
    input employeeList */
    public static void displayEmployee(ArrayList<Staff> list) {
        System.out.println("LIST OF EMPLOYEE IN COMPANY");
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("STAFF " + (i+1) + ":");
            list.get(i).displayInformation();
            System.out.println();
        }
    }

    /* display department - choice = 2
    input departmentList */
    public static void displayDepartment(ArrayList<Department> list) {
        System.out.println("LIST OF DEPARTMENT IN COMPANY");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    /* display employee follow department - choice = 3
    input employeeList and departmentList */
    public static void displayEmployeeFollowDepartment(ArrayList<Staff> listS, ArrayList<Department> listD) {
        int number;
        do {
        System.out.println("Choose which department you want to display employee (1-" + listD.size() + ") ");
        for (int i = 0; i < listD.size(); i++) {
            System.out.println((i +1) + ". " + listD.get(i).getDepartmentName());
        }
        number = sc.nextInt();
        } while(number < 1 || number > listD.size());
        System.out.println("Employee of " + listD.get(number -1 ).getDepartmentName() + " Department List:");
        int count = 0;
        for (Staff list : listS) {
            if (list.getDepartment().equals(listD.get(number - 1).getDepartmentName())) {
                System.out.println();
                count += 1;
                System.out.println("STAFF " + (count) + " :");
                list.displayInformation();
                System.out.println();
            }
        }
    }

    /* add staff - choice = 4
       input employeeList, departmentList */
    public static void addEmployee(ArrayList<Staff> listS, ArrayList<Department> listD) {
        System.out.println("ADD STAFF");
        String askAgain;
        do {
            int number;
            do {
                System.out.println("Do you want add employee or manager (1 or 2) \n1. Employee \n2. Manager");
                number = sc.nextInt();
                sc.nextLine();
            } while (number != 1 && number != 2);

            System.out.print("input Staff Name: ");
            String name = sc.nextLine();

            System.out.print("input Staff Age: ");
            int age = sc.nextInt();

            System.out.print("input Staff Coefficients Salary: ");
            double coefficientsSalary = sc.nextDouble();

            System.out.print("input Staff starting day (dd-mm-yyy): ");
            String startDay = sc.next();
            System.out.println();

            int num;
            do {
                System.out.println("Choose Staff Department (1-" + listD.size() + "): ");
                for (int i = 0; i < listD.size(); i++) {
                    System.out.println((i + 1) + ". " + listD.get(i).getDepartmentName());
                }
                num = sc.nextInt();
            } while (num < 1 || num > listD.size());
            String department = listD.get(num - 1).getDepartmentName();

            System.out.print("input Staff Vacation Day: ");
            int vacationDay = sc.nextInt();
            System.out.println();

            System.out.println("System auto choice ID for new staff");
            String id = listS.size() + name.substring(0, 2) + startDay.substring(0, 2);
            System.out.println("ID for new Staff is: " + id);
            System.out.println();

            if (number == 1) {
                System.out.print("input Hours Over of employee: ");
                int getHoursOver = sc.nextInt();
                listS.add(new Employee(id, name, age, coefficientsSalary, startDay, department, vacationDay, getHoursOver));
            } else {
                int choice;
                do {
                    System.out.println("Choose employee position (1-" + POSITION.length + "): ");
                    for (int i = 0; i < POSITION.length; i++) {
                        System.out.println((i + 1) + ". " + POSITION[i]);
                    }
                    choice = sc.nextInt();
                } while (choice < 1 || choice > POSITION.length);

                String position = POSITION[choice - 1];

                listS.add(new Manager(id, name, age, coefficientsSalary, startDay, department, vacationDay, position));
            }
            for (Department value : listD) {
                if (value.getDepartmentName().equals(department)) {
                    value.setTotalStaff(value.getTotalStaff() + 1);
                }
            }
            System.out.print("Add new staff successfully");
            System.out.println();
            System.out.println("Do you want to add staff again (Y/N)? ");
            askAgain = sc.next();
        } while (askAgain.equalsIgnoreCase("y"));
    }

    /* remove employee - choice = 5
    input employeeList, departmentList */
    public static void removeEmployee(ArrayList<Staff> listS, ArrayList<Department> listD) {
        String search;
        do {
            System.out.print("What employee ID do you want to remove: ");

            String id = sc.next();
            boolean have = false;
            for (int i = 0; i < listS.size(); i++) {
                if (listS.get(i).getIdStaff().equals(id)) {
                    String department = listS.get(i).getDepartment();
                    listS.remove(i);
                    for (Department value : listD) {
                        if (value.getDepartmentName().equals(department)) {
                            value.setTotalStaff(value.getTotalStaff() - 1);
                        }
                    }
                    have = true;
                }
            }
            if (!have) System.out.print("No have data");
            System.out.println("Remove successfully");
            System.out.println();
            System.out.println("Do you want to removing again (Y/N)");
            search = sc.next();
        } while (search.equalsIgnoreCase("y"));
    }

    /* search information of employee - choice = 6
    input employee */
    public static void searchEmployeeInformation(ArrayList<Staff> listS) {
        String search;
        do {
            do {
                System.out.print("Do you want to search employee information follow (ID or Name) ? ");
                search = sc.next();

            } while (!search.equalsIgnoreCase("id") && !search.equalsIgnoreCase("name"));
            if (search.equalsIgnoreCase("id")) {
                System.out.print("Please input ID of employee that you want to search: ");

                String id = sc.next();

                boolean have =  false;
                for (Staff list : listS) {
                    if (list.getIdStaff().equals(id)) {
                        System.out.println();
                        list.displayInformation();
                        have = true;
                    }
                }
                if (!have) System.out.print("No have data");
            } else {
                sc.nextLine();
                System.out.print("Please input name of employee that you want to search: ");
                String name = sc.nextLine();
                boolean have = false;
                for (Staff list : listS) {
                    if (list.getNameStaff().equals(name)) {
                        System.out.println();
                        list.displayInformation();
                        have = true;
                    }
                }
                if (!have) System.out.print("No have data");
            }
            System.out.println();

            do {
                System.out.print("Do you want to searching again (Y/N)");
                search = sc.next();
            } while(!search.equalsIgnoreCase("y") && !search.equalsIgnoreCase("n"));
        } while (search.equalsIgnoreCase("y"));
    }

    /* calculate and add salary field to employee
    input employeeList */
    public static void addSalary(ArrayList<Staff> listS) {
        for (Staff list : listS) {
            double salary = 0;
            if (list instanceof Employee) {
                salary = ((Employee) list).calculateSalary();
            } else if (list instanceof Manager) {
                salary = ((Manager) list).calculateSalary();
            }
            list.setSalary(salary);
        }
    }

    /* display salary table - choice = 7
    input employeeList */
    public static void displaySalaryTable(ArrayList<Staff> listS) {
        System.out.println("List of employee salary");
        for (int i = 0; i < listS.size(); i++) {
            System.out.print((i + 1) + ". " + listS.get(i).getNameStaff() + " | " + listS.get(i).getDepartment() + " | " + listS.get(i).getSalary());
            System.out.println();
        }
    }

    /* display salary table follow increasing - choice = 8
     input employeeList */
    public static void displayIncreasingSalaryTable(ArrayList < Staff > listS) {
        for(int i = 0; i < listS.size(); i++){
            for (int j = 0; j < (listS.size() - 1) ; j++) {
                Staff m;
                if (listS.get(j).getSalary() > listS.get(j + 1).getSalary()) {
                    m = listS.get(j);
                    listS.set(j, listS.get(j+1));
                    listS.set(j+1, m);
                }
            }
        }
    }

    /* display salary table follow increasing - choice = 9
    input employeeList */
    public static void displayDecreasingSalaryTable(ArrayList < Staff > listS) {
        for(int i = 0; i < listS.size(); i++){
            for (int j = 0; j < listS.size() - 1 ; j++) {
                Staff m;
                if (listS.get(j).getSalary() < listS.get(j + 1).getSalary()) {
                    m = listS.get(j);
                    listS.set(j, listS.get(j+1));
                    listS.set((j+1), m);
                }
            }
        }
    }
}
