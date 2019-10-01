package com.techelevator;

public class HomeworkAssignment {
	private int earnedMarks;
	private int possibleMarks;
	private String submitterName;
	
	public HomeworkAssignment(int possibleMarks) {
		this.possibleMarks = possibleMarks;
	}
	
	public String getLetterGrade() {
		double grade = (double)earnedMarks / possibleMarks;
		
		if( grade >= 0.9 ) {
			return "A";
		}
		if( grade >= 0.8 ) {
			return "B";
		}
		if( grade >= 0.7 ) {
			return "C";
		}
		if( grade >= 0.6 ) {
			return "D";
		}
		return "F";
	}
	
	public int getEarnedMarks() {
		return earnedMarks;
	}
	public void setEarnedMarks(int earnedMarks) {
		this.earnedMarks = earnedMarks;
	}
	public String getSubmitterName() {
		return submitterName;
	}
	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}
	public int getPossibleMarks() {
		return possibleMarks;
	}
}
