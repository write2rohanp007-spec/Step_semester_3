package arrays_and_methods.assigment_problems;

import java.util.Arrays;

/**
 * Category C Assignment - Problem 1 (Easy): Fantasy Team Score Multiplier
 */
public class FantasyTeamScoreMultiplier {

    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));
    }
}
