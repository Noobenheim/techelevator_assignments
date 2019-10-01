package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String distanceString, unitString;
		
		System.out.print("Please enter the length: ");
		distanceString = scanner.nextLine();
		System.out.print("Is the measurement in (m)eter, or (f)eet? ");
		unitString = scanner.nextLine();
		
		try {
			double distance = Double.parseDouble(distanceString);
			if( !unitString.equalsIgnoreCase("f") && !unitString.equalsIgnoreCase("m") ) {
				System.err.println("Invalid unit: "+unitString);
			} else {
				double converted = unitString.equalsIgnoreCase("f") ?
										distance * 0.3048 :
										distance * 3.2808399;
				System.out.println(distanceString+unitString.toLowerCase()+" is "+(int)converted+(unitString.equalsIgnoreCase("f")?"m":"f"));
			}
		} catch(NumberFormatException e) {
			System.err.println("Invalid number: "+distanceString);
		}
		
		scanner.close();
	}
}
