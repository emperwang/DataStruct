package com.yzit.observerPattern;

import java.util.ArrayList;
import java.util.List;

//一个主题具体的实现类
public class NewsPapers implements Subject {
	private List<Observer> observers;
	private String paper;

	//在初始化时  建立容器
	public NewsPapers() {
		this.observers = new ArrayList<>();
	}

	//观察者具体的订阅函数
	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	//移除观察者的函数
	@Override
	public void removeObserver(Observer observer) {
		int index = observers.indexOf(observer);
		if(index > 0){
			observers.remove(index);
		}
	}

	//当新报纸出来时  进行更新报纸的操作
	public void setMeasurements(String paper){
		this.paper = paper;
		measurementsChanged();
	}
	//设置报纸更改的函数
	public void measurementsChanged(){
		notifyObservers();
	}

	//通知订阅者(观察者的具体的函数)
	@Override
	public void notifyObservers() {
		for(int i=0;i<observers.size();i++){
			Observer observer = observers.get(i);
			observer.update(paper);
		}
	}
	
	
}
