package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.*;
import java.util.Scanner;

public class BlackJackApp {

	private Player player;
	private Dealer dealer;
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
		player = new Player();
	}

	private void setupDeck() {
		dealer.getDeck().shuffle();
//		getStartingCards();
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
			getStartingCards();
			if(checkForBlackjack()) {
				continueGame();
				cleanUp();
				continue;
			}
			displayHandTotals();
			while (!gameOver) {
				if(!player.getHand().checkForSplit()) processInput();
				else processSplitInput();
			}
			displayWinner();
			continueGame();
			cleanUp();
		}
	}
	
	public boolean checkForBlackjack() {
		if(player.getHand().checkForBlackjack() && !dealer.getHand().checkForBlackjack()) {
			System.out.println("Blackjack, 21!  You win.");
			return true;
		} else if(player.getHand().checkForBlackjack() && dealer.getHand().checkForBlackjack()) {
			System.out.println("Both you and the dealer have Blackjack.  Tough luck.  It's a push");
			return true;
		} else {
			return false;
		}
	}

	private void displayHandTotals() {
//		int dealerTot = dealer.getHand().calculateDealerHandTotal();
		int playerTot = player.getHand().calculateHandTotal();
//		System.out.println("The dealer has " + dealerTot);
		System.out.println("Your "+player.getHand().toString());
		System.out.println("Hand Value: " + playerTot);
	}

	private void processInput() {
		boolean correct = true;
		do {
			System.out.println("\nWould you like to hit(h) or stay(s)?");
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
	private void processSplitInput() {
		boolean correct = true;
		do {
			System.out.println("\nWould you like to hit(h), stay(S), or split(p)?");
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
			case "SPLIT":
			case "P":
				player.split();
				break;
			default:
				correct = false;
				System.out.println(
						"Please choose to either Hit: receive a new card; " + "or Stay: go with your current total");
			}
		} while (!correct);
	}

	private void stay() {
		System.out.println("You chose to stay at "+player.getHand().calculateHandTotal());
		dealerFinishesGame();
	}

	private void hit() {
		System.out.println("You chose to hit");
		Card card = dealer.dealCard();
		player.addCard(card);
		displayHandTotals();
		if (player.getHand().checkForBust()) {
			gameOver = true;
		}
	}

	public void dealerFinishesGame() {
		while (!gameOver) {
			gameOver = dealer.determineToHitOrToStay(scanner);
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
		} else if (player.getHand().checkForBust()) {
			System.out.println("You bust!  Dealer wins.\n");
		} else if (dealer.getHand().checkForBust()) {
			System.out.println("Dealer busts!  You win!\n");
		}
	}

	private void continueGame() {
		boolean correct = false;
		while (!correct) {
			System.out.println("\nWould you like to keep playing : Yes or No ");
			String input = scanner.nextLine().toUpperCase();
			switch (input) {
			case "Yes":
			case "Y":
				correct = true;
				break;
			case "NO":
			case "N":
				System.out.println("Thanks for playing Blackjack!");
				scanner.close();
				System.exit(1);
				break;
			default:
//				correct = false;
				System.out.println("Not a valid selection.  Please try again.");
			}
		} 
	}

	public void cleanUp() {
		System.out.println("\nCleaning up the cards and reshuffling!\n");
		gameOver = false;
		dealer.reshuffle();
		player.cleanUp();
		dealer.cleanUp();
//		getStartingCards();
	}
}
