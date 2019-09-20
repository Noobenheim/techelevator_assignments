package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;
		String[] numbers;
		
		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		input = scanner.nextLine();
		
		numbers = input.split(" ");
		
		for( int i=0; i<numbers.length; i++ ) {
			try {
				int number = Integer.parseInt(numbers[i]);
				System.out.println(number+" to binary is "+Integer.toBinaryString(number));
			} catch( NumberFormatException e ) {
				System.err.println("Unable to convert '"+numbers[i]+"'");
			}
		}
		
		scanner.close();
	}

}
