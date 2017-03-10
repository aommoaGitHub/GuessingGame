package guessinggame;

import java.util.Random;

/**
 * Game of guessing a secret number.
 * 
 * @author Vittunyuta Maeprasart
 *
 */

public class Game {
	private int upperBound;
	private int secret;
	private String hint;
	private int count;

	/**
	 * Initialize a new game.
	 * 
	 * @param upperBound
	 *            is the max value for the secret number (>=1).
	 */
	public Game(int upperBound) {
		this.upperBound = upperBound;
		this.secret = getRandomNumber(this.upperBound);
		this.hint = "";
		this.count = 0;
	}

	/**
	 * Create a random number between 1 and limit.
	 * 
	 * @param limit
	 *            is the upper limit for random number
	 * @return a random number between 1 and limit (inclusive)
	 */
	private int getRandomNumber(int limit) {
		long seed = System.currentTimeMillis();
		Random random = new Random(seed);
		return random.nextInt(limit) + 1;
	}

	/**
	 * to check the number guesses is equal the secret or not.
	 * 
	 * @param numberGuess
	 *            is the number that user guess.
	 * @return boolean of guessing
	 */
	public boolean guess(int numberGuess) {
		this.count++;
		if (numberGuess == this.secret) {
			this.hint = String.format("Correct. The secret is %d. You used %d guesses.", this.secret, this.count);
			return true;
		} else if (numberGuess > this.secret) {
			this.hint = "Sorry, " + numberGuess + " is too large. ";
			return false;
		} else {
			this.hint = "Sorry, " + numberGuess + " is too small. ";
			return false;
		}
	}

	/**
	 * Return a hint based in the most recent guess.
	 * 
	 * @return hint based on most recent guess
	 */
	public String getHint() {
		return this.hint;
	}

	/**
	 * Return a number of times user guess.
	 * 
	 * @return a number of times user guess.
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * Return a correct number.
	 * 
	 * @return a correct number.
	 */
	public int getSecret() {
		return secret;
	}
}
