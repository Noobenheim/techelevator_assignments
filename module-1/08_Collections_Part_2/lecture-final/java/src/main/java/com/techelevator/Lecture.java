package com.techelevator;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("       MAPS");
		System.out.println("####################");
		System.out.println();

		/* Map is an interface and HashMap is a class that implements Map */
		//   key      value
		Map<Integer, String> zipcodes = new TreeMap<Integer, String>();
		
		/* The "put" method is used to add elements to a Map */
		zipcodes.put(15222, "Pittsburgh");
		zipcodes.put(90210, "Beverly Hills");
		zipcodes.put(15224, "HOUSE OF METAL!!1LOLZ");
		zipcodes.put(97123, "Portland");
		zipcodes.put(33322, "Fort Lauderdale");

		/* The "get" method is used to retrieve elements from a Map 
		System.out.println("Getting zip code 10101: ");
		System.out.println(zipcodes.get(10101));
		System.out.println(zipcodes.containsKey(10101));
		System.out.println(zipcodes.size());
			*/
		
		/* keySet returns a Set of all of the keys in the Map 
		System.out.println("#### BEFORE #####");
		for(Integer key : zipcodes.keySet()) {			
			System.out.println("Key: " + key);
			
			String city = zipcodes.get(key);
			
			System.out.println("\tValue: " + city);
		}
		*/
		
		/* If the key already exists, put will overwrite the existing value with the new value */

		zipcodes.put(15224, "Tech Elevator");
		
		
		for(Integer key : zipcodes.keySet()) {			
			System.out.println("Key: " + key);			
			System.out.println("\tValue: " + zipcodes.get(key));
		}
		
		System.out.println("I have no values.");
		for(String value : zipcodes.values()) {
			System.out.println(value);
		}
		
		
 */
		System.out.println("####################");
		System.out.println("       SETS");
		System.out.println("####################");
		System.out.println();

		// DECLARATION         INSTANTIATION       INITIALIZAION (empty)
		Set<String> students = new TreeSet<String>();
		
		System.out.println("####################");
		System.out.println("Sets cannot contain duplicates");
		System.out.println("####################");
		System.out.println();


		students.add("Tom");
		students.add("Todd");		
		students.add("Tom Anderson");
		students.add("Beth");
		students.add("Andrew");
		students.add("Justin");
		students.add("Tom");
		students.add("Marissa");
		students.add("Justin");
		students.add("Caitie");
		students.add("Tom");
		students.add("Tom");
		students.add("Tom");

		
		students.size();
		
		
		for(String student : students) {
			System.out.println(student);
		}

		System.out.println("Removing Mr Anderson...");
		students.remove("Tom Anderson");
		for(String student : students) {
			System.out.println(student);
		}
		
/*
		System.out.println("####################");
		System.out.println("Sets do not guarantee ordering");
		System.out.println("####################");
		System.out.println();

*/

	}

}
