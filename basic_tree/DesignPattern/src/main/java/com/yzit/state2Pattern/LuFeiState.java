package com.yzit.state2Pattern;

interface LuFeiState {
	public void change();
}

class Ordinary implements LuFeiState {

	@Override
	public void change() {
		System.out.println("路飞当前为普通状态战斗");
	}
}

class SecondGear implements LuFeiState {

	@Override
	public void change() {
		System.out.println("路飞当前为二档战斗");
	}
}

class ThirdGear implements LuFeiState {

	@Override
	public void change() {
		System.out.println("路飞当前为三档战斗");
	}
}

class FourthGear implements LuFeiState {

	@Override
	public void change() {
		System.out.println("路飞当前为四档战斗");
	}
}