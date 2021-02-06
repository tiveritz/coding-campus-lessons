package src.com.dcv.feb.day48.models;

import src.com.dcv.feb.day48.abstracts.Animal;

public class Fish extends Animal {
	
	public Fish(String name) {
		super(name, 0);
	}	

	public void simulate(Child[] children) {
		System.out.println("Fish " + getName() + " does absolutely nothing");;
	}
}
