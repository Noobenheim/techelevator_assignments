package com.techelevator.item;

public class Gum extends Item {

	public Gum(String name) {
		super("Gum", name);
	}
	
	@Override
	public String consume() {
		return "Chew Chew, Yum";
	}
}
