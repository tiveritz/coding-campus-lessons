package src.com.dcv.feb.day48.abstracts;

import src.com.dcv.feb.day48.interfaces.ISimulation;


public abstract class Animal implements ISimulation {
	public String name;
	public int affect;
	
	public Animal(String name, int affect) {
		this.name = name;
		this.affect = affect;
	}

	public void simulate() {
		
	}
}
