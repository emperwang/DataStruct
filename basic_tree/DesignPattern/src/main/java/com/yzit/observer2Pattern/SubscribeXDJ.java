package com.yzit.observer2Pattern;

import com.yzit.observerPattern.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class SubscribeXDJ implements Observer, DisplayElement {
	private String paper;
	private Observable observable;
	
	public SubscribeXDJ(Observable observable) {
		this.observable = observable;
	}
	
	@Override
	public void display() {
		System.out.println("谢大脚"+paper+"新报纸出来了");
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Newspapers){
			Newspapers newspapers = (Newspapers) o;
			this.paper = newspapers.getPaper();
			display();
		}
	}

}
