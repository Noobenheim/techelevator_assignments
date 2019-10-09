package com.techelevator;

public class Card {

	public static String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
	public static String[] values = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	
	private final String suit;   // Heart, Diamond, Club, Spade
	private final String value; // 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace
	private boolean visible;   // face-down, face-up
	
	public Card(String value, String suit) {
		this.suit = suit;
		this.value = value;
		this.visible = false;
	}

	public boolean flip() {
		this.visible = !this.visible;
		return this.visible;
	}
	
	@Override
	public final String toString() {
		if(this.visible) {
			return this.value + " of " + this.suit;
		} else {
			return "###";
		}
	}
	
	public String getSuit() {
		return suit;
	}

	public String getValue() {
		return value;
	}

	public boolean isVisible() {
		return visible;
	}
	
}
