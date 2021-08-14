package com.skilldistillery.blackjack.entities;

public class Player {

	private Hand hand;
	
	{
		hand = new Hand();
	}
	
	public Player() {
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public void addCard(Card card) {
		System.out.println("The dealer deals you a " + card);
		hand.addCard(card);
	}
	
	public void cleanUp() {
		hand.cleanUp();
	}
	
	
}
