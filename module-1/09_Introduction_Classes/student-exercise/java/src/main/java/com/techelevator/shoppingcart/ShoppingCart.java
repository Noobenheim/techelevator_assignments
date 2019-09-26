package com.techelevator.shoppingcart;

public class ShoppingCart {
	private int totalNumberOfItems = 0;
	private double totalAmountOwed = 0.0;
	
	public ShoppingCart() {  }
	
	public double getAveragePricePerItem() {
		if( this.getTotalNumberOfItems() == 0 ) return 0.0;
		return this.getTotalAmountOwed() / this.getTotalNumberOfItems();
	}
	
	public void addItems(int numberOfItems, double pricePerItem) {
		this.totalNumberOfItems += numberOfItems;
		this.totalAmountOwed += numberOfItems * pricePerItem;
	}
	
	public void empty() {
		this.totalNumberOfItems = 0;
		this.totalAmountOwed = 0.0;
	}
	
	public int getTotalNumberOfItems() { return this.totalNumberOfItems; }
	public double getTotalAmountOwed() { return this.totalAmountOwed; }
}
