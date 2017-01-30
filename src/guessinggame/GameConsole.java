package guessinggame;

import java.util.Scanner;

/**
 * GameConsole of the guessing game is used to interact between user and game
 * control.
 * 
 * @author Vittunyuta Maeprasart
 *
 */

public class GameConsole {
	private String title;
	private String prompt;

	/**
	 * Initialize a title and prompt of the game.
	 */
	public GameConsole() {
		this.title = "Guessing Game";
		this.prompt = "Your guess?";

	}

	/**
	 * The play method plays a game using input from a user.
	 * 
	 * @param game
	 *            is new object of GuessingGame class.
	 * @return num is number that user guess.
	 */
	public int play(GuessingGame game) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(this.title);
		int num = 0;
		boolean correct = false;
		while (!correct) {
			System.out.print(game.getHint() + this.prompt + " ");
			num = Integer.parseInt(scanner.nextLine());
			correct = game.guess(num);
		}
		System.out.println(game.getHint());
		return num;
	}

}
