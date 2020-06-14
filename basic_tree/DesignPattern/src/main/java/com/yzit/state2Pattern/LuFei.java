package com.yzit.state2Pattern;

public class LuFei {
	public static final LuFeiState Ordinary = new Ordinary();
	public static final LuFeiState SecondGear = new SecondGear();
	public static final LuFeiState ThirdGear = new ThirdGear();
	public static final LuFeiState FourthGear = new FourthGear();
	
	private LuFeiState state = Ordinary;
	
	public void setState(LuFeiState state) {
		this.state = state;
	}	
	public void change(){
		state.change();
	}
}
