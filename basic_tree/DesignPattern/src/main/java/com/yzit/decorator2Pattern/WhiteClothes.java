package com.yzit.decorator2Pattern;

public class WhiteClothes extends Clothes {
	
	public WhiteClothes() {
		description = "white clothes";
	}
	
	@Override
	public double cost() {
		return 30;
	}
	
}
