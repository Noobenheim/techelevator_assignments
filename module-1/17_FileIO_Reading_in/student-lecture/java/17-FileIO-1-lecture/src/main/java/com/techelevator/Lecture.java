package com.techelevator;

public class Lecture {
	public static void main(String[] args) {
		String[] cities = new String[] { "Pittsburgh", "Philadephia", "Harrisburg", "Erie", "Scanton" /* the electric city */ };

		try {
			System.out.println(cities[0]);
			System.out.println(cities[1]);
			System.out.println(cities[2]);
			System.out.println(cities[3]);
			System.out.println(cities[4]);
			System.out.println(cities[5]);
		} catch( IndexOutOfBoundsException e ) {
			System.err.println("An error has occurred. If this problem persists, please contact Tech Support.");
		}
		
		System.out.println("...are all cities in Pennsylvania.");
	}
}
