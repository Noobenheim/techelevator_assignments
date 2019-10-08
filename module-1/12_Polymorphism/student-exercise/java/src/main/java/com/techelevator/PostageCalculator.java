package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostageCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int weight;
		int distance;
		
		System.out.print("Please enter the weight of the package? ");
		weight = intify(scanner.nextLine());
		System.out.print("(P)ounds or (O)unces? ");
		String input = scanner.nextLine().trim().toUpperCase();
		if( !input.equals("P") && !input.equals("O") ) {
			System.err.println("Unknown measurement.");
			System.exit(0);
		}
		if( input.equals("P") )
			weight *= 16;
		System.out.print("What distance will it be traveling? ");
		distance = intify(scanner.nextLine());
		
		List<DeliveryDriver> drivers = new ArrayList<>();
		drivers.add(new PostalService(PostalService.Class.FIRST));
		drivers.add(new PostalService(PostalService.Class.SECOND));
		drivers.add(new PostalService(PostalService.Class.THIRD));
		drivers.add(new FexEd());
		drivers.add(new SPU(SPU.RateType.GROUND_4DAY));
		drivers.add(new SPU(SPU.RateType.BUSINESS_2DAY));
		drivers.add(new SPU(SPU.RateType.NEXT_DAY));
		
		System.out.println("Delivery Method                 $ cost");
		System.out.println("--------------------------------------");
		String format = "%-32s$%.2f\n";
		for( DeliveryDriver dd : drivers ) {
			System.out.format(format, dd, dd.calculateRate(distance, weight));
		}
		
		scanner.close();
	}
	
	public static int intify(String input) {
		int ret = -1;
		try {
			ret = Integer.parseInt(input);
		} catch( NumberFormatException e ) {
			System.err.println("Unknown number: "+input);
			System.exit(0);
		}
		return ret;
	}
}
