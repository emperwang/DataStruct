package com.yzit.strategyPattern;

public class DivisionManager extends Staff {
	public DivisionManager() {
		this.setGrantRewards(new GrantMoonCake());
	}
}
