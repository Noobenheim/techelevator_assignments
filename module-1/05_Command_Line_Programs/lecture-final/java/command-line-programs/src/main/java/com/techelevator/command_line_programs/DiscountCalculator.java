package com.techelevator.command_line_programs;

import java.util.Scanner;

public class DiscountCalculator {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);

		System.out.println("Welcome, would you like to calculate a discount?");

		System.out.println("What is your name?:");
		String jerkName = inputScanner.nextLine();
		System.out.println("<sarcasm> Hellooooo " + jerkName + "</sarcasm>");
		System.out.println("Please provide a series of prices (space-separated)");

		String pricesString = inputScanner.nextLine();
		// System.out.println("debugging: " + pricesString);

		String[] individualPriceStrings = pricesString.split(" ");

		double[] prices = new double[individualPriceStrings.length];

		for (int i = 0; i < prices.length; i++) {

			// Turn the string at indivual[i] into a double
			double price = Double.parseDouble(individualPriceStrings[i]);

			// store the double in prices [i]
			prices[i] = price;

		}

		double discountPercentage = 0.9;

		// karen or trent
		if (jerkName.equals("Karen") || jerkName.equalsIgnoreCase("trent")) {
			discountPercentage = 1.0; // They're the worst

		} else if (jerkName.equals("Sarah")) { // sarah
			discountPercentage = 0.8;

		} else { // all the other schmucks
			discountPercentage = 0.9;
		}
		
		System.out.print("Your discounted prices are: ");
		for(int i = 0; i < prices.length; i++) {
			prices[i] *= discountPercentage;
			System.out.print("$" + prices[i] + " ");
		}
		System.out.println();

	}
}
