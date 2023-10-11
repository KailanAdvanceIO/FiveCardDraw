/***********************
 *  Advance IO Assessment
 *  Kailan Murugan
 *  Five-Card Poker
 *  Card
 */
package cards;

public class Card implements Comparable<Card> {
	// A cards has a suit and rank
	public int suit;
	public int rank;

	@Override
	public int compareTo(Card o) {
		if (this.rank == (o.rank))
			return 0;
		else if ((this.rank) > (o.rank))
			return 1;
		else
			return -1;
	}

}
