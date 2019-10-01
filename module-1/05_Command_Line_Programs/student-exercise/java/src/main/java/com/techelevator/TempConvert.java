package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String tempString, unitString;
		
		System.out.print("Please enter the temperature: ");
		tempString = scanner.nextLine();
		System.out.print("Is the temperature in (C)elcius, or (F)arenheit? ");
		unitString = scanner.nextLine();
		
		try {
			double temp = Double.parseDouble(tempString);
			if( !unitString.equalsIgnoreCase("f") && !unitString.equalsIgnoreCase("c") ) {
				System.err.println("Invalid unit: "+unitString);
			} else {
				double converted = unitString.equalsIgnoreCase("f") ?
										(temp-32) / 1.8 :
										temp * 1.8 + 32;
				System.out.println(tempString+unitString.toUpperCase()+" is "+(int)converted+(unitString.equalsIgnoreCase("f")?"C":"F"));
			}
		} catch(NumberFormatException e) {
			System.err.println("Invalid number: "+tempString);
		}
		
		scanner.close();
	}
}
