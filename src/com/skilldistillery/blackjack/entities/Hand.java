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

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Hand: ");
		for (int i = 0; i < cards.size(); i++) {
			sb.append(cards.get(i).toString());
			if (i < cards.size() - 1)
				sb.append(", ");
		}
		return sb.toString();
	}

	public boolean checkForBust() {
		int handValue = 0;
		for (Card card : cards) {
			handValue += card.getValue();
		}
		if (handValue > 21)
			return true;
		else
			return false;
	}

	public void cleanUp() {
		cards.removeAll(cards);
	}

	public boolean checkForAce() {
		for (Card card : cards) {
			if (card.getRank() == Rank.ACE) {
				System.out.println("Ace ace ace");
				return true;
			}
		}
		return false;
	}

	public boolean checkForBlackjack() {
		if (calculateHandTotal() == 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkForSplit() {
		if (cards.size() == 2 && cards.get(0).getRank() == cards.get(1).getRank()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void split() {
		
	}
}
