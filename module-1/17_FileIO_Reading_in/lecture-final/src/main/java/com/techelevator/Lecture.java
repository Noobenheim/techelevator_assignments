package com.techelevator;

import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {
		
		Scanner getUserInput = new Scanner(System.in);

		int theNumber = 0;
		boolean badInput = true;

		while(badInput) {
			
			System.out.println("Enter a number between one and ten: ");
			String hereIsWhatTheUserTyped = getUserInput.nextLine();
			
			try {
				theNumber = Integer.parseInt(hereIsWhatTheUserTyped);
				
				
				if(theNumber >= 1 && theNumber <= 10) {
					badInput = false;
				}

			} catch(Exception e) {
				System.out.println("That's not a number!");				
			} 
			
			// nothing to see here
			// while loop code block is over
		}
				theNumber *= 3;

		System.out.println("Triple that is: " + theNumber);
		System.exit(0);
		
		
		
		
		String[] cities = new String[] {"Pittsburgh", "Philadelphia", "Harrisburg", "Erie", "Scranton" };
		
		System.out.println(cities[0]);
		System.out.println(cities[1]);
		System.out.println(cities[2]);
		System.out.println(cities[3]);
		System.out.println(cities[4]);		
		
		
		try { // I too like to live dangerously

		
			System.out.println(cities[6]);
			System.out.println(cities[7]);
			
			System.out.println(" ... are all cities in Pennsylvania");
			System.out.println(" or anything after it.");

		} catch(Exception e) { // recovery steps

		}
		
		

		System.out.println("... Done!");
	}

}
