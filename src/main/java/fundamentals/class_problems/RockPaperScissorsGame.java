package fundamentals.class_problems;

import java.util.Random;

/**
 * Day 1 Live-Coding Session - Problem 1: Rock-Paper-Scissors Game
 */
public class RockPaperScissorsGame {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        boolean playerWins =
                (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"));
        return playerWins ? "Player Wins" : "Computer Wins";
    }

    public static void main(String[] args) {
        int rounds = 5;
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        Random random = new Random();

        int wins = 0, losses = 0, draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < rounds; i++) {
            String computerMove = MOVES[random.nextInt(MOVES.length)];
            String result = playRound(playerMoves[i], computerMove);

            System.out.printf("%5d | %11s | %13s | %s%n",
                    i + 1, playerMoves[i], computerMove, result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage = (wins * 100.0) / rounds;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);

        System.out.println();
        System.out.println("Sample checks:");
        System.out.println("Rock vs Scissors -> " + playRound("Rock", "Scissors"));
        System.out.println("Paper vs Paper -> " + playRound("Paper", "Paper"));
        System.out.println("Scissors vs Rock -> " + playRound("Scissors", "Rock"));
    }
}
