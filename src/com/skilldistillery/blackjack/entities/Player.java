package com.skilldistillery.blackjack.entities;

public class Player {

	private Hand hand;
	private Hand splitHand;
	
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
	
	public void split() {
		splitHand = new Hand();
		splitHand.getCards().add(hand.getCards().remove(0));
	}
}
