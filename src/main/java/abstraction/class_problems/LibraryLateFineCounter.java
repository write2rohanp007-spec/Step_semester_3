package abstraction.class_problems;

import java.util.Scanner;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double getFine();
}

class Book extends LibraryItem {
    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    double getFine() {
        return daysLate * 2;
    }
}

class Dvd extends LibraryItem {
    Dvd(String title, int daysLate) {
        super(title, daysLate);
    }

    double getFine() {
        double fine = daysLate * 5;
        if (fine > 50) {
            fine = 50;
        }
        return fine;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double getFine() {
        return daysLate * 1;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();
            if (type.equals("BOOK")) {
                items[i] = new Book(title, days);
            } else if (type.equals("DVD")) {
                items[i] = new Dvd(title, days);
            } else {
                items[i] = new Magazine(title, days);
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double fine = items[i].getFine();
            total = total + fine;
            System.out.printf("%s: %.2f%n", items[i].title, fine);
        }
        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}
