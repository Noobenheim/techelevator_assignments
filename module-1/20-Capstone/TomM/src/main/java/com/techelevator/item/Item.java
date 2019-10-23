package com.techelevator.item;

public abstract class Item {
	private String type;
	private String name;
	
	public Item(String type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public abstract String consume();
	
	public String getType() {
		return this.type;
	}
	
	public String getName() {
		return this.name;
	}
	
}
