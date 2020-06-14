package com.yzit.state2Pattern;

public class StartMain {
	public static void main(String[] args) {
		LuFei luFei = new LuFei();
		luFei.setState(luFei.Ordinary);
		luFei.change();
		System.out.println("---------------------");
		luFei.setState(luFei.SecondGear);
		luFei.change();
		System.out.println("---------------------");
		luFei.setState(luFei.ThirdGear);
		luFei.change();
		System.out.println("---------------------");
		luFei.setState(luFei.FourthGear);
		luFei.change();
	}
}
