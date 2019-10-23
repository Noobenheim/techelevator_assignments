package com.techelevator.item;

public class Chip extends Item {

	public Chip(String name) {
		super("Chip", name);
	}
	
	@Override
	public String consume() {
		return "Crunch Crunch, Yum";
	}
}
