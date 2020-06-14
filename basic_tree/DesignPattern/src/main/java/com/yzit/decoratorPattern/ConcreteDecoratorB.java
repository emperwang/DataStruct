package com.yzit.decoratorPattern;

public class ConcreteDecoratorB extends Decroator {

	public ConcreteDecoratorB(Component component) {
		super(component);
	}
	
	public void methodB(){
		System.out.println("装饰者B扩展功能");
	}

	public void method(){
		System.out.println("针对该方法加一层B包装");
		super.method();
		System.out.println("B包装结束");
	}
}
