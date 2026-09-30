package polymorphism.assigment_problems;

import java.util.*;

abstract class Customer {
    protected double billAmount;

    public Customer(double billAmount) {
        this.billAmount = billAmount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getType();
}

class Student extends Customer {
    public Student(double billAmount) {
        super(billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return billAmount * 0.90;
    }

    @Override
    public String getType() {
        return "STUDENT";
    }
}

class Staff extends Customer {
    public Staff(double billAmount) {
        super(billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return billAmount * 0.95;
    }

    @Override
    public String getType() {
        return "STAFF";
    }
}

class Guest extends Customer {
    public Guest(double billAmount) {
        super(billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return billAmount + 10;
    }

    @Override
    public String getType() {
        return "GUEST";
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split(" ");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            if (type.equals("STUDENT")) customers.add(new Student(amount));
            else if (type.equals("STAFF")) customers.add(new Staff(amount));
            else customers.add(new Guest(amount));
        }

        double total = 0;
        for (Customer c : customers) {
            double finalAmount = c.calculateFinalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f%n", c.getType(), finalAmount);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
