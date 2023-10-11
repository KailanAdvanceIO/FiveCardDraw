/***********************
 *  Advance IO Assessment
 *  Kailan Murugan
 *  Five-Card Poker
 *  GameTest
 */
package cards;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class GameTest {

	public static void main(String[] args) {
		// 0

		// SimpleCardsGUICLSs();
		// Call Method to StartGame
		SimpleCardsGUICLSs(1);

	}

	public static void SimpleCardsGUICLSs(int again) {
		// Keep playing

		//Instantiate Class Game
		Game game = new Game();
		// Execute Play Method in Game Class
		game.play();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
					ex.printStackTrace();
				}

				// Adds a hand of cards for each player in this this case its 1 player
				List<GUIHand> players = new ArrayList<>(1);
				for (int index = 0; index < 1; index++) {
					players.add(new GUIHand());
				}

				// Loop for players(1 Player)
				for (GUIHand hand : players) {
					// Loop to create 5 cards
					for (int handCounter = 0; handCounter < 5; handCounter++) {
						int hr = game.hand[handCounter].rank;
						int hs = game.hand[handCounter].suit;
						hand.add(new CardsGUICLS(game.displaySymbol(hs), game.display(hr)));
					}
				}
				String eva = "";
				eva = game.evaluate();
				// Creates a GUI frame
				JFrame frame = new JFrame("Five-Card Draw");

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// Create a button for the GUI
				JButton button = new JButton("Deal Again");
				// Size and location of button
				button.setBounds(30, 20, 300, 200);
				// Create a panel for the Frame
				JPanel panel = new JPanel();
				// Calls Shuffle Method with a popup shuffle box
				shuffle();
				// Add Card creation to the Panel
				panel.add(new GamePane(players), BorderLayout.SOUTH);
				panel.setLayout(new java.awt.FlowLayout(FlowLayout.TRAILING, 0, 60));
				frame.setLayout(new GridBagLayout());
				//Add button to the frame
				frame.add(button, new GridBagConstraints());
				//Add Panel to the frame
				frame.add(panel);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

				JOptionPane.showMessageDialog(frame, "Card Evaluation: " + eva);
				button.addActionListener((ActionListener) new ActionListener() {
					//OnClick of Fame Button 'Play Again' will run another set of cards and Evaluation
					@Override
					public void actionPerformed(ActionEvent e) {
						//Shuffle the cards 
						shuffle();
						game.play();
						players.clear();
						;
						for (int index = 0; index < 1; index++) {
							players.add(new GUIHand());
						}
						for (GUIHand hand2 : players) {
							for (int handCounter = 0; handCounter < 5; handCounter++) {
								int hr = game.hand[handCounter].rank;
								int hs = game.hand[handCounter].suit;
								hand2.add(new CardsGUICLS(game.displaySymbol(hs), game.display(hr)));

							}
						}
						JPanel panel = new JPanel();
						panel.removeAll();
						panel.add(new GamePane(players), BorderLayout.SOUTH);
						String eva = "";
						eva = game.evaluate();
						panel.setLayout(new java.awt.FlowLayout(FlowLayout.TRAILING, 0, 60));
						frame.setContentPane(panel);
						frame.invalidate();
						frame.validate();
						frame.add(button, new GridBagConstraints());
						JOptionPane.showMessageDialog(frame, "Card Evaluation: " + eva);
					}
				});
			}
		});
	}
	//Create a popup box to notify user that shuffling is in progress
	@SuppressWarnings("serial")
	public static void shuffle() {
		final JOptionPane optionPane = new JOptionPane("Shuffling... Shuffling... Shuffling",
				JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] {}, null);

		JDialog dialog = optionPane.createDialog(null, "Shuffle Loader");
		dialog.setModal(true);

		dialog.setContentPane(optionPane);

		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dialog.pack();

		// create timer to dispose of dialog after 5 seconds
		Timer timer = new Timer(3000, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				dialog.dispose();
			}
		});
		timer.setRepeats(false);// the timer should only go off once

		// start timer to close JDialog as dialog modal we must start the timer before
		// its visible
		timer.start();

		dialog.setVisible(true);
	}
}
