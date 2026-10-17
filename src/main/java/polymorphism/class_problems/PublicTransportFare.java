package polymorphism.class_problems;

import java.util.*;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
    public abstract String getType();
}

class Bus extends Transport {
    public Bus(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return Math.min(2.0 + 0.10 * distance, 10.0);
    }

    @Override
    public String getType() {
        return "BUS";
    }
}

class Train extends Transport {
    public Train(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + 0.15 * distance;
    }

    @Override
    public String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }

    @Override
    public String getType() {
        return "METRO";
    }
}

public class PublicTransportFare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Transport> transports = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split(" ");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);

            if (type.equals("BUS")) transports.add(new Bus(distance));
            else if (type.equals("TRAIN")) transports.add(new Train(distance));
            else transports.add(new Metro(distance, Double.parseDouble(parts[2])));
        }

        double total = 0;
        for (Transport t : transports) {
            double fare = t.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f%n", t.getType(), fare);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
