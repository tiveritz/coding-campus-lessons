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

	public ArrayList<Child> getChildren() {
		return children;
	}

	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	public KindergardenTeacher[] getKindergardenTeachers() {
		return kindergardenTeachers;
	}
}
