package com.yzit.statePattern;

public class LuFei {
	public final static int ORDINARY = 0;
	public final static int SECONDGAR = 1;
	public final static int THIRDGEAR = 2;
	public final static int FOURTHGEAR = 3;
	
	private int state = ORDINARY;
	
	public LuFei(int state) {
		this.state = state;
	}
	
	public void change(){
		if(state == SECONDGAR){
			System.out.println("路飞开启二档战斗");
		}else if(state == THIRDGEAR){
			System.out.println("路飞开发三档战斗");
		}else if(state == FOURTHGEAR){
			System.out.println("路飞开启四档战斗");
		}else{
			System.out.println("路飞当前为普通模式");
		}
	}
}
