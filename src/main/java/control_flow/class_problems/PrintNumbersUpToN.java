package control_flow.class_problems;

public class PrintNumbersUpToN {

    void printNumbersUpToN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new PrintNumbersUpToN().printNumbersUpToN(5);
    }
}
