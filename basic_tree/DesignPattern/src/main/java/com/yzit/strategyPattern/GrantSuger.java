package com.yzit.strategyPattern;

public class GrantSuger implements GrantReward {

	@Override
	public void grantReward() {
		System.out.println("发糖");
	}

}
