package com.techelevator.farm;

public class RhodeIslandRed extends Chicken {

	public RhodeIslandRed() {
		super("Rhode Island Red");
	}
	
	@Override
	public String eat() {
		return "Peck!";
	}

	@Override
	public String getSHOUTY() {
		return null;
	}

}
