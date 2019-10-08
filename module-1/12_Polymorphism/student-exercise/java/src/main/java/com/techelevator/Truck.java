package com.techelevator;

public class Truck implements Vehicle {
	private int numberOfAxles;
	
	public Truck(int numberOfAxles) {
		this.numberOfAxles = numberOfAxles;
	}

	public int getNumberOfAxles() {
		return numberOfAxles;
	}

	@Override
	public double calculateToll(int distance) {
		if( numberOfAxles <= 4 ) {
			return distance * 0.040;
		}
		if( numberOfAxles <= 6 ) {
			return distance * 0.045;
		}
		return distance * 0.048;
	}

	@Override
	public String getType() {
		return "Truck";
	}
	
	public String toString() {
		return getType() + " ("+numberOfAxles+" axles)";
	}
}
