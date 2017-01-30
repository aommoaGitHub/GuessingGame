package guessinggame;

/**
 * Main method of the game app.
 * 
 * @author Vittunyuta Maeprasart
 *
 */
public class GuessingApp {
	/** create objects and start the game. */
	public static void main(String[] args) {
		GuessingGame game = new GuessingGame(20);
		GameConsole ui = new GameConsole();
		ui.play(game);
	}
}
