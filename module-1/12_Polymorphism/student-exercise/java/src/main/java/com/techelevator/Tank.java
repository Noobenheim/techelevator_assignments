package com.techelevator;

public class Tank implements Vehicle {

	@Override
	public double calculateToll(int distance) {
		return 0;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Tank";
	}

	public String toString() {
		return getType();
	}
}
