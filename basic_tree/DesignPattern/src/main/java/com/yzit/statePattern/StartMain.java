package com.yzit.statePattern;

public class StartMain {
	public static void main(String[] args) {
		LuFei luFei = new LuFei(LuFei.ORDINARY);
		luFei.change();
		System.out.println("-----------------------");
		luFei = new LuFei(LuFei.SECONDGAR);
		luFei.change();
		System.out.println("-----------------------");
		luFei = new LuFei(LuFei.THIRDGEAR);
		luFei.change();
		System.out.println("-----------------------");
		luFei = new LuFei(LuFei.FOURTHGEAR);
		luFei.change();
	}
}
