package abstraction.assigment_problems;

import java.util.Scanner;

interface BusUser {
    double TRANSPORT_FEE = 12000;
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double getTuition();

    double getTotalFee() {
        double fee = getTuition();
        if (this instanceof BusUser) {
            fee = fee + BusUser.TRANSPORT_FEE;
        }
        return fee;
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double getTuition() {
        return 40000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double getTuition() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends Student implements BusUser {
    ScholarshipStudent(String name) {
        super(name);
    }

    double getTuition() {
        return 40000 / 2;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student student;
            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new ScholarshipStudent(name);
            }
            double fee = student.getTotalFee();
            total = total + fee;
            System.out.printf("%s: %.2f%n", student.name, fee);
        }
        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
