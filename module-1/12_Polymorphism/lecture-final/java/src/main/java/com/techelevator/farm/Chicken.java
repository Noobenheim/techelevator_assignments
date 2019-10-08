package com.techelevator.farm;

public abstract class Chicken extends FarmAnimal {

	public Chicken() {
		super("Chicken", "cluck!");
	}
	
	public Chicken(String name) {
		super(name, "cluck!");
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

	
}