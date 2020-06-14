package com.yzit.adapterPattern;

public class SnowAdapter implements Deer {
	private SnowWolf snowWolf;
	
	public SnowAdapter(SnowWolf snowWolf) {
		this.snowWolf = snowWolf;
	}
	
	@Override
	public void run() {
		snowWolf.run();
	}

	@Override
	public void eatGrass() {
		snowWolf.eatMeat();
	}
	
	
}
