/***********************
 *  Advance IO Assessment
 *  Kailan Murugan
 *  Five-Card Poker
 *  Player
 */
package cards;

public class Player {

	// gets 5 cards from deck
	public Card[] draw(Deck deck) {
		Card[] hand = deck.deal();
		return hand;
	}
	
}
