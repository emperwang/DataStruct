package com.yzit.adapterPattern;

public class Startmain {
	
	public static void testDeer(Deer deer){
		deer.eatGrass();
		deer.run();
	}
	
	public static void main(String[] args) {
		Deer sikaDeer = new SikaDeer();
		SnowWolf snowWolf = new SnowWolf();
		SnowAdapter snowAdapter = new SnowAdapter(snowWolf);
		
		System.out.println("snow wolf");
		snowWolf.run();
		snowWolf.eatMeat();
		System.out.println("-----------------------");
		System.out.println("sikaDeer says");
		testDeer(sikaDeer);
		System.out.println("-----------------------");
		System.out.println("snowAdapter says");
		testDeer(snowAdapter);
	}
	
}
