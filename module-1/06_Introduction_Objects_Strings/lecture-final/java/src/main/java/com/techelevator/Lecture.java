package com.techelevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.xml.bind.SchemaOutputResolver;

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

		for(int i = 0; i < names.size(); i++) {
			String thisElement = names.get(i);
			
			System.out.println(thisElement);
			
		}
		
		
		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		names.add("Sleepy");
		for(int i = 0; i < names.size(); i++) {			
			System.out.println(names.get(i));
		}
				

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		
		names.add(4, "Tom");
		for(int i = 0; i < names.size(); i++) {			
			System.out.println(names.get(i));
		}
		
		
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		//names.remove(4);
		for(int i = 0; i < names.size(); i++) {			
			System.out.println(names.get(i));
		}

		
		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		boolean hasMe = names.contains("Tom");
		System.out.println(hasMe);
		

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		
		String[] arrayOfStrings = names.toArray(new String[names.size()]);		

		for(int i = 0; i < arrayOfStrings.length; i++) {
			System.out.println(arrayOfStrings[i]);
		}
				
		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");

		List<Integer> scores = new ArrayList<Integer>();
		scores.add(new Integer(3));
		scores.add(new Integer(0));
		scores.add(2);
		
		Integer employees = new Integer(25);
		Integer piecesOfCake = new Integer(24);
		
		if(employees > piecesOfCake) {
			System.out.println("Burn the building down");
		}
		
		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation
		 * of a primitive value */

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		
		for(String name: names) {
			name += " The Great!";
			System.out.println(name);
		}
		
		
		
		
		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();

		Queue<String> priorities = new LinkedList<String>();
		priorities.offer("Clean the dishes");
		priorities.offer("Wash the counters");
		priorities.offer("Sweep the floor");
		priorities.offer("Scrub the floor");
		
		
		for(String priority : priorities) {
			System.out.println(priority);
		}
		
		
		while(!priorities.isEmpty()) {
			String nextPriority = priorities.poll();
			System.out.println("NEXT PRIORITY: " + nextPriority);
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
		System.out.println(browser.size());
		browser.push("google.com");
		System.out.println(browser.size());
		browser.push("amazon.com");
		System.out.println(browser.size());
		browser.push("techelevator.com");
		System.out.println(browser.size());
		
		for(String website : browser) {
			System.out.println(website);
		}
		
		////////////////////
		// POPPING THE STACK
		////////////////////

		while(browser.size() > 0) {
			String lastVisitedWebsite = browser.pop();
			System.out.println("You last visited: " + lastVisitedWebsite);
		}
		
	}
}
