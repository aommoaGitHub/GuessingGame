package guessinggame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
/**
 * GUI Interface for the guessing game 
 * 
 * @author Vittunyuta Maeprasart
 *
 */
public class GameUI extends JFrame {
	private Game game;
	private JLabel hintText;
	private JPanel hintPanel, inputPanel;
	private JTextField inputField;
	private JLabel usedGuessLabel;

	/**
	 * Initialize game, set window title, set stop application when close
	 * window.
	 */
	public GameUI() {
		super("Guess A Number");
		game = new Game(100);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		initComponent();
	}

	/**
	 * Method for initialize all components.
	 */
	public void initComponent() {
		// North Part
		hintPanel = new JPanel();
		hintText = new JLabel("Game Start!!");
		hintPanel.setBorder(BorderFactory.createTitledBorder("Hint"));
		hintPanel.add(hintText);
		add(hintPanel, BorderLayout.NORTH);

		// Center Part
		inputPanel = new JPanel();
		JLabel enterUrGuess = new JLabel(" Enter your guess:");
		inputField = new JTextField(4);
		JButton enterButton = new JButton("Enter");
		JButton quitButton = new JButton("Give up & Restart");
		/* action for checking entered number and setting hint. */
		enterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (game.guess(Integer.parseInt(inputField.getText()))) {
					enterButton.setEnabled(false);
					inputField.setEditable(false);
					quitButton.setEnabled(false);
				}
				hintText.setText(game.getHint());
				usedGuessLabel.setText("You used " + game.getCount() + " guesses");
			}
		});
		/* showing the correct number and restart a game. */
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hintText.setText("Correct number is " + game.getSecret());
				game = new Game(100);
				usedGuessLabel.setText("You used 0 guesses");
			}
		});
		inputPanel.setLayout(new FlowLayout());
		inputPanel.add(enterUrGuess);
		inputPanel.add(inputField);
		inputPanel.add(enterButton);
		inputPanel.add(quitButton);
		add(inputPanel, BorderLayout.CENTER);

		// South Part
		usedGuessLabel = new JLabel("You used 0 guesses");
		add(usedGuessLabel, BorderLayout.SOUTH);

		pack();

	}

	/** Display the game window */
	public void run() {
		setVisible(true);
	}
}
