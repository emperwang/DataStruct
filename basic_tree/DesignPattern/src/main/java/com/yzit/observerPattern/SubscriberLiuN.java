package com.yzit.observerPattern;
//订阅者一
public class SubscriberLiuN implements Observer, DisplayElement {
	private String paper;
	private Subject subject;

	public SubscriberLiuN(Subject subject) {
		this.subject = subject;
	}

	@Override
	public void display() {
		System.out.println("刘呢"+paper+"报纸出来了");
	}

	@Override
	public void update(String paper) {
		this.paper = paper;
		display();
	}

}
