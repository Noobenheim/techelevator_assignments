package com.techelevator;

public class Elevator {
	public final int DEFAULT_FLOOR = 1;
	
	private int currentFloor = DEFAULT_FLOOR;
	private int numberOfFloors;
	private boolean doorOpen;
	
	public Elevator(int totalNumberOfFloors) {
		this.numberOfFloors = totalNumberOfFloors;
	}
	
	public void openDoor() {
		this.doorOpen = true;
	}
	public void closeDoor() {
		this.doorOpen = false;
	}
	public void goUp(int desiredFloor) {
		if( desiredFloor <= this.currentFloor ) return;
		this.goToFloor(desiredFloor);
	}
	public void goDown(int desiredFloor) {
		if( desiredFloor >= this.currentFloor ) return;
		this.goToFloor(desiredFloor);
	}
	public void goToFloor(int desiredFloor) {
		if( this.isDoorOpen() ) return;
		
		if( this.inRange(desiredFloor, 1, this.numberOfFloors) ) {
			this.currentFloor = desiredFloor;
		}
	}
	
	private boolean inRange(int value, int min, int max) {
		return value >= min && value <= max;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public boolean isDoorOpen() {
		return doorOpen;
	}
}
