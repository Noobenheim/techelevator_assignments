package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Auction {

	private String itemForSale;
	private Bid currentHighBid;
	private List<Bid> allBids;

	public Auction(String itemForSale) {
		this.itemForSale = itemForSale;		
		this.allBids = new ArrayList<Bid>();
		this.currentHighBid = new Bid("", 0);
	}

	
	public boolean placeBid(Bid offeredBid) {
		this.allBids.add(offeredBid); // add to bid history
		
		// check to see if it's the winning bid
		boolean isCurrentWinningBid = false;
		if(offeredBid.getBidAmount() > this.currentHighBid.getBidAmount()) {
			this.currentHighBid = offeredBid;
			isCurrentWinningBid = true;
		}
		
		
		return isCurrentWinningBid;
	}
	
	public String getItemForSale() {
		return this.itemForSale;
	}

	public Bid getCurrentHighBid() {
		return this.currentHighBid;
	}

	public List<Bid> getAllBids() {
		return new ArrayList<Bid>(this.allBids);
	}
	
}
