package datastructures.class_problems;

import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] tokens = line.replaceAll("[\\[\\],]", " ").trim().split("\\s+");
        int evenCount = 0;
        int oddCount = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            int num = Integer.parseInt(token);
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
    }
}
