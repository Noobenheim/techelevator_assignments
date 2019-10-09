package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };
	
	public static void main(String...args) {
		String filename = "RTNs.txt";
		Scanner inputStream = null;

		File inputFile = new File(RTNValidator.class.getResource(filename).getPath());
		
		try {
			inputStream = new Scanner(inputFile);
		} catch( FileNotFoundException e ) {
			System.err.println("Could not find file "+filename);
			System.exit(1);
		}
			
		while( inputStream.hasNextLine() ) {
			String input = inputStream.nextLine();
			System.out.println("Is "+input+" valid? "+(checksumIsValid(input)?"yes":"no"));
		}
	}
	
	private static boolean checksumIsValid(String routingNumber) {
		if( routingNumber == null || routingNumber.length() != 9 ) return false;
		
		int checksum = 0;
		for( int i=0; i<9; i++ ) {
			int digit;
			try { 
				digit = Integer.parseInt(routingNumber.substring(i, i+1));
			} catch( NumberFormatException e ) {
				return false;
			}
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
	
	private static boolean checksumIsValid(int routingNumber) {
		return checksumIsValid(Integer.toString(routingNumber));
	}
}
