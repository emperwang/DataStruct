package com.yzit.decorator2Pattern;

public abstract class Clothes {
	String description = "unknow Clothes";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}
