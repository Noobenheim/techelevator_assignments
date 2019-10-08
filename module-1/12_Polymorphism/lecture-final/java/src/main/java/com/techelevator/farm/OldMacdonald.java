package com.techelevator.farm;

import java.util.Map;
import java.util.TreeMap;

public class OldMacdonald {
	public static void main(String[] args) {
				
		/*
		Character zero = new Character('0');
		String one = "Literally";
		String two = "Anything";
		Boolean three = new Boolean(false);
		Integer four = new Integer(12);
		Chicken five = new Chicken();
		
		Object[] nonsense = new Object[] {zero, one, two, three, four, five };

		String uno = nonsense[1];
		Chicken ch2 = (Chicken)nonsense[5];
		ch2.layEgg();
		one.substring(4);
		
		
		Chicken getTheElementOut = (Chicken)nonsense[2];
		getTheElementOut.layEgg();
		
//		nonsense[1].substring(2, 4);
		*/
		
		
//		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Chicken(), new Cow(), new Tractor() };

		Singable[] singableThings = new Singable[] { new Tractor(), new RhodeIslandRed(), new Cow() };
		
		
		for(Singable s : singableThings) {
			String name = s.getName();
			String sound = s.getSound();

			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();		
		}

//		Cow c = new Cow();
//		System.out.print(c.toString());
//		System.out.println(c.makeNoise(100));
//		
		
		//FarmAnimal f = new FarmAnimal("Generic Farm Animal", "Generic Sound");
		//System.out.println(f.makeNoise(100));

//		System.out.println("Total animals: " + f.getNumberOfAnimals());
	}	
		
		/*		
		for (FarmAnimal animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();			
			
			
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}
	}
	*/
}