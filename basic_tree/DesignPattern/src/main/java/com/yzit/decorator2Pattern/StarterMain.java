package com.yzit.decorator2Pattern;

public class StarterMain {
	public static void main(String[] args) {
		Clothes clothes = new BlueClothes();
		Clothes clothes1  = new FlowerPattern(clothes);
		Clothes clothes2 = new GrassPattern(clothes1);
		
		System.out.println(clothes2.getDescription()+"  $"+clothes2.cost());
	}
}
