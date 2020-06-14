package com.yzit.decoratorPattern;

public class ConcreteDecoratorA extends Decroator {

	public ConcreteDecoratorA(Component component) {
		super(component);
	}
	
	public void methodA(){
		System.out.println("装饰者A的扩展功能");
	}

	public void method(){
		System.out.println("针对该方法增加一层A包装");
		super.method();
		System.out.println("A包装结束");
	}
}
