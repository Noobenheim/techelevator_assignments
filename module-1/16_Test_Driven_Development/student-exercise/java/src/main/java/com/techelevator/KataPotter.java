package com.techelevator;

import java.util.Arrays;

public class KataPotter {
	public static final int BOOK_COST = 8;
	
	public static final double TWO_DISCOUNT = 0.05;
	public static final double THREE_DISCOUNT = 0.10;
	public static final double FOUR_DISCOUNT = 0.20;
	public static final double FIVE_DISCOUNT = 0.25;
	
	public double getCost(int[] books) {
		double cost = Double.MAX_VALUE; // to test if our solution is lower than this
		
		int differentBooks = getNumberOfDifferentBooks(books);
		
		// see most effective cost starting with highest set
		for( int i=differentBooks; i>0; i-- ) {
			int[] copyArray = Arrays.copyOf(books, books.length);
			double tempCost = 0.0;
			
			while( hasBooks(copyArray) ) {
				int removeCount = Math.min(i, getNumberOfDifferentBooks(copyArray));
				removeBooks(copyArray, removeCount);
				tempCost += BOOK_COST * removeCount * (1.0 - getDiscount(removeCount));
			}
			
			if( tempCost < cost )
				cost = tempCost;
		}
		return cost;
	}
	
	private void removeBooks(int[] books, int count) {
		for( int i=0; i<books.length && count > 0; i++ ) {
			if( books[i] > 0 ) {
				books[i]--;
				count--;
			}
		}
	}
	
	private boolean hasBooks(int[] books) {
		for( int i : books ) {
			if( i > 0 ) return true;
		}
		return false;
	}
	
	private int getNumberOfDifferentBooks(int[] books) {
		int differentBooks = 0;
		
		for( int i : books ) {
			if( i > 0 ) differentBooks++;
		}
		
		return differentBooks;
	}
	
	private double getDiscount(int set) {
		switch( set ) {
			case 2:
				return TWO_DISCOUNT;
			case 3:
				return THREE_DISCOUNT;
			case 4:
				return FOUR_DISCOUNT;
			case 5: 
				return FIVE_DISCOUNT;
		}
		
		return 0.0;
	}
}
