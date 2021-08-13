package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {

	private Player player;
	private Dealer dealer;
	private boolean stay = false;
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
		getStartingCards();
		

	}

	private void getStartingCards() {
		for(int i = 0; i<2; i++) {
			player.hit();
			dealer.dealSelf();
		}
	}

	private void run() {
			debugMethod();
//			displayTable();
//			displayMenu();
	}

	private void debugMethod() {
		
	}

	private void displayTable() {
//		System.out.println(
//				"+---------------------------------+\n" + 
//				"|            Dealer               |\n"+
//				"|                                 |\n"+
//				"|                                 |\n"+
//				"|                                 |\n"+
//				"|                                 |\n"+
//				"|                                 |\n"+
//				"|                                 |\n"+
//				"|                                 |\n"+
//				"|                                 |\n"+
//				"|                                 |\n"+
//				"|                                 |\n"+
//				"|                                 |\n"+
//				"|            Player               |\n"+
//				"+---------------------------------+");
		;
	}

	private void displayMenu() {
		System.out.println("Would you like to Stay or Hit?");
		processInput(scanner.nextLine());
	}

	private void processInput(String input) {
		
	}

}
