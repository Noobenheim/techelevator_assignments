package com.techelevator;

import com.techelevator.item.Item;

public class VendingMachineSlot {

	private String name;
	private Item item;
	private int quantity;
	private int priceInCents;
	
	public VendingMachineSlot(String name, Item item, int quantity, int priceInCents) {
		this.name = name;
		this.item = item;
		this.quantity = quantity >= 0 ? quantity : 0;
		this.priceInCents = priceInCents >= 0 ? priceInCents : 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public int getPriceInCents() {
		return this.priceInCents;
	}
	
	public int getQty() {
		return this.quantity;
	}
	
	public boolean decrement() {
		if(this.quantity > 0) {
			this.quantity--;
			return true;
		}
		return false;
	}
}
