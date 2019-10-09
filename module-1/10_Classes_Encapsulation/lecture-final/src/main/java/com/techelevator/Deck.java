package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards = new ArrayList<>();
	
	public Deck() {
		for(String suit : Card.suits) {			
			for(String value : Card.values) {
				Card currentCard = new Card(value, suit);
				cards.add(currentCard);
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(this.cards);
	}
	
	public String toString() {
		String result = "";
		for(Card c : this.cards) {
			result += c.getSuit().substring(0, 1) + c.getValue().substring(0, 1) + " ";
		}
		
		return result;
	}
	
	public int getSize() {
		return this.cards.size();
	}
	
	public boolean hasCards() {
		return this.cards.size() > 0;
	}
	
	public Card dealOne() {
		if(hasCards()) {
			return this.cards.remove(cards.size() - 1);
		} 
		
		return null;
	}
	
	public List<Card> dealMany(int n) {
		if(n > getSize()) {
			return null;
		}
		
		List<Card> cardsToBeDealt = new ArrayList<>();
		while(n-- >= 0) {
			cardsToBeDealt.add(this.dealOne());
		}
		
		return cardsToBeDealt;
	}
	
	
}
