package sorting_algorithms.assigment_problems;

public class IsQueueInOrder {

    public static int firstBreak(int[] tokens) {
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] tokens1 = {3, 5, 5, 8, 6, 9};
        int[] tokens2 = {1, 2, 2, 7};

        System.out.println(firstBreak(tokens1));
        System.out.println(firstBreak(tokens2));

        int[] customTokens = {10, 20, 15, 30, 25};
        System.out.println(firstBreak(customTokens));
    }
}
