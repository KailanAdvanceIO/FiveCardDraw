/***********************
 *  Advance IO Assessment
 *  Kailan Murugan
 *  Five-Card Poker
 *  GamePane
 */
package cards;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

class GamePane extends JPanel {

	private static final long serialVersionUID = 1L;

	private List<GUIHand> players;

	private Map<CardsGUICLS, Rectangle> mapCardsGUICLSs;

	public GamePane(List<GUIHand> players) {
		this.players = players;
		mapCardsGUICLSs = new HashMap<>(players.size());

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(700, 400);
	}

	@Override
	public void invalidate() {
		super.invalidate();
		mapCardsGUICLSs.clear();
		GUIHand GUIHand = players.get(0);
		int cardHeight = getHeight() - 190;
		int cardWidth = (int) (cardHeight - 90);
		int xDelta = cardWidth / 2;
		int xPos = (int) ((getWidth() - 300) - (cardWidth * (GUIHand.size() / 4.0)));
		int yPos = (getHeight()) - cardHeight;
		for (CardsGUICLS card : GUIHand.cards()) {
			Rectangle bounds = new Rectangle(xPos - 90, yPos - 90, cardWidth, cardHeight);
			mapCardsGUICLSs.put(card, bounds);
			xPos += xDelta;
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		GUIHand GUIHand = players.get(0);
		for (CardsGUICLS card : GUIHand.cards) {
			Rectangle bounds = mapCardsGUICLSs.get(card);

			if (bounds != null) {
				g2d.setColor(Color.WHITE);
				g2d.fill(bounds);
				g2d.setColor(Color.BLACK);
				g2d.draw(bounds);
				Graphics2D copy = (Graphics2D) g2d.create();
				paintCardsGUICLS(copy, card, bounds);
				copy.dispose();
			}
		}
		g2d.dispose();
	}

	protected void paintCardsGUICLS(Graphics2D g2d, CardsGUICLS card, Rectangle bounds) {
		g2d.translate(bounds.x + 5, bounds.y + 5);
		g2d.setClip(0, 0, bounds.width, bounds.height);

		String text = card.getFace() + card.getSuit();
		FontMetrics fm = g2d.getFontMetrics();
		Font stringFont = new Font("Courier New", Font.BOLD, 14);
		g2d.setFont(stringFont);

		g2d.drawString(text, 0, fm.getAscent());
	}

}
