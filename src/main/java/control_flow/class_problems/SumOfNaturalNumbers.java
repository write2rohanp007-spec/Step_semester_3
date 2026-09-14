package control_flow.class_problems;

public class SumOfNaturalNumbers {

    void sumOfNaturalNumbers(int n) {
        int total = 0;
        int counter = 1;
        while (counter <= n) {
            total += counter;
            counter++;
        }
        System.out.println("Sum of numbers from 1 to " + n + " = " + total);
    }

    public static void main(String[] args) {
        new SumOfNaturalNumbers().sumOfNaturalNumbers(5);
    }
}
