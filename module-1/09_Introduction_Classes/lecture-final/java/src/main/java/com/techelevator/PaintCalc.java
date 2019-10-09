package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaintCalc {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Wall> listOfWalls = new ArrayList<Wall>();


		
		
		System.out.println(Math.PI);
		
		while (true) {

			System.out.println();
			System.out.println("[1] Add a wall");
			System.out.println("[2] Calculate paint required (and Exit)");
			System.out.print("Please choose >>> ");
			String userChoice = scan.nextLine();

			System.out.println();

			if (userChoice.equals("1")) {

				System.out.print("Enter wall height >>> ");
				int height = Integer.parseInt(scan.nextLine());

				System.out.print("Enter wall width >>> ");
				int width = Integer.parseInt(scan.nextLine());

				Wall w = new Wall(height, width);
				System.out.println(
						"Added " + w.getHeight() + "x" + w.getWidth() + " wall - " + w.getArea() + " square feet");

				listOfWalls.add(w);

			} else if (userChoice.equals("2")) {

				// Here we need to sum up the areas of all walls that have been
				// entered
				int totalArea = 0;

				for (int i = 0; i < listOfWalls.size(); i++) {
					System.out.println("Wall " + (i + 1) + ": " + listOfWalls.get(i).getHeight() + "x"
							+ listOfWalls.get(i).getWidth() + " - " + listOfWalls.get(i).getArea() + " square feet");

					totalArea += listOfWalls.get(i).getArea();
				}

				System.out.println("===============================");
				System.out.println("Total Area: " + totalArea + " square feet");

				// 1 gallon of paint covers 400 square feet
				float gallonsRequired = (float) totalArea / 400;
				System.out.println("Paint Required: " + gallonsRequired + " gallons");

				System.exit(0); // Causes the program to end
			}
		}
	}

}
