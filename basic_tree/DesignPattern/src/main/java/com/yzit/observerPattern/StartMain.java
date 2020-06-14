package com.yzit.observerPattern;

/**
 * 这个模式的观察者是主题给观察者发送消息  是推送
 * @author my
 *
 */
public class StartMain {
	public static void main(String[] args) {
		NewsPapers newsPapers = new NewsPapers();
		SubscriberLiuN subscriberLiuN = new SubscriberLiuN(newsPapers);
		SubscribeXieDa subscribeXieDa = new SubscribeXieDa(newsPapers);
		SubscribeWXM subscribeWXM = new SubscribeWXM(newsPapers);

		//订阅
		newsPapers.registerObserver(subscriberLiuN);
		newsPapers.registerObserver(subscribeXieDa);
		newsPapers.registerObserver(subscribeWXM);

		//发布消息
		newsPapers.setMeasurements("今日说法");
	}
}
