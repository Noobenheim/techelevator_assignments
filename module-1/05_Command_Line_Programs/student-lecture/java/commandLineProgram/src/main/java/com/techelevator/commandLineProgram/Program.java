package com.techelevator.commandLineProgram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		System.out.println("Let's Calculate Discounts");
		Scanner scanner = new Scanner(System.in);
		String productInput;
		String priceInput;
		String discountInput;
		double lastDiscount = Double.MAX_VALUE;
		
		class Product {
			private String name;
			private double price;
			private double discountedPrice;
			
			public Product(String name, double price, double discount) {
				this.name = name;
				this.price = price;
				discount(discount);
			}
			
			public double discount(double discount) {
				this.discountedPrice = this.price - discount * this.price;
				return this.discountedPrice;
			}
			public String getName() { return name; }
			public double getPrice() { return price; }
			public double getDiscountedPrice() { return discountedPrice; };
		}
		Comparator<Product> nameComparator = new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getName().compareTo(p2.getName());
			}	
		};
		Comparator<Product> priceComparator = new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getPrice() < p2.getPrice() ? -1 : p1.getPrice() == p2.getPrice() ? 0 : 1;
			}
		};
		Comparator<Product> discountComparator = new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getDiscountedPrice() < p2.getDiscountedPrice() ? -1 : p1.getDiscountedPrice() == p2.getDiscountedPrice() ? 0 : 1;
			}
		};
		
		List<Product> allProducts = new ArrayList<Product>();
		
		System.out.println("What is your name?");
		
		String name = scanner.nextLine();
		
		for( int i=0; i<=50; i++ ) {
			System.out.println("");
		}
		System.out.println("Hello "+name);
		for( int i=0; i<=5; i++ ) {
			System.out.println("");
		}
		System.out.println("\nPlease enter the information on your items. Leave empty when done.");
		
		do {
			System.out.print("\nWhat is the product name? ");
			productInput = scanner.nextLine();
			if( !productInput.trim().equals("") ) {
				try {
					System.out.print("What is your product price? ");
					priceInput = scanner.nextLine();
					System.out.print("What is your product discount (percent)? "+(lastDiscount==Double.MAX_VALUE?"":String.format("(hit enter to keep the same discount of %.2f%%) ", lastDiscount*100.0)));
					discountInput = scanner.nextLine();
					
					double price = Double.parseDouble(priceInput);
					double discount;
					if( discountInput.trim().equals("") ) {
						discount = lastDiscount;
					} else {
						discount = Double.parseDouble(discountInput)/100.0;
						lastDiscount = discount;
					}
					
					Product p = new Product(productInput, price, discount);
					allProducts.add(p);
					
					System.out.println("Successfully added "+p.getName()+" to product list.");
				} catch( NumberFormatException e ) {
					System.out.println("Invalid Input...\n");
				}
			}
		} while( !productInput.trim().equals(""));
		
		System.out.println("\n\nDiscounts calculated!");
		
		String input = null;
		do {
			if( input != null ) {
				boolean reverse = input.length() >= 2 && input.substring(1,2).equals("-");
				input = input.substring(0,1);
				for( int i=0; i<=50; i++ ) {
					System.out.println("");
				}
				Comparator<Product> comp = null;
				switch( input ) {
					case "P":
						comp = priceComparator;
						break;
					case "N":
						comp = nameComparator;
						break;
					case "D":
						comp = discountComparator;
						break;
				}
				
				if( comp != null ) {
					Collections.sort(allProducts, reverse?Collections.reverseOrder(comp):comp);
				}
			}
			for( Product p : allProducts ) {
				System.out.println(String.format("%-20s\t%.2f\t%.2f", p.getName(), p.getPrice(), p.getDiscountedPrice()));
			}
			
			System.out.println("\nHit Enter to Exit.\n\nHit N to sort by Name\nHit P to sort by Price\nHit D to sort by Discounted Price.\nType - after the letter to reverse the order.");
			input = scanner.nextLine().trim();
		} while( !input.equals("") );
		
		scanner.close();
	}
}
