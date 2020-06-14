package com.yzit.strategyPattern;

public class GrantMoonCake implements GrantReward {

	@Override
	public void grantReward() {
		System.out.println("发月饼");
	}

}
