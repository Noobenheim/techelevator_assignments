package com.techelevator.item;

public class Drink extends Item {

	public Drink(String name) {
		super("Drink", name);
	}
	
	@Override
	public String consume() {
		return "Munch Munch, Yum";
	}
}
