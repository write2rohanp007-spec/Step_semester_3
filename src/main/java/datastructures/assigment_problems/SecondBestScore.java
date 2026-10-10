package datastructures.assigment_problems;

public class SecondBestScore {
    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;
        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[][] samples = {
            {45, 78, 92, 78, 60},
            {50, 50, 50}
        };
        for (int[] scores : samples) {
            System.out.println(secondHighest(scores));
        }
    }
}
