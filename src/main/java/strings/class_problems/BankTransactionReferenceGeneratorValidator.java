package strings.class_problems;

/**
 * Day 2 Live-Coding Session - Problem 5: Bank Transaction Reference Generator & Validator
 */
public class BankTransactionReferenceGeneratorValidator {

    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        return bankCode + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        String bankCode = reference.substring(0, 3);
        for (int i = 0; i < bankCode.length(); i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        String body = reference.substring(3);
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: reference body must be digits";
            }
        }

        String datePart = body.substring(0, 6);
        String seqPart = body.substring(6);

        StringBuilder result = new StringBuilder();
        result.append("[").append(bankCode).append("] DATE: ")
                .append(datePart, 0, 2).append("/")
                .append(datePart, 2, 4).append("/")
                .append(datePart, 4, 6)
                .append(" | SEQ: ").append(seqPart);

        return result.toString();
    }

    public static void main(String[] args) {
        String normalized1 = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(normalized1));

        System.out.println(validateAndFormat("12F03022600042"));
    }
}
