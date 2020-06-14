package com.yzit.strategyPattern;

public abstract class Staff {
	private GrantReward grantRewards;
	
	public void grantReward(){
		grantRewards.grantReward();
	}

	public void setGrantRewards(GrantReward grantRewards) {
		this.grantRewards = grantRewards;
	}
	
	
}
