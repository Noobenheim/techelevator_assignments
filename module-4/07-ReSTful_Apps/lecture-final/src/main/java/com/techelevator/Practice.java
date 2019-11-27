package com.techelevator;

import java.util.Arrays;

public class Practice {
	
	public static void main(String[] args) {
		
		int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		
		int[] evens = Arrays.stream(numbers).filter(i -> i % 2 == 0).toArray();
	
		for(int even : evens) {
			System.out.println(even);
		}
		
		// does the array contain a 2?
		boolean containsTwo = Arrays.stream(numbers).anyMatch(i -> i == 2);
		
		
		
		String[] ppl = {"Tom", "Tom", "Andrew", "Beth", "Justin", "Marissa", "Caitie", "Ellen", "Gina"};
		
		boolean containsGina = false;
		
		containsGina = Arrays.stream(ppl).anyMatch(s -> s.equalsIgnoreCase("gina"));
		
		if(containsGina) {
			System.out.println("Daaaaaaaamn");
		}
	}
}
