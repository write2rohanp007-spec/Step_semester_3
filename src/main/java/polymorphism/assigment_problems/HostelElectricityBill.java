package polymorphism.assigment_problems;

import java.util.*;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getType();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0;
    }

    @Override
    public String getType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }

    @Override
    public String getType() {
        return "SHARED";
    }
}

class AcRoom extends Room {
    public AcRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 10.0 + 200.0;
    }

    @Override
    public String getType() {
        return "AC";
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split(" ");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);

            if (type.equals("SINGLE")) rooms.add(new SingleRoom(units));
            else if (type.equals("SHARED")) rooms.add(new SharedRoom(units, Integer.parseInt(parts[2])));
            else rooms.add(new AcRoom(units));
        }

        double total = 0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", r.getType(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
