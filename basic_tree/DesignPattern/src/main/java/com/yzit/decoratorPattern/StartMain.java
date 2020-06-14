package com.yzit.decoratorPattern;

public class StartMain {
	public static void main(String[] args) {
		//原来的对象
		Component component = new ConcreteComponent();
		component.method(); //原来的方法
		System.out.println("-----原来的方法------------");

		//装饰者A
		ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA(component);

		concreteDecoratorA.method(); //装饰后的方法
		concreteDecoratorA.methodA(); //A 扩展的方法
		System.out.println("--------装饰后的方法A-------------");
		ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB(component);
		concreteDecoratorB.method();
		concreteDecoratorB.methodB();
		System.out.println("---------装饰后的方法B------------");
		concreteDecoratorB = new ConcreteDecoratorB(concreteDecoratorA);
		concreteDecoratorB.method();
		System.out.println("---------多层装饰------------");
	}
}
