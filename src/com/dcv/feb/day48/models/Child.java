package src.com.dcv.feb.day48.models;

import java.util.Random;

import src.com.dcv.feb.day48.interfaces.ISimulation;


public class Child implements ISimulation {
	private String name;
	private int happiness;
	private Random random;

	public Child(String name) {
		this.name = name;
		this.happiness = 0;
		this.random = new Random();
	}
	
	public void simulate(Child[] children) {
		if (random.nextInt(3) < 2) {
			if (random.nextBoolean()) {
				happiness++;
				System.out.println("Child " + name + " plays (happiness++)");
			} else {
				happiness -= 3;
				System.out.println("Child " + name + " plays (happiness--)");
			}
		} else {
			Child playDate = null;
			while (playDate == null) {
				int rand = random.nextInt(children.length);
				Child randChild = children[rand];
				if (randChild != this) {
					playDate = randChild;
				}
			}
			happiness++;
			playDate.raiseHappiness(1);
			System.out.println("Child " + name + " plays with " + playDate.getName());

		}
	}

	public String getName() {
		return name;
	}

	public void raiseHappiness(int amount) {
		happiness += amount;
	}


	public void reduceHappiness(int amount) {
		happiness -= amount;
	}

	public int getHappinessLvl() {
		return happiness;
	}

	public void resetHappiness() {
		happiness = 0;
	}

	public void printHappiness() {
		System.out.println("-> Child " + name + ": " + happiness);
	}
}
