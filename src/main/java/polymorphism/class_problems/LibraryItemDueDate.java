package polymorphism.class_problems;

import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    protected String title;
    private static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract int getBorrowingDays();

    public LocalDate getDueDate() {
        return CURRENT_DATE.plusDays(getBorrowingDays());
    }

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 14;
    }
}

class Dvd extends LibraryItem {
    public Dvd(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 3;
    }
}

public class LibraryItemDueDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            int spaceIdx = line.indexOf(' ');
            String type = line.substring(0, spaceIdx);
            String title = line.substring(spaceIdx + 1).replaceAll("^\"|\"$", "");

            if (type.equals("BOOK")) items.add(new Book(title));
            else if (type.equals("DVD")) items.add(new Dvd(title));
            else items.add(new Magazine(title));
        }

        for (LibraryItem item : items) {
            System.out.printf("%s: %s%n", item.getTitle(), item.getDueDate());
        }
        scanner.close();
    }
}
