package src.com.dcv.feb.day48.models;

import java.util.Random;

import src.com.dcv.feb.day48.abstracts.Animal;


public class Cat extends Animal {
	Random random;

	public Cat(String name) {
		super(name, 1);
		this.random = new Random();
	}

	public void simulate(Child[] children) {
		int rand = this.random.nextInt(children.length);
		Child child = children[rand];
		child.raiseHappiness(2);

		System.out.println("Cat " + getName() + " goes to child " + child.getName() + " (happiness++)");
	}
}
