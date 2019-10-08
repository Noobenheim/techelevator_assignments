package com.techelevator;

import java.util.List;

public class Ebay {

	public static void main(String[] args) {

		Auction plasticRock = new Auction("Plastic Rock");
		
		Auction petRock = new ReserveAuction("Pet Rock", 250);
		Auction toyRock = new BuyItNowAuction("Toy Rock", 2000);
		
		plasticRock = new BuyItNowAuction("Hello there", 100000);
		
		Auction[] myAuctions = { plasticRock, petRock, toyRock };
		
		for(Auction a : myAuctions) {
			//a.getBuyItNowPrice();
			
		}
		
		
		
		Bid b2 = new Bid("Chris Rock", 2000);
		Bid b1 = new Bid("Kid Rock", 100);
		Bid b3 = new Bid("Ad Rock", 50);
		
		b1.equals(b3);
		b3.equals(b1);
		
		
		petRock.placeBid(b1);
		petRock.placeBid(b2);
		petRock.placeBid(b3);
		
		List<Bid> bidHistory = petRock.getAllBids();
		for(Bid b : bidHistory) {
			System.out.println(b);
		}
		
		Bid petRockCurrentHighBid = petRock.getCurrentHighBid();
		System.out.println();
		System.out.print("Current High Bid: ");
		System.out.println(petRockCurrentHighBid);
				
	}
	
}
