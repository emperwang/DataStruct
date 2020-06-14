package com.yzit.decorator2Pattern;

public class GrassPattern extends Pattern {
	private Clothes clothes;
	
	public GrassPattern(Clothes clothes) {
		this.clothes = clothes;
	}
	
	@Override
	public String getDescription() {
		return this.clothes.getDescription()+",  grass--clothes";
	}

	@Override
	public double cost() {
		return 5+clothes.cost();
	}

}
