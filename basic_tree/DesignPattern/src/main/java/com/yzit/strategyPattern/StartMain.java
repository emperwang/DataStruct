package com.yzit.strategyPattern;
/**
 * 策略设计模式，把具体算法抽象出来，然后使用一个类去具体的实现
 * 在实用算法和算法实现上解耦，需要那个算法只需要注入具体的类就可以了
 * @author my
 *
 */
public class StartMain {
	public static void main(String[] args) {
		GeneralStaff generalStaff = new GeneralStaff();
		ProjectManager projectManager = new ProjectManager();
		DivisionManager divisionManager = new DivisionManager();
		
		generalStaff.grantReward();
		projectManager.grantReward();
		divisionManager.grantReward();
	}
}
