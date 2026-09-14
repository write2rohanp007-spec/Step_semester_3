package strings.class_problems;

/**
 * Day 2 Live-Coding Session - Problem 4: Masked Phone Number Formatter
 */
public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder masked = new StringBuilder();
        masked.append("XXXXXX");
        masked.insert(masked.length(), "-");
        masked.append(phone.substring(6));

        return masked.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }
}
