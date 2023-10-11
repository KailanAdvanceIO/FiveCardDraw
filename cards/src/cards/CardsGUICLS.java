/***********************
 *  Advance IO Assessment
 *  Kailan Murugan
 *  Five-Card Poker
 *  CardsGUICLS
 */
package cards;

//Getter and Setter Methods for card Face and Suit used in GUI
public class CardsGUICLS {

	private String suit;
	private String face;

	public CardsGUICLS(String suit, String face) {
		this.suit = suit;
		this.face = face;
	}

//Suit Getter Method
	public String getSuit() {
		return suit;
	}

//Face Getter Method
	public String getFace() {
		return face;
	}

}
