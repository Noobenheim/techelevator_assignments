package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TollCalculator {
	public static void main(String[] args) {
		List<Vehicle> vehicles = new ArrayList<>();
		Map<Vehicle,Integer> distance = new HashMap<>();
		
		vehicles.add(new Car(false));
		vehicles.add(new Car(true));
		vehicles.add(new Tank());
		vehicles.add(new Truck(4));
		vehicles.add(new Truck(6));
		vehicles.add(new Truck(8));
		
		distance.put(vehicles.get(0), 100);
		distance.put(vehicles.get(1), 75);
		distance.put(vehicles.get(2), 240);
		distance.put(vehicles.get(3), 150);
		distance.put(vehicles.get(4), 101);
		distance.put(vehicles.get(5), 180);
		
		int totalDistance = 0;
		double totalToll = 0.00;
		
		System.out.println("Vehicle\t\t\tDistance Traveled\tToll $");
		System.out.println("-----------------------------------------------------");
		for( Vehicle vehicle : vehicles ) {
			int traveled = distance.get(vehicle);
			double toll = vehicle.calculateToll(traveled);
			
			totalDistance += traveled;
			totalToll += toll;
			
			String output = String.format("%-18s\t%d\t\t\t$%.2f", vehicle, traveled, toll);
			System.out.println(output);
		}

		System.out.println("\nTotal Miles Traveled: "+totalDistance);
		System.out.format("Total Tollbooth Revenue: $%.2f", totalToll);
	}
}
