package com.skilldistillery.blackjack.entities;

public class Dealer {

	private Hand hand;
	private Deck deck;

	{
		deck = new Deck();
		hand = new Hand();
	}

	public Deck getDeck() {
		return deck;
	}

	public Hand getHand() {
		return hand;
	}

	public Card dealCard() {
		return deck.dealCard();
	}

	public void addCard(Card card) {
		if(hand.getCards().size()>0)
		System.out.println("The dealer deals himself a " + card);
		else
			System.out.println("The dealer deals himself a facedown card");
		hand.addCard(card);
	}
}
