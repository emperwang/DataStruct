package com.yzit.adapterPattern;

public class SnowWolf implements Wolf{

	@Override
	public void run() {
		System.out.println("i am running wolf");
	}

	@Override
	public void eatMeat() {
		System.out.println("i am eating meats");
	}
	
}
