package encapsulation.class_problems;

public class Locker {
      private final int lockerNumber;
      private String combination;

    public Locker(int lockerNumber, String combination) {
              this.lockerNumber = lockerNumber;
              this.combination = combination;
    }

    public boolean changeCode(String oldCode, String newCode) {
              if (!combination.equals(oldCode)) {
                            System.out.println("Rejected: incorrect old combination.");
                            return false;
              }
              combination = newCode;
              return true;
    }

    public int getLockerNumber() {
              return lockerNumber;
    }

    public static void main(String[] args) {
              Locker locker = new Locker(42, "1234");
              System.out.println("Locker number: " + locker.getLockerNumber());
              System.out.println("changeCode(\"wrong\", \"5678\"): " + locker.changeCode("wrong", "5678"));
              System.out.println("changeCode(\"1234\", \"5678\"): " + locker.changeCode("1234", "5678"));
              System.out.println("changeCode(\"5678\", \"9999\"): " + locker.changeCode("5678", "9999"));
    }
}
