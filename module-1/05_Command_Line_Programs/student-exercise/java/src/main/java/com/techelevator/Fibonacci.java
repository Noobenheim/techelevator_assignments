package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String endString;
		int end;
		
		System.out.print("Please enter the Fibonacci number: ");
		endString = scanner.nextLine();
		
		try {
			end = Integer.parseInt(endString);
			
			int fib1 = 0;
			int fib2 = 1;
			
			while( end > fib1+fib2 ) {
				if( fib1 == 0 && fib2 == 1 ) {
					System.out.print("0, 1");
				}
				System.out.print(", "+(fib1+fib2));
				int tmp = fib1;
				fib1 = fib2;
				fib2 = tmp+fib2;
			}
		} catch( NumberFormatException e ) {
			System.err.println("Invalid integer.");
		}
		
		scanner.close();
	}

}
