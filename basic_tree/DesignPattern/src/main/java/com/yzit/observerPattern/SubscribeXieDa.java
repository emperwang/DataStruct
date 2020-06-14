package com.yzit.observerPattern;
//订阅者二
public class SubscribeXieDa implements Observer, DisplayElement {
	private String paper;
	private Subject subject;

	public SubscribeXieDa(Subject subject) {
		this.subject = subject;
	}

	@Override
	public void display() {
		System.out.println("大脚"+paper+"新报纸出来了");
	}

	@Override
	public void update(String paper) {
		this.paper = paper;
		display();
	}

}
