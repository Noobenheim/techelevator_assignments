package com.techelevator;

public class CardGame {

	public static void main(String[] args) {
		/*
		Card aceOfSpades = new Card("Ace", "Spades");
		aceOfSpades.flip();
		aceOfSpades.flip();
		aceOfSpades.flip();
		System.out.println(aceOfSpades);
*/
		
		Deck d = new Deck();
		System.out.println(d);

		d.shuffle();
		System.out.println(d);
		d.shuffle();
		System.out.println(d);
		d.shuffle();
		System.out.println(d);
		d.shuffle();
		System.out.println(d);
	}

}
