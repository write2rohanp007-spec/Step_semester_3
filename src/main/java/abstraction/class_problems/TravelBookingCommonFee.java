package abstraction.class_problems;

import java.util.Scanner;

abstract class Booking {
    static final double BOOKING_FEE = 50;
    double distance;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double getFare();

    abstract String getMode();

    double getTotal() {
        return getFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    BusBooking(double distance) {
        super(distance);
    }

    double getFare() {
        return distance * 2;
    }

    String getMode() {
        return "BUS";
    }
}

class TrainBooking extends Booking {
    TrainBooking(double distance) {
        super(distance);
    }

    double getFare() {
        return distance * 1.5;
    }

    String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends Booking {
    FlightBooking(double distance) {
        super(distance);
    }

    double getFare() {
        return 2500 + distance * 4;
    }

    String getMode() {
        return "FLIGHT";
    }
}

public class TravelBookingCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Booking booking;
            if (mode.equals("BUS")) {
                booking = new BusBooking(distance);
            } else if (mode.equals("TRAIN")) {
                booking = new TrainBooking(distance);
            } else {
                booking = new FlightBooking(distance);
            }
            System.out.printf("%s: %.2f%n", booking.getMode(), booking.getTotal());
        }
        sc.close();
    }
}
