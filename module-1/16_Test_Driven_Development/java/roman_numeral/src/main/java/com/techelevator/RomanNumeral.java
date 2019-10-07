package com.techelevator;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeral {
	private static Map<Integer,String> chars = new LinkedHashMap<>(); // linked list to keep the format of numbers added
	
	// set up chars Map by inputting numbers from highest to lowest
	static {
		chars.put(1000, "M");
		chars.put(900, "CM");
		chars.put(500, "D");
		chars.put(400, "CD");
		chars.put(100, "C");
		chars.put(90, "XC");
		chars.put(50, "L");
		chars.put(40, "XL");
		chars.put(10, "X");
		chars.put(9, "IX");
		chars.put(5, "V");
		chars.put(4, "IV");
		chars.put(1, "I");
	}

	public static String convert(int number) {
		String output = "";
		
		// ensure the number is greater than 0
		if( number > 0 ) {
			// loop through the chars Map using entries so we can grab the key (number) and value (symbol)
			for( Map.Entry<Integer, String> entry : chars.entrySet() ) {
				// if the number is bigger than the current entry, keep adding that value to the output until the number is less than that entry
				while( entry.getKey() <= number ) {
					output += entry.getValue();
					number -= entry.getKey();
				}
			}
		} else { // return null if number is less than or equal to 0
			output = null;
		}
		
		return output;
	}
}
