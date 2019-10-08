package com.techelevator.farm;

public class Cow extends FarmAnimal {

	public Cow() {
		super("Cow", "moo!");
	}
	
	@Override
	public String toString() {
		return "I'm a cow!";
	}
	
	@Override
	public String makeNoise(int numberOfTimes) {
		if(numberOfTimes > 5 || numberOfTimes < 0) {
			numberOfTimes = 5;
		}
		
		return super.makeNoise(numberOfTimes);
	}

}