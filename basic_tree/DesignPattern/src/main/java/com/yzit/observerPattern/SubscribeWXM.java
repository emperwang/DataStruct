package com.yzit.observerPattern;


//观察者三
public class SubscribeWXM implements Observer, DisplayElement {
	private String paper;
	private Subject subject;

	public SubscribeWXM(Subject subject) {
		this.subject = subject;
	}

	@Override
	public void display() {
		System.out.println("王小蒙"+paper+"新报纸出来了");
	}

	@Override
	public void update(String paper) {
		this.paper = paper;
		display();
	}

}
