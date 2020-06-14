package com.yzit.decoratorPattern;

public abstract class Decroator implements Component {
	protected Component component;
	
	public Decroator(Component component) {
		super();
		this.component = component;
	}
	
	@Override
	public void method() {
		this.component.method();
	}

}
