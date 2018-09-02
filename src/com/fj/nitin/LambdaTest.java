package com.fj.nitin;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface Area {
	double getAreaOfRectangle(double w, double l);
}

public class LambdaTest {

	public static void main(String[] args) {
		String name = "Hello Lambda";
		double length = 3.d;
		double width = 4d;
		double area = getAreaOfRectangle(length, width);
		System.out.println(area);

		Area rectAreaAny = (double w, double l) -> {

			return w * l;
		};
		Area rectArea2 = (double w, double l) -> {
			System.out.println("value of width" + w);
			System.out.println("value of length" + l);
			return w * l;
		};
		// Multiple parameter
		Area rectArea = (double w, double l) -> w * l;
		// Not a compile time java 8 is smart he know the type
		Area rectArea1 = (w, l) -> w * l;
		System.out.println(rectArea.getAreaOfRectangle(10, 40));
		
		Function<Integer ,Integer> sum =( x) -> x=1;
		BiFunction<Integer ,Integer,Integer> sumProduct=(Integer x,Integer y) -> x+y;

		//// Zero Parameters
		Runnable r = () -> System.out.println("Hello, world!");
		r.run();
		/**
		 * What is Lambda A lambda expression is a block of code that you can pass
		 * around so it can be executed later, just once or multiple times. It is a
		 * block of code with or without parameters.
		 */
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);

		for (Map.Entry<String, Integer> entry : items.entrySet()) {
			System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
		}

		/**
		 * Life cysle of Lambda expression Convert lambda expression to the function
		 * call the general method.
		 */
		items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));

		/// Lambda Parameters

	}

	private static double getAreaOfRectangle(double length, double width) {
		return width * length;
	}

}
