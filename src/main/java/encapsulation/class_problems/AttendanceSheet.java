package encapsulation.class_problems;

public class AttendanceSheet {
      private final String[] names;
      private int presentCount;

    public AttendanceSheet(int maxStudents) {
              names = new String[maxStudents];
              presentCount = 0;
    }

    public void markPresent(String name) {
              if (isPresent(name)) {
                            System.out.println(name + " is already marked present.");
                            return;
              }
              if (presentCount < names.length) {
                            names[presentCount++] = name;
              }
    }

    public boolean isPresent(String name) {
              for (int i = 0; i < presentCount; i++) {
                            if (names[i].equals(name)) return true;
              }
              return false;
    }

    public int getPresentCount() {
              return presentCount;
    }

    public static void main(String[] args) {
              AttendanceSheet sheet = new AttendanceSheet(30);
              sheet.markPresent("Alice");
              sheet.markPresent("Bob");
              sheet.markPresent("Alice");
              System.out.println("Present count: " + sheet.getPresentCount());
              System.out.println("Is Alice present? " + sheet.isPresent("Alice"));
              System.out.println("Is Charlie present? " + sheet.isPresent("Charlie"));
    }
}
