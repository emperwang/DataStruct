package com.yzit.adapter2Pattern;

public class Adapter extends Adaptee implements Target{
	/**
	 * 此时在adapter中就把Adaptee中转换了，这个类通过这个适配器就拥有了simpleOperation2方法
	 */
	@Override
	public void sampleOPeration2() {
		
	}
	
}
