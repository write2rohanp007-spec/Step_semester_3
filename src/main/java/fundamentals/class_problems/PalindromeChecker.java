package fundamentals.class_problems;

/**
 * Day 1 Live-Coding Session - Problem 2: Palindrome Checker (3 Approaches)
 */
public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursiveHelper(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursiveHelper(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return isPalindromeRecursiveHelper(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return new String(original).equals(new String(reversed));
    }

    private static void checkText(String text) {
        System.out.printf("\"%s\" -> Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                text,
                isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome",
                isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome",
                isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome");
    }

    public static void main(String[] args) {
        checkText("madam");
        checkText("hello");
    }
}
