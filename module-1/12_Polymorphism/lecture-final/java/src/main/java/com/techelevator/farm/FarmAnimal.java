package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	private static int animalCount = 0;
	private String name;
	private String sound;
	private boolean asleep = false;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		animalCount++;
	}

	public abstract String eat();	
	
	public boolean isAsleep() {
		return asleep;
	}
	
	public void wakeUp() {
		asleep = false;
	}
			
	public String getName() {
		return name;
	}

	public final String getSound() {
		return asleep ? "Zzzz..." : sound;
	}
	
	public String makeNoise(int numberOfTimes) {
		String output = "";
		while(numberOfTimes-- >= 0) {
			output += this.sound + "!\n";
		}
		return output;
	}
	
	public int getNumberOfAnimals() {
		return animalCount;
	}

}