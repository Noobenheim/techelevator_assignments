package com.techelevator;

public class Bid {
	private String bidder;
	private int bidAmount;
	
	public Bid(String bidder, int bidAmount) {
		this.bidder = bidder;
		this.bidAmount = bidAmount;
	}
	
	public String getBidder() {
		return bidder;
	}
	public int getBidAmount() {
		return bidAmount;
	}

	@Override
	public String toString() {		
		return this.bidder + " -- " + this.bidAmount;
	}
	
	public boolean equals(Bid incomingBid) {
		return this.bidAmount == incomingBid.getBidAmount();
	}

}
