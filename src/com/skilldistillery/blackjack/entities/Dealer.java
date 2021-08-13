package com.skilldistillery.blackjack.entities;

public class Dealer {

	private Deck deck;
	private Hand hand;

	{
		hand = new Hand();
		deck = new Deck();
	}

	public void checkForHitOrStay() {

	}

	public Card dealCard() {
		return deck.dealCard();
	}
	public void dealSelf() {
		hand.addCard(dealCard());
	}

	public void dealCards(Deck deck) {

	}

}
