package datastructures.class_problems;

import java.util.Scanner;

public class WordReverserPalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String word = sc.nextLine().trim();
            if (word.isEmpty()) {
                continue;
            }
            StringBuilder sb = new StringBuilder(word);
            String reversed = sb.reverse().toString();
            boolean isPalindrome = word.equalsIgnoreCase(reversed);
            System.out.println(reversed + " - " + (isPalindrome ? "palindrome" : "not a palindrome"));
        }
    }
}
