package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealer {
	private Hand hand;
	private Deck deck;
	private List<Card> discards;

	{
		deck = new Deck();
		hand = new Hand();
		discards = new ArrayList<>();
	}

	public Deck getDeck() {
		return deck;
	}

	public Hand getHand() {
		return hand;
	}
	

	public Card dealCard() {
		Card card = deck.dealCard();
		discards.add(card);
		return card;
	}

	public void addCard(Card card) {
		if(hand.getCards().size()>0)
		System.out.println("\nThe dealer deals himself a " + card+"\n");
		else
			System.out.println("\nThe dealer deals himself a facedown card\n");
		hand.addCard(card);
	}
	
	public boolean determineToHitOrToStay(Scanner scanner) {
		System.out.println("Dealers "+hand.toString());
		int curHandValue = hand.calculateHandTotal();
		System.out.println("--------------------------------------");
		System.out.println("\nThe dealers hand's value is "+curHandValue);
		System.out.println("--------------------------------------");
		if(curHandValue > 16 && curHandValue < 22) {
			System.out.println("Dealer stays.");
			System.out.println("Press enter to see who wins!");
			scanner.nextLine();
			return true;
		}else if(hand.checkForBust()) {
			return true;
		} else {
			System.out.println("Dealer hits.");
			System.out.println("Press enter to see what he draws");
			scanner.nextLine();
			addCard(dealCard());
			return false;
		}
	}
	
	public void reshuffle() {
		deck.reShuffle(discards);
		discards.clear();
		
	}
	public void cleanUp() {
		hand.cleanUp();
	}
}
