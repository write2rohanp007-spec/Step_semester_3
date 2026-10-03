package abstraction.assigment_problems;

import java.util.Scanner;

interface SaverMode {
    double getSaverUnits(double units);
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    abstract String getName();

    double getUnits() {
        return getPower() * hours / 1000;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }

    String getName() {
        return "FRIDGE";
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    String getName() {
        return "AC";
    }

    public double getSaverUnits(double units) {
        return units * 0.75;
    }
}

class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }

    String getName() {
        return "TV";
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    String getName() {
        return "WASHER";
    }

    public double getSaverUnits(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equals("SAVER");

            Appliance appliance;
            if (type.equals("FRIDGE")) {
                appliance = new Fridge(hours);
            } else if (type.equals("AC")) {
                appliance = new AirConditioner(hours);
            } else if (type.equals("TV")) {
                appliance = new Television(hours);
            } else {
                appliance = new WashingMachine(hours);
            }

            double units = appliance.getUnits();
            if (saver) {
                if (appliance instanceof SaverMode) {
                    SaverMode sm = (SaverMode) appliance;
                    units = sm.getSaverUnits(units);
                } else {
                    System.out.println(appliance.getName() + ": saver mode not supported");
                    continue;
                }
            }
            double cost = units * 8;
            totalCost = totalCost + cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.getName(), units, cost);
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
