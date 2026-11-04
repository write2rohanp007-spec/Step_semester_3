package sorting_algorithms.assigment_problems;

import java.util.Arrays;

public class DiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int roll : rolls) {
            count[roll]++;
        }

        StringBuilder sb = new StringBuilder("Counts: ");
        for (int v = 1; v <= 6; v++) {
            sb.append(v).append(":").append(count[v]);
            if (v < 6) sb.append("  ");
        }
        System.out.println(sb);

        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[index++] = v;
            }
        }

        System.out.println("Sorted: " + Arrays.toString(sorted));
        return sorted;
    }

    public static void main(String[] args) {
        int[] rolls1 = {4, 1, 6, 4, 2, 1, 4};
        diceSort(rolls1);

        int[] customRolls = {3, 5, 2, 6, 3, 1, 5, 2};
        diceSort(customRolls);
    }
}
