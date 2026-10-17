package polymorphism.assigment_problems;

import java.util.*;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public abstract double calculateBonus();

    public String getName() {
        return name;
    }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class Intern extends Employee {
    public Intern(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000.0;
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split(" ");
            String type = parts[0];
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);

            if (type.equals("FULLTIME")) employees.add(new FullTimeEmployee(name, salary));
            else if (type.equals("PARTTIME")) employees.add(new PartTimeEmployee(name, salary));
            else employees.add(new Intern(name, salary));
        }

        double total = 0;
        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            total += bonus;
            System.out.printf("%s: %.2f%n", e.getName(), bonus);
        }
        System.out.printf("Total Bonus: %.2f%n", total);
        scanner.close();
    }
}
