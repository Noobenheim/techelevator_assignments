package com.techelevator;

public class SPU implements DeliveryDriver {
	public enum RateType {
		GROUND_4DAY ("4-Day Ground"),
		BUSINESS_2DAY ("2-Day Business"),
		NEXT_DAY ("Next Day");
		
		private final String name;
		RateType(String name) {
			this.name = name;
		}
		public String toString() {
			return this.name;
		}
	}
	
	private RateType type;
	
	public SPU(RateType type) {
		this.type = type;
	}

	@Override
	public double calculateRate(int distance, double weight) {
		weight /= 16;
		switch( type ) {
			case GROUND_4DAY:
				return (weight * 0.0050) * distance;
			case BUSINESS_2DAY:
				return (weight * 0.050) * distance;
			case NEXT_DAY:
			default:
				return (weight * 0.075) * distance;
		}
	}

	@Override
	public String getName() {
		return "SPU";
	}

	public String toString() {
		return getName()+" ("+type+")";
	}
}
