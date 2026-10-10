package datastructures.class_problems;

import java.util.Scanner;

public class DigitSumNumberReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine().trim());
        int original = number;
        int sum = 0;
        int reversed = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
    }
}
