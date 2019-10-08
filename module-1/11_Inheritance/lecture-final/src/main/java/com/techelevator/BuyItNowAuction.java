package com.techelevator;

public class BuyItNowAuction extends Auction {
	
	private int buyItNowPrice;
	
	public BuyItNowAuction(String itemForSale, int buyItNowPrice) {
		super(itemForSale);
		this.buyItNowPrice = buyItNowPrice;
	}

	@Override
	public boolean placeBid(Bid offeredBid) {
		boolean isCurrentWinningBid = false;
		if(getCurrentHighBid().getBidAmount() < this.buyItNowPrice) {
			if(offeredBid.getBidAmount() >= this.buyItNowPrice) {
				offeredBid = new Bid(offeredBid.getBidder(), this.buyItNowPrice);
			}
			isCurrentWinningBid = super.placeBid(offeredBid);
		}
		return isCurrentWinningBid;
	}
	
	public int getBuyItNowPrice() {
		return this.buyItNowPrice;
	}

	@Override
	public String toString() {
		return "";
	}
}
