package com.fj.nitin;

interface TestA {
	static void printStaticValue(String s) {
		System.out.println("Test static method of A" + s);
	}

	default void printDefaultValue(String s) {
		System.out.println("Test default method  of A" + s);
	}
}

/**
 * Differences between static and default methods in Java 8:
 * 
 * 1) Default methods can be overriden in implementing class, while static
 * cannot.
 * 
 * 2) Static method belongs only to Interface class, so you can only invoke
 * static method on Interface class, not on class implementing this Interface,
 * 3) Both class and interface can have static methods with same names, and
 * neither overrides other!
 *
 */
public class DifferenceBetweenStaticAndDefault implements TestA {

	static void printStaticValue(String s) {
		System.out.println("Test static method of concreate " + s);
	}
	
	public static void main(String[] args) {
		DifferenceBetweenStaticAndDefault default1 = new DifferenceBetweenStaticAndDefault();
		default1.printDefaultValue("Nitin Kumar Gupta");
		//// default1.printStaticValue("Not valid"); //we can't call static method
		TestA.printStaticValue("nitin gupta");
	}

}
