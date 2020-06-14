package com.yzit.observer2Pattern;

public class StartMain {
	public static void main(String[] args) {
		Newspapers newspapers = new Newspapers();
		SubscribeLN subscribeLN = new SubscribeLN(newspapers);
		SubscribeXDJ subscribeXDJ = new SubscribeXDJ(newspapers);
		SubscribeWXM subscribeWXM = new SubscribeWXM(newspapers);
		
		//注册
		newspapers.addObserver(subscribeLN);
		newspapers.addObserver(subscribeXDJ);
		newspapers.addObserver(subscribeWXM);

		//发布消息
		newspapers.setMeasurements("今日说法");
	}
}
