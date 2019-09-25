package com.techelevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		
		List<String> names = new ArrayList<String>();
		names.add("Happy");
		names.add("Sleepy");
		names.add("Grumpy");
		names.add("Dopey");
		names.add("Doc");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
		
		for( int i=0; i<names.size(); i++ ) {
			String thisElement = names.get(i);
			
			System.out.println(thisElement);
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		names.add("Sleepy");
		
		for( int i=0; i<names.size(); i++ ) {
			System.out.println(names.get(i));
		}
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		names.add(4, "Tom");

		for( int i=0; i<names.size(); i++ ) {
			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		
		names.remove(4);
		
		for( int i=0; i<names.size(); i++ ) {
			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		
		boolean exists = names.contains("Tom");
		
		System.out.println(exists);

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		
		String[] arrayOfStrings = names.toArray(new String[names.size()]);
		
		for( int i=0; i<arrayOfStrings.length; i++ ) {
			System.out.println(arrayOfStrings[i]);
		}

		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");

		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation
		 * of a primitive value */
		
		List<Integer> scores = new ArrayList<Integer>();
		int numScores = ((int)(Math.random()*10)) + 10;
		
		for( int i=0; i < numScores; i++ ) {
			int score = (int)Math.round((Math.random()*50)+50);
			scores.add(score);
		}
		
		System.out.println(scores);

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		
		for( int i : scores ) {
			System.out.println(i);
		}

		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();
		
		Queue<String> priorities = new LinkedList<String>();
		priorities.offer("Clean the dishes");
		priorities.offer("Wash the counters");
		priorities.offer("Sweep the leg");
		priorities.offer("Scrub the floor");
		
		while( !priorities.isEmpty() ) {
			String firstPriority = priorities.poll();
			
			System.out.println("Your current priority is "+firstPriority);
		}

		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////

		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();
		
		Stack<String> browser = new Stack<String>();
		

		////////////////////
		// PUSHING ITEMS TO THE STACK
		////////////////////
		browser.push("google.com");
		browser.push("amazon.com");
		browser.push("techelevator.com");
		
		////////////////////
		// POPPING THE STACK
		////////////////////

		while( !browser.isEmpty() ) {
			String lastVisitedWebsite = browser.pop();
			System.out.println("You last visited "+lastVisitedWebsite);
		}
	}
}
