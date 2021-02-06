package src.com.dcv.feb.day48.models;

import src.com.dcv.feb.day48.interfaces.ISimulation;


public class KindergardenTeacher implements ISimulation {
	private String name;
	
	public KindergardenTeacher(String name) {
		this.name = name;
	}

	public void simulate(Child[] children) {
		int saddestChildHappiness = Integer.MAX_VALUE;
		Child saddestChild = null;

		for (Child child : children) {
			int childHappiness = child.getHappinessLvl();
			if (childHappiness < saddestChildHappiness) {
				saddestChildHappiness = childHappiness;
				saddestChild = child;
			}
		}

		if (saddestChildHappiness < 0) {
			saddestChild.resetHappiness();
			System.out.println("Kindergarden Teacher " + name + " comforts child " + saddestChild.getName());
		}
	}
}
