package strings.assigment_problems;

/**
 * Week 2 Assignment - Problem 4: Library ISBN Normalizer & Validator
 */
public class LibraryIsbnNormalizerValidator {

    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }
        String publisherCode = trimmed.substring(0, 3).toUpperCase();
        return publisherCode + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        String publisherCode = code.substring(0, 3);
        for (int i = 0; i < publisherCode.length(); i++) {
            if (!Character.isLetter(publisherCode.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        String body = code.substring(3);
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: catalog body must be digits";
            }
        }

        String year = body.substring(0, 4);
        String catalog = body.substring(4);

        return "[" + publisherCode + "] YEAR: " + year + " | CATALOG: " + catalog;
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeCode(" pen2026004251 ")));
        System.out.println(validateAndFormat(normalizeCode("12N2026004251")));
    }
}
