package com.yzit.strategyPattern;

public class GrantNone implements GrantReward {

	@Override
	public void grantReward() {
		System.out.println("什么都不发");
	}

}
