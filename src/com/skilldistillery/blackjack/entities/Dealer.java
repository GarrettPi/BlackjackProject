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

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

}
