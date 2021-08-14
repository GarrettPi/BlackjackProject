package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Hand {// comment

	private List<Card> cards;

	public Hand() {
		cards = new ArrayList<>();
	}

	public List<Card> getCards() {
		return cards;
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public int calculateHandTotal() {
		int total = 0;
		for (Card card : cards) {
			total += card.getValue();
		}
		return total;
	}

	public int calculateDealerHandTotal() {
		int total = 0;
		for (int i = 0; i < cards.size(); i++) {
			if (i > 0) {
				total += cards.get(i).getValue();
			}
		}
		return total;
	}

	public boolean checkForBust() {
		int handValue = 0;
		for (Card card : cards) {
			handValue += card.getValue();
		}
		System.out.println(handValue);
		if (handValue > 21)
			return true;
		else
			return false;
	}
	
	public void cleanUp() {
		cards.removeAll(cards);
	}
}
