package src.com.dcv.feb.day48.models;

import java.util.ArrayList;

import src.com.dcv.feb.day48.abstracts.Animal;


public class Kindergarden {
	private String name;
	private ArrayList<Child> children;
	private ArrayList<Animal> animals;
	private KindergardenTeacher[] kindergardenTeachers;
	
	public Kindergarden (String name, KindergardenTeacher[] kindergardenTeachers) {
		this.name = name;
		this.kindergardenTeachers = kindergardenTeachers;
		this.animals = new ArrayList<>();
		this.children = new ArrayList<>();
	}

	public void addAnimal(Animal animal) {
		animals.add(animal);
	}

	public void addChildren(Child[] children) {
		for (Child child : children) {
			this.children.add(child);
		}
	}

	public Child[] getChildren() {
		Child[] children = new Child[this.children.size()];
		for (int i = 0; i < children.length; i++) {
			children[i] = this.children.get(i);
		}

		return children;
	}

	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	public KindergardenTeacher[] getKindergardenTeachers() {
		return kindergardenTeachers;
	}

	public void printChildrenHappiness() {
		for (Child child : children) {
			child.printHappiness();
		}
	}
}
