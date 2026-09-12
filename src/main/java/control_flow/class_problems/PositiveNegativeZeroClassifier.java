package control_flow.class_problems;

/**
 * Category C - Level 1, Problem 2: Positive, Negative, or Zero Classifier
 */
public class PositiveNegativeZeroClassifier {

    public static void classifyNumber(int number) {
        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
    }

    public static void main(String[] args) {
        classifyNumber(15);
        classifyNumber(-4);
        classifyNumber(0);
    }
}
