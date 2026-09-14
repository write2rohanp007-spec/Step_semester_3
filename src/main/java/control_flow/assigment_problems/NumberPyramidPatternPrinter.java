package control_flow.assigment_problems;

/**
 * Category C - Level 3, Problem 1: Number Pyramid Pattern Printer
 */
public class NumberPyramidPatternPrinter {

    public static void printNumberPyramid(int n) {
        for (int row = 1; row <= n; row++) {
            StringBuilder line = new StringBuilder();
            for (int col = 1; col <= row; col++) {
                line.append(row);
                if (col < row) {
                    line.append(" ");
                }
            }
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        printNumberPyramid(4);
    }
}
