import java.util.Random;

/**
 * Week 1 Practice 1 - Rock-Paper-Scissors Game (The College Coding Arcade)
 * Plays N rounds between the player and a random computer move and prints a scoreboard.
 */
public class P1_RockPaperScissors {

    static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    // Returns "Player Wins", "Computer Wins" or "Draw" for one round
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        boolean playerWins =
                (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors"))
                || (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock"))
                || (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"));
        return playerWins ? "Player Wins" : "Computer Wins";
    }

    static String generateComputerMove(Random random) {
        return MOVES[random.nextInt(MOVES.length)];
    }

    public static void main(String[] args) {
        final int rounds = 5;
        // Predefined player moves for a live demo
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];
        Random random = new Random();

        int wins = 0, losses = 0, draws = 0;
        for (int i = 0; i < rounds; i++) {
            computerMoves[i] = generateComputerMove(random);
            results[i] = playRound(playerMoves[i], computerMoves[i]);
            System.out.println("Round " + (i + 1) + " - Player: " + playerMoves[i]
                    + ", Computer: " + computerMoves[i] + " -> " + results[i]);
            if (results[i].equals("Player Wins")) wins++;
            else if (results[i].equals("Computer Wins")) losses++;
            else draws++;
        }

        System.out.println();
        System.out.printf("%-6s | %-11s | %-13s | %s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-------+-------------+---------------+--------------");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-6d | %-11s | %-13s | %s%n", i + 1, playerMoves[i], computerMoves[i], results[i]);
        }
        double winPercentage = (wins * 100.0) / rounds;
        System.out.println();
        System.out.printf("Final Summary (after %d rounds) Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                rounds, wins, losses, draws, winPercentage);
    }
}
