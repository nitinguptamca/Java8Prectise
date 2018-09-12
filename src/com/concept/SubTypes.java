package com.concept;
import java.util.*; 

public class SubTypes {
	public static void main(String[] args) {
		List<ParentType> list = new ArrayList<ParentType>();
		list.add(new ParentType());
		list.add(new ChildType());
		for(ParentType p : list) {
			if(p instanceof ChildType) {
			((ChildType) p).doKidStuff();
			}
			if(p instanceof ParentType) {
			p.doParentStuff();
			}
		}
	}
	
}

class ParentType { 
	void doParentStuff() { 
		System.out.println("I'm a real parent");
	}
}

class ChildType extends ParentType { 
	void doParentStuff() {
		System.out.println("I'm just pretending");
	}
	void doKidStuff() { 
		System.out.println("I'm just a kid.");
	}
}