package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("       MAPS");
		System.out.println("####################");
		System.out.println();

		/* Map is an interface and HashMap is a class that implements Map */
		
		Map<Integer,String> zipcodes = new HashMap<Integer,String>();
		
		/* The "put" method is used to add elements to a Map */
		
		zipcodes.put(15222, "Pittsburgh");
		zipcodes.put(90210, "Beverly Hills");
		zipcodes.put(15224, "HOUSE OF METAL!!1LOLZ");
		zipcodes.put(97123, "Portland");
		zipcodes.put(33322, "Fort Lauderdale");

		/* The "get" method is used to retrieve elements from a Map */
		System.out.println("Getting zip code 10101:");
		System.out.println(zipcodes.get(101010));
		System.out.println("Does key have a value? "+zipcodes.containsKey(10101));
		System.out.println(zipcodes.size());
	
		/* keySet returns a Set of all of the keys in the Map */
		
		System.out.println("#### BEFORE ####");
		for( Integer key : zipcodes.keySet() ) {
			System.out.println(key.hashCode()+" Key: " + key + " Value: "+zipcodes.get(key));
		}
		
		/* If the key already exists, put will overwrite the existing value with the new value */

		System.out.println("#### AFTER ####");
		zipcodes.put(15224, "Tech Elevator");
		for( Integer key : zipcodes.keySet() ) {
			System.out.println(key.hashCode()+" Key: " + key + " Value: "+zipcodes.get(key));
		}


		System.out.println("####################");
		System.out.println("       SETS");
		System.out.println("####################");
		System.out.println();

		Set<String> students = new HashSet<String>();

		System.out.println("####################");
		System.out.println("Sets cannot contain duplicates");
		System.out.println("####################");
		System.out.println();

		students.add("Tom");
		students.add("Todd");
		System.out.println(students.size());
		students.add("Tom");
		System.out.println(students.size());
		
		students.add("Justin");
		students.add("Caitie");
		students.add("Ellen");
		students.add("Beth");
		students.add("Andrew");
		students.add("Justin");
		students.add("Marissa");

		System.out.println("####################");
		System.out.println("Sets do not guarantee ordering");
		System.out.println("####################");
		System.out.println();
		
		for( String student : students ) {
			System.out.println(student);
		}
	}

}
