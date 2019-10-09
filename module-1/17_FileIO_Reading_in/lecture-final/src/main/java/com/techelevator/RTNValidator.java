package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class RTNValidator {

	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };
	private static int counter = 0;
	
	public static void main(String[] args) {

		File inputFile = new File("RTNs.csv");  // File object, to represent the actual file on the HDD
		Scanner inputStream = null;

		try {
			inputStream = new Scanner(inputFile);
		} catch(Exception e) {
			System.out.println("Could not find file!");
			System.exit(1);
		}

		while(inputStream.hasNext()) {
			String thisCurrentLine = inputStream.nextLine();
			boolean valid = checksumIsValid(thisCurrentLine);

			System.out.print(thisCurrentLine + " is ");
			System.out.println(valid ? "VALID" : "NOT VALID");
		}
		
		System.out.println();
		checksumIsValid(null);
		
	}

	
	private static boolean checksumIsValid(String routingNumber) {
		
		if(routingNumber == null || routingNumber.length() != 9) {
			return false;
		}

		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = 0;

			try {
				digit = Integer.parseInt(routingNumber.substring(i, i+1));
			} catch(Exception e) {
				return false;
			}
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}

		return checksum % 10 == 0;
	}
	
}
