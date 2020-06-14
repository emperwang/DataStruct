package com.yzit.strategyPattern;

public class GeneralStaff extends Staff {
	public GeneralStaff() {
		this.setGrantRewards(new GrantNone());
	}
}
