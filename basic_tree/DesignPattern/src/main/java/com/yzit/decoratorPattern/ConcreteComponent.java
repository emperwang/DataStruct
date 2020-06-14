package com.yzit.decoratorPattern;

public class ConcreteComponent implements Component {

	@Override
	public void method() {
		System.out.println("原来的方法");
	}
}
