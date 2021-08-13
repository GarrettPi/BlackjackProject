package com.skilldistillery.blackjack.entities;

public class Player {

	private Hand hand;
	private Dealer dealer;

	{
		hand = new Hand();
	}

	public Player(Dealer dealer) {
		this.dealer = dealer;
	}

	public void hit() {
		hand.addCard(dealer.dealCard());
	}

	public boolean stay() {
		return true;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	
}
