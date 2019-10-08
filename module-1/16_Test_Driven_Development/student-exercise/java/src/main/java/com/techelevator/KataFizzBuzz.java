package com.techelevator;

public class KataFizzBuzz {
	public String fizzBuzz(int number) {
		String output = "";
		String input = Integer.toString(number);
		boolean has5 = input.indexOf('5') >= 0;
		boolean has3 = input.indexOf('3') >= 0;
		
		if( (number%3 == 0 && number > 0) || has3 ) {
			output += "Fizz";
		}
		if( (number%5 == 0 && number > 0) ) {
			output += "Buzz";
			
			return output;
		}
		
		if( has5 ) {
			output = "Buzz";
		}
		if( has3 && has5 ) {
			output = "FizzBuzz";
		}
		
		if( output.equals("") && number >= 1 && number <= 100 ) {
			output += number;
		}
		
		return output;
	}
}
