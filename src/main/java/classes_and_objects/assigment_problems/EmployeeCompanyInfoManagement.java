package classes_and_objects.assigment_problems;

/**
 * Category C Assignment - Problem M5: Employee and Company Information Management
 */
public class EmployeeCompanyInfoManagement {

    static class Employee {
        String empName;
        double salary;

        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        new Employee("Divya", 65000);
        new Employee("Arjun", 40000);
        new Employee("Kabir", 55000);

        Employee.printCompanyInfo();
    }
}
