import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		int tries = 0;
		try {
		int guess = Integer.parseInt(guessText);
		if(guess < theNumber)
			
			message = guess + " your guess is to low try again";
			
		else if(guess > theNumber)
			message = guess + " Your guess is to high, try again";
		
		else {
			message = guess + " you guessed correctly! you win! Game restarts. Juan sucks";
			newGame();
		}
		} catch(Exception e) {
			message = "Enter a whole number between 1-100 please";
		} finally {
		lblOutput.setText(message);
		txtGuess.requestFocus();
		txtGuess.selectAll();
			}	
		}
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("imjords HiLo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("imjords HiLo Guessing Game!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 32, 414, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1-100");
		lblNewLabel_1.setBounds(79, 101, 192, 27);
		getContentPane().add(lblNewLabel_1);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setBounds(260, 102, 57, 24);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(79, 160, 257, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Guess a number above then click submit!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(0, 215, 434, 14);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450, 300));
		theGame.setVisible(true);
		// TODO Auto-generated method stub

	}
}
