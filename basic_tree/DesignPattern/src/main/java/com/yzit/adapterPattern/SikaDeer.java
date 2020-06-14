package com.yzit.adapterPattern;

public class SikaDeer implements Deer {

	@Override
	public void run() {
		System.out.println("i am running");
	}

	@Override
	public void eatGrass() {
		System.out.println("i am eating grass");
	}

}
