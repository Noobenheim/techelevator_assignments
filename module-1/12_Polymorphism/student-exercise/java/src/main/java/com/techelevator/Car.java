package com.techelevator;

public class Car implements Vehicle {
	private boolean hasTrailer;

	public Car(boolean hasTrailer) {
		this.hasTrailer = hasTrailer;
	}
	
	public boolean hasTrailer() {
		return hasTrailer;
	}

	@Override
	public double calculateToll(int distance) {
		double toll = distance * 0.020;
		toll += hasTrailer() ? 1 : 0;
		
		return toll;
	}

	@Override
	public String getType() {
		return "Car";
	}

	public String toString() {
		return getType() + (hasTrailer() ? " (with trailer)" : "");
	}
}
