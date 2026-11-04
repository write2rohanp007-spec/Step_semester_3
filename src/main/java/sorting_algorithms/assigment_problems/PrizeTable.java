package sorting_algorithms.assigment_problems;

import java.util.Arrays;

public class PrizeTable {

    public static int prizeTable(int[] marks) {
        int swaps = 0;
        int n = marks.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swaps++;
            }
        }

        System.out.println(Arrays.toString(marks) + "  swaps = " + swaps);
        return swaps;
    }

    public static void main(String[] args) {
        int[] marks1 = {45, 90, 60, 75};
        prizeTable(marks1);

        int[] marks2 = {80, 70, 60};
        prizeTable(marks2);

        int[] customMarks = {55, 30, 90, 75, 60};
        prizeTable(customMarks);
    }
}
