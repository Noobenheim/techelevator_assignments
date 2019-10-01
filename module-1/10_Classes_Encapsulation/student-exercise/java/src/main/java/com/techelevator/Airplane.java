package com.techelevator;

public class Airplane {
	private String planeNumber;
	private int bookedFirstClassSeats;
	private int totalFirstClassSeats;
	private int bookedCoachSeats;
	private int totalCoachSeats;
	
	public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
		this.totalFirstClassSeats = totalFirstClassSeats;
		this.totalCoachSeats = totalCoachSeats;
		this.planeNumber = planeNumber;
	}
	
	public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
		if( forFirstClass ) {
			if( this.getAvailableFirstClassSeats() < totalNumberOfSeats )
				return false;
			this.bookedFirstClassSeats += totalNumberOfSeats;
			return true;
		}
		
		if( this.getAvailableCoachSeats() < totalNumberOfSeats )
			return false;
		this.bookedCoachSeats += totalNumberOfSeats;
		return true;
	}
	
	public int getAvailableFirstClassSeats() {
		return this.getTotalFirstClassSeats() - this.getBookedFirstClassSeats();
	}
	public int getAvailableCoachSeats() {
		return this.getTotalCoachSeats() - this.getBookedCoachSeats();
	}
	
	public String getPlaneNumber() {
		return planeNumber;
	}
	public int getBookedFirstClassSeats() {
		return bookedFirstClassSeats;
	}
	public int getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}
	public int getBookedCoachSeats() {
		return bookedCoachSeats;
	}
	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}
}
