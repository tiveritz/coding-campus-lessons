package src.com.dcv.feb.day48.models;

import src.com.dcv.feb.day48.interfaces.ISimulation;

public class Child implements ISimulation {
	private String name;
	private int happiness;

	public Child(String name) {
		this.name = name;
		this.happiness = 0;
	}
	
	public void simulate() {
		
	}
}
