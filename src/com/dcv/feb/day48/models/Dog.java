package src.com.dcv.feb.day48.models;

import java.util.Random;
import src.com.dcv.feb.day48.abstracts.Animal;


public class Dog extends Animal {
	Random random;

	public Dog(String name) {
		super(name, -1);
		this.random = new Random();
	}

	public void simulate(Child[] children) {
		int rand = this.random.nextInt(children.length);
		Child child = children[rand];
		child.reduceHappiness(3);

		System.out.println("Dog " + getName() + " goes to child " + child.getName() + " (happiness--)");
	}
}
