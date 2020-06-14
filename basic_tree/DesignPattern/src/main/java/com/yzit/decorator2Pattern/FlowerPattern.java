package com.yzit.decorator2Pattern;

public class FlowerPattern extends Pattern {
	
	private Clothes clothes;
	
	public FlowerPattern(Clothes clothes) {
		this.clothes = clothes;
	}

	@Override
	public double cost() {

		return 10+clothes.cost();
	}

	@Override
	public String getDescription() {
		return clothes.getDescription()+", flower--pattern";
	}
}
