package arrays_and_methods.class_problems;

import java.util.Arrays;

/**
 * Category C Practice - Problem 1 (Easy): Hackathon Score Curve Booster
 */
public class HackathonScoreCurveBooster {

    public static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
        System.out.println(Arrays.toString(scores));
    }
}
