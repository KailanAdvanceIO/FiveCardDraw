/***********************
 *  Advance IO Assessment
 *  Kailan Murugan
 *  Five-Card Poker
 *  Game
 */
package cards;

import java.util.Arrays;
import java.util.Scanner;

public class Game {

	// instantiate Deck and Player
	Scanner scan = new Scanner(System.in);
	Deck deck = new Deck();
	Player player = new Player();
	Card[] hand;

	// plays the game
	public void play() {

		{
			// fill deck
			deck.fillDeck();

			// shuffle
			deck.shuffle();

			// player draws
			hand = player.draw(deck);

			// sort hand
			Arrays.sort(hand);

		}

	}

	// Creation of a hand
	public void makeHand() {
		hand[0].rank = 1;
		hand[1].rank = 2;
		hand[2].rank = 3;
		hand[3].rank = 4;
		hand[4].rank = 5;

		hand[0].suit = 1;
		hand[1].suit = 1;
		hand[2].suit = 1;
		hand[3].suit = 1;
		hand[4].suit = 1;
	}

	// evaluates the hand from hand strength
	public String evaluate() {
		String eva = "";
		if (this.royalFlush() == 1) {
			eva = "You have a royal flush!";
		} else if (this.straightFlush() == 1) {
			eva = "You have a straight flush!";
		} else if (this.fourOfaKind() == 1) {
			eva = "You have four of a kind!";
		} else if (this.fullHouse() == 1) {
			eva = "You have a full house!";
		} else if (this.flush() == 1) {
			eva = "You have a flush!";
		} else if (this.straight() == 1) {
			eva = "You have a straight!";
		} else if (this.triple() == 1) {
			eva = "You have a triple!";
		} else if (this.twoPairs() == 1) {
			eva = "You have two pairs!";
		} else if (this.pair() == 1) {
			eva = "You have a pair!";
		} else {
			int highCard = this.highCard();
			eva = "Your highest card is " + display(highCard);
		}
		return eva;
	}

	// checks for a royal flush
	public int royalFlush() {
		if (hand[0].rank == 1 && hand[1].rank == 10 && hand[2].rank == 11 && hand[3].rank == 12 && hand[4].rank == 13) {
			return 1;
		} else {
			return 0;
		}
	}

	// checks for a straight flush
	public int straightFlush() {
		for (int counter = 1; counter < 5; counter++) {
			if (hand[0].suit != hand[counter].suit) {
				return 0;
			}
		}
		for (int counter2 = 1; counter2 < 5; counter2++) {
			if (hand[counter2 - 1].rank != (hand[counter2].rank - 1)) {
				return 0;
			}

		}
		return 1;

	}

	// checks for four of a kind
	public int fourOfaKind() {
		if (hand[0].rank != hand[3].rank && hand[1].rank != hand[4].rank) {
			return 0;
		} else {
			return 1;
		}
	}

	// checks for full house
	public int fullHouse() {
		int comparison = 0;
		for (int counter = 1; counter < 5; counter++) {
			if (hand[counter - 1].rank == hand[counter].rank) {
				comparison++;
			}
		}
		if (comparison == 3) {
			return 1;
		} else {
			return 0;
		}
	}

	// checks for flush
	public int flush() {
		for (int counter = 1; counter < 5; counter++) {
			if (hand[0].suit != hand[counter].suit) {
				return 0;
			}
		}
		return 1;
	}

	// check for straight
	public int straight() {
		for (int counter2 = 1; counter2 < 5; counter2++) {
			if (hand[counter2 - 1].rank != (hand[counter2].rank - 1)) {
				return 0;
			}

		}
		return 1;
	}

	// checks for triple
	public int triple() {
		if (hand[0].rank == hand[2].rank || hand[2].rank == hand[4].rank) {
			return 1;
		}
		return 0;
	}

	// checks for two pairs
	public int twoPairs() {
		int check = 0;
		for (int counter = 1; counter < 5; counter++) {
			if (hand[counter - 1].rank == hand[counter].rank) {
				check++;
			}
		}
		if (check == 2) {
			return 1;
		} else {
			return 0;
		}
	}

	// check for pair
	public int pair() {
		int check = 0;
		for (int counter = 1; counter < 5; counter++) {
			if (hand[counter - 1].rank == hand[counter].rank) {
				check++;
			}
		}
		if (check == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	// find highest card
	public int highCard() {
		int highCard = 0;
		for (int counter = 0; counter < 5; counter++) {
			if (hand[counter].rank > highCard) {
				highCard = hand[counter].rank;
			}
		}
		return highCard;
	}

	// generates string for each card in hand
	public String display(int Rank) {

		String C = "";

		switch (Rank) {
		case 1:
			C += "A";
			break;
		case 2:
			C += "2";
			break;
		case 3:
			C += "3";
			break;
		case 4:
			C += "4";
			break;
		case 5:
			C += "5";
			break;
		case 6:
			C += "6";
			break;
		case 7:
			C += "7";
			break;
		case 8:
			C += "8";
			break;
		case 9:
			C += "9";
			break;
		case 10:
			C += "10";
			break;
		case 11:
			C += "J";
			break;
		case 12:
			C += "Q";
			break;
		case 13:
			C += "K";
			break;
		}
		return C;

	}

	// Displays suit symbol
	public String displaySymbol(int suit) {
		String C = "";
		switch (suit) {
		case 1:
			C += "\u2660";
			break;
		case 2:
			C += "\u2665";
			break;
		case 3:
			C += "\u2666";
			break;
		case 4:
			C += "\u2663";
			break;
		}

		return C;

	}
}
