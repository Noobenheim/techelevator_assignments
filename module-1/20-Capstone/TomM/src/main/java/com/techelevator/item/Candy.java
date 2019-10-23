package com.techelevator.item;

public class Candy extends Item {

	public Candy(String name) {
		super("Candy", name);
	}
	
	@Override
	public String consume() {
		return "Glug Glug, Yum";
	}
}
