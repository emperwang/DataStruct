package com.yzit.decorator2Pattern;

public class BlueClothes extends Clothes {
	
	public BlueClothes() {
		description = "Blue clothes";
	}
	
	@Override
	public double cost() {
		return 40;
	}
	
}
