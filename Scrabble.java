package myProject;

// this application mimics a simple Scrabble game, taking input from two players and computing the scores for each word. 
import java.util.Scanner;

public class Scrabble {

	static final int POINTS[] = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 }; // array storing the point values of each letter
	static int totalScore1 = 0;
	static int totalScore2 = 0;
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int command;
		while (true) {
			System.out.println("MENU\n1.New game\n2.Show Scores\n3.Exit");
			System.out.print("Choose your option: ");

			// check if the input is a valid integer, else terminate
			if (s.hasNextInt()) {
				command = s.nextInt();
			} else {
				System.out.println("Invalid input. Program ended.");
				return;
			}

			switch (command) {
			case 1:
				System.out.print("Input player 1: ");
				String player1 = s.next();
				s.nextLine();
				System.out.print("Input player 2: ");
				String player2 = s.next();

				int score1 = getScore(player1);
				totalScore1 += score1;
				int score2 = getScore(player2);
				totalScore2 += score2;
				System.out.println("Player 1 score: " + score1);
				System.out.println("Player 2 score: " + score2);
				break;
			case 2:
				System.out.println("Total score for player 1: " + totalScore1);
				System.out.println("Total score for player 2: " + totalScore2);
				break;
			case 3:
				System.out.println("Game over");
				if (totalScore1 == totalScore2) {
					System.out.println("Tie!");
				} else if (totalScore1 >= totalScore2) {
					System.out.println("Player 1 wins with " + totalScore1 + " points to " + totalScore2 + " points");
				} else {
					System.out.println("Player 2 wins with " + totalScore2 + " points to " + totalScore1 + " points");
				}
				return;
			default:
				System.out.println("Option unavailable");
				break;
			}
		}
	}

	private static int getScore(String word) {
		int score = 0;
		for (int i = 0; i < word.length(); i++) {
			char letter = Character.toLowerCase(word.charAt(i)); // uppercase and lowercase letters have the same scores
			if (letter >= 'a' && letter <= 'z') {
				score += POINTS[letter - 'a'];
			}
		}
		return score;
	}
}
