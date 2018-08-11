package com.fj.nitin;
class Animal{}
class Reptile extends Animal{}
class Snake extends Reptile{}

class A1 {
public Animal factory(String animalName) {
		
		return new Animal();
	}
}
class B1 extends A1{
	@Override

	
public Snake factory(String animalName) {
		
		return new Snake();
	}
}

public class MethodOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
