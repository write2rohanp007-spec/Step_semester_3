package abstraction.class_problems;

import java.util.Scanner;

abstract class Connection {
    double units;

    Connection(double units) {
        this.units = units;
    }

    abstract double getBill();

    abstract String getType();
}

class HomeConnection extends Connection {
    HomeConnection(double units) {
        super(units);
    }

    double getBill() {
        if (units <= 100) {
            return units * 5;
        }
        return 100 * 5 + (units - 100) * 7;
    }

    String getType() {
        return "HOME";
    }
}

class ShopConnection extends Connection {
    ShopConnection(double units) {
        super(units);
    }

    double getBill() {
        return units * 8 + 100;
    }

    String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends Connection {
    FactoryConnection(double units) {
        super(units);
    }

    double getBill() {
        double bill = units * 6;
        if (bill < 1000) {
            bill = 1000;
        }
        return bill;
    }

    String getType() {
        return "FACTORY";
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Connection[] connections = new Connection[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            if (type.equals("HOME")) {
                connections[i] = new HomeConnection(units);
            } else if (type.equals("SHOP")) {
                connections[i] = new ShopConnection(units);
            } else {
                connections[i] = new FactoryConnection(units);
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double bill = connections[i].getBill();
            total = total + bill;
            System.out.printf("%s: %.2f%n", connections[i].getType(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
