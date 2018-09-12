package com.fj.nitin;

import java.util.ArrayList;
import java.util.List;

public class SuperVsExtends {

	public static void main(String[] args) {
		List<Number> floats = new ArrayList<>();
		floats.add(Float.valueOf(1.2f));
		floats.add(Integer.valueOf(100));
		floats.add(100.99d);
		SuperVsExtends superVsExtends=new SuperVsExtends();
		superVsExtends.printNumbers(floats);
		superVsExtends.fillNumbers(floats);
	}

	
	public void printNumbers(List<? extends Number> list) {
		for (Number number : list) {
			System.out.print(number);
			System.out.print(", ");
		}
	}

	public void fillNumbers(List<? super Number> list) {
		Number n = Integer.MAX_VALUE;
		list.add(n);
		list.add(3);
		list.add(3.99f);
		list.add(399l);
		System.out.println();
		list.forEach(e -> System.out.print("  "+e.toString()));
		
	}
}
