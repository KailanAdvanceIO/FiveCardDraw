/***********************
 *  Advance IO Assessment
 *  Kailan Murugan
 *  Five-Card Poker
 *  GUIHand
 */
package cards;

import java.util.ArrayList;
import java.util.List;

public class GUIHand {

	List<CardsGUICLS> cards;

	public GUIHand() {
		cards = new ArrayList<>(5);
	}

	public void add(CardsGUICLS card) {
		cards.add(card);
	}

	public int size() {
		return cards.size();
	}

	public Iterable<CardsGUICLS> cards() {
		return cards;
	}

	public Iterable<CardsGUICLS> reveresed() {
		List<CardsGUICLS> reversed = new ArrayList<>(cards);

		return reversed;
	}

}
