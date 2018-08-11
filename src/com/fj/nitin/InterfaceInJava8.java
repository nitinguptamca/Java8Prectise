package com.fj.nitin;

/**
 * 
 * @author NITIN Difference Between Default Method and Regular Method Not
 *         override the default method and will inherit the default method.
 *         Override the default method similar to other methods we override in
 *         subclass.. Redeclare default method as abstract, which force subclass
 *         to override it.
 *
 */

interface A {
	void hello(String s);
	static void helloStatic(String s) {		System.out.println("I am static method in Interface A :" + s);	}
	default void helloDefault(String s) {		System.out.println("I am default method in Interface A :" + s);	}
	default void helloDefault1(String s) {		System.out.println("I am default method in Interface A :" + s);	}
	static void helloStatic1(String s) {		System.out.println("I am default method in Interface A :" + s);	}
}

interface B extends A {
	void hello(String s);
	static void helloStatic(String s) {		System.out.println("I am static method in Interface B :" + s);	}
	default void helloDefault(String s) {		System.out.println("I am default method in Interface B :" + s);	}
}

public class InterfaceInJava8 implements B {

	interface X {
		void hello(String s);
		static void helloStatic(String s) {			System.out.println("I am static method in Interface X :" + s);		}
		default void helloDefault(String s) {			System.out.println("I am default method in Interface X :" + s);		}
		default void helloDefault11(String s) {			System.out.println("I am default method in Interface X :" + s);		}
	}

	interface C extends X {
		void hello(String s);
		static void helloStatic(String s) {			System.out.println("I am static method in Interface C :" + s);		}
		default void helloDefault(String s) {			System.out.println("I am default method in Interface C :" + s);		}
		default void helloDefault11(String s) {			System.out.println("I am default method in Interface C :" + s);		}
	}

	static interface D extends C {
		void hello(String s);
		static void helloStatic(String s) {			System.out.println("I am static method in Interface D :" + s);		}
		default void helloDefault(String s) {System.out.println("I am default method in Interface D :" + s);}
	}

	static class E implements D {

		@Override
		public void hello(String s) { System.out.println("hello inner class");	}

		public void helloTest() {
			hello("inside E class");
			helloDefault("inside D");
			D.super.helloDefault("inside D");
			D.super.helloDefault11("test  sss");
			helloDefault11("test  sss");
			D.helloStatic("DD static");
			C.helloStatic("CC");
			X.helloStatic("X");
		}
	}

	@Override
	public void hello(String s) {
		System.out.println("abstruct method of B : " + s);
	}

	public static void main(String[] args) {
		InterfaceInJava8 java8 = new InterfaceInJava8();
		java8.testHello();
		new E().helloTest();
	}

	private void testHello() {
		A.helloStatic("Hello static A"); 
		D.helloStatic("Hello static D");
		hello("InterfaceInJava8 class");
		helloDefault("defautlt B");
		B.super.helloDefault("Interface B");
		this.helloDefault1("call A");
		// A.super.helloDefault("call A default"); //You can not call default interface
		// method with same name
		B.super.helloDefault1("call A default");
	}
}
