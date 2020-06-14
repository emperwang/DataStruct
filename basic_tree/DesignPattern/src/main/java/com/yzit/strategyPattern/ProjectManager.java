package com.yzit.strategyPattern;


public class ProjectManager extends Staff {
	
	public ProjectManager() {
		this.setGrantRewards(new GrantSuger());
	}
}
