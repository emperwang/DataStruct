package com.yzit.decorator2Pattern;

public class RedClothes extends Clothes {
	
	public RedClothes() {
		description = "red Clothes";
	}
	
	@Override
	public double cost() {
		return 50;
	}

}
