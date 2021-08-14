package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.*;
import java.util.Scanner;

public class BlackJackApp {

	private Player player;
	private Dealer dealer;
	private boolean quit = false;
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		BlackJackApp bja = new BlackJackApp();
		bja.setup();
		bja.run();
	}

	private void setup() {
		dealer = new Dealer();
		player = new Player(dealer);

		dealer.getDeck().shuffle();
		getStartingCards();

	}

	private void getStartingCards() {
		for (int i = 0; i < 2; i++) {
			Card card = dealer.dealCard();
//			System.out.println("The dealer deals you a " + card);
			player.addCard(card);
			card = dealer.dealCard();
			dealer.addCard(card);
		}
	}

	private void run() {
		while (!quit) {
			displayHandTotals();
			processInput();
		}
	}

	private void displayHandTotals() {
		int dealerTot = dealer.getHand().calculateDealerHandTotal();
		int playerTot = player.getHand().calculateHandTotal();
		System.out.println("The dealer has " + dealerTot);
		System.out.println("You have " + playerTot);
	}

	private void processInput() {
		boolean correct = true;
		do {
			System.out.println("Would you like to hit or stay?");
			String input = scanner.nextLine().toUpperCase();
			switch (input) {
			case "HIT":
			case "H":
				correct = true;
				hit();
				break;
			case "STAY":
			case "S":
				correct = true;
				stay();
				break;
			default:
				correct = false;
				System.out.println(
						"Please choose to either Hit: receive a new card; " + "or Stay: go with your current total");
			}
		} while (!correct);
	}

	private void stay() {
		System.out.println("stay");
	}

	private void hit() {
		System.out.println("You chose to hit");
		Card card = dealer.dealCard();
		player.getHand().addCard(card);
	}

}
