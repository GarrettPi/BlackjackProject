package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	
	private String name;
	
	Suit(String name){
		this.name = name;
	}
	
	@Override
	public String toString(){
		return name.substring(0,1)+name.substring(1).toLowerCase();
	}
}
