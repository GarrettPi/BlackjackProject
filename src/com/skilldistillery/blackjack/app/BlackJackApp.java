package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.*;
import java.util.Scanner;

public class BlackJackApp {

	private Player player;
	private Dealer dealer;
	private boolean quit = false;
	private boolean gameOver = false;
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		BlackJackApp bja = new BlackJackApp();
		bja.setupPlayers();
		bja.setupDeck();
		bja.run();
	}

	private void setupPlayers() {
		dealer = new Dealer();
		player = new Player(dealer);
	}

	private void setupDeck() {
		dealer.getDeck().shuffle();
		getStartingCards();
	}

	private void getStartingCards() {
		for (int i = 0; i < 2; i++) {
			Card card = dealer.dealCard();
			player.addCard(card);
			card = dealer.dealCard();
			dealer.addCard(card);
		}
	}

	private void run() {
		while (true) {
			while (!gameOver) {
				displayHandTotals();
				processInput();
			}
			displayWinner();
			cleanUp();
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
		dealerFinishesGame();
	}

	private void hit() {
		System.out.println("You chose to hit");
		Card card = dealer.dealCard();
		player.addCard(card);
		if (player.getHand().checkForBust()) {
			gameOver = true;
		}
	}

	public void dealerFinishesGame() {
		while (!gameOver) {
			gameOver = dealer.determineToHitOrToStay();
		}

	}

	public void displayWinner() {
		int playerHandValue = player.getHand().calculateHandTotal();
		int dealerHandValue = dealer.getHand().calculateHandTotal();
		if (playerHandValue <= 21 && dealerHandValue <= 21 && playerHandValue != dealerHandValue) {
			if (playerHandValue > dealerHandValue)
				System.out.println("You win");
			else
				System.out.println("Dealer wins");
		} else if (playerHandValue == dealerHandValue) {
			System.out.println("It's a push.  No winner.\n");
		} else if (playerHandValue > 21) {
			System.out.println("You bust!  Dealer wins.\n");
		} else if (dealerHandValue > 21) {
			System.out.println("Dealer bust!  You win!\n");
		}
	}

	public void cleanUp() {
		System.out.println("\nCleaning up the cards and reshuffling!\n");
		gameOver = false;
		dealer.reshuffle();
		player.cleanUp();
		dealer.cleanUp();
		getStartingCards();
	}
}
