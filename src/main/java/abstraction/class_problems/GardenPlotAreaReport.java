package abstraction.class_problems;

import java.util.Scanner;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double getArea();

    abstract String getShape();
}

class CirclePlot extends Plot {
    double radius;

    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }

    String getShape() {
        return "CIRCLE";
    }
}

class RectanglePlot extends Plot {
    double length;
    double width;

    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double getArea() {
        return length * width;
    }

    String getShape() {
        return "RECTANGLE";
    }
}

class TrianglePlot extends Plot {
    double base;
    double height;

    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double getArea() {
        return 0.5 * base * height;
    }

    String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Plot[] plots = new Plot[n];

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            if (shape.equals("CIRCLE")) {
                plots[i] = new CirclePlot(owner, sc.nextDouble());
            } else if (shape.equals("RECTANGLE")) {
                plots[i] = new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble());
            } else {
                plots[i] = new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble());
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double area = plots[i].getArea();
            total = total + area;
            System.out.printf("%s (%s): %.2f%n", plots[i].owner, plots[i].getShape(), area);
        }
        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}
