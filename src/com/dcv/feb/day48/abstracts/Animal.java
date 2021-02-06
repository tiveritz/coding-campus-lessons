package src.com.dcv.feb.day48.abstracts;

import src.com.dcv.feb.day48.interfaces.ISimulation;
import src.com.dcv.feb.day48.models.Child;


public abstract class Animal implements ISimulation {
	private String name;
	private int affect;

	public Animal(String name, int affect) {
		this.name = name;
		this.affect = affect;
	}

	public void simulate(Child[] children) {
		return;
	}

	public String getName() {
		return name;
	}
}
