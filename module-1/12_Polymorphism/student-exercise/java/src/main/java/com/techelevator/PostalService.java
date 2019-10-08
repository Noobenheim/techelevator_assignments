package com.techelevator;

import java.util.LinkedHashMap;
import java.util.Map;

public class PostalService implements DeliveryDriver {
	public enum Class {
		FIRST ("1st Class"),
		SECOND ("2nd Class"),
		THIRD ("3rd Class");
		
		private final String name;
		Class(String name) {
			this.name = name;
		}
		public String toString() {
			return this.name;
		}
	}
	public enum Weight {
		OZ_2 (2),
		OZ_8 (8),
		OZ_15 (15),
		OZ_16 (16),
		OZ_128 (128),
		OZ_MORE (Double.MAX_VALUE);
		
		private final double val;
		Weight(double num) {
			val = num;
		}
		public double getWeight() { return val; }
	}
	
	private Class postalClass;
	Map<Class,Map<Weight,Double>> rates = new LinkedHashMap<>();
	
	public PostalService(Class postalClass) {
		this.postalClass = postalClass;
		// set rates
		//// init all maps for classes
		for( Class c : Class.values() ) {
			rates.put(c, new LinkedHashMap<>());
		}
		
		// put values in
		// first
		setRates(Class.FIRST,
			new double[] { 0.035,  0.040,  0.047,  0.195,  0.450,  0.500 }
		);
		setRates(Class.SECOND,
			new double[] { 0.0035, 0.0040, 0.0047, 0.0195, 0.0450, 0.0500 }
		);
		setRates(Class.THIRD,
			new double[] { 0.0020, 0.0022, 0.0024, 0.0150, 0.0160, 0.0170 }
		);
	}
	
	private void setRates(Class clazz, double[] rates) {
		Map<Weight,Double> rate = this.rates.get(clazz);
		Weight[] weights = Weight.values();
		
		// sanity check
		if( rates.length != weights.length ) {
			throw new IllegalArgumentException("Rates must be of length "+rates.length);
		}
		
		for( int i=0; i<weights.length; i++ ) {
			rate.put(weights[i], rates[i]);
		}
	}

	@Override
	public double calculateRate(int distance, double weight) {
		Weight[] weights = Weight.values();
		
		int i;
		for( i=0; weights[i].val < weight; i++ );
		
		return rates.get(this.postalClass).get(weights[i]) * distance;
	}

	@Override
	public String getName() {
		return "Postal Service";
	}
	
	public String toString() {
		return getName() + " ("+this.postalClass+")";
	}
}
