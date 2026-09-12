package fundamentals.class_problems;

/**
 * Day 1 Live-Coding Session - Problem 4: First Non-Repeating Character
 */
public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0';
    }

    private static void report(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result == '\0') {
            System.out.println("\"" + text + "\" -> No Non-Repeating Character Found");
        } else {
            System.out.println("\"" + text + "\" -> First Non-Repeating Character: '" + result + "'");
        }
    }

    public static void main(String[] args) {
        report("swiss");
        report("aabbcc");
    }
}
