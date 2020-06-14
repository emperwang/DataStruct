package com.yzit.observer2Pattern;

import java.util.Observable;

public class Newspapers extends Observable {
	private String paper;
	
	public void setMeasurements(String paper){
		this.paper = paper;
		measuredmentsChanged();
	}
	
	public void measuredmentsChanged(){
		setChanged();
		notifyObservers();
	}
	
	public String getPaper(){
		return paper;
	}
}
