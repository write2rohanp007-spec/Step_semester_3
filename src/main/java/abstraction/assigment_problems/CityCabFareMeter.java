package abstraction.assigment_problems;

import java.util.Scanner;

interface NightService {
    double getNightFare(double fare);
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    abstract String getName();

    double getFare() {
        double fare = km * getRate();
        if (fare < 100) {
            fare = 100;
        }
        return fare;
    }
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }

    String getName() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    String getName() {
        return "SEDAN";
    }

    public double getNightFare(double fare) {
        return fare * 1.2;
    }
}

class SuvCab extends Cab implements NightService {
    SuvCab(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    String getName() {
        return "SUV";
    }

    public double getNightFare(double fare) {
        return fare * 1.2;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab cab;
            if (type.equals("MINI")) {
                cab = new MiniCab(km);
            } else if (type.equals("SEDAN")) {
                cab = new SedanCab(km);
            } else {
                cab = new SuvCab(km);
            }

            double fare = cab.getFare();
            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    NightService ns = (NightService) cab;
                    fare = ns.getNightFare(fare);
                } else {
                    System.out.println(cab.getName() + ": night service not available");
                    continue;
                }
            }
            total = total + fare;
            System.out.printf("%s: %.2f%n", cab.getName(), fare);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
