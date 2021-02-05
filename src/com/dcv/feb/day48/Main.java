package src.com.dcv.feb.day48;

import src.com.dcv.feb.day48.abstracts.Animal;

import src.com.dcv.feb.day48.models.Cat;
import src.com.dcv.feb.day48.models.Child;
import src.com.dcv.feb.day48.models.Dog;
import src.com.dcv.feb.day48.models.Fish;
import src.com.dcv.feb.day48.models.Kindergarden;
import src.com.dcv.feb.day48.models.KindergardenTeacher;


public class Main {
	public static void main (String[] args) {

		Kindergarden kindergarden = new Kindergarden (
			"A Kindergarden", 
			new KindergardenTeacher[]{new KindergardenTeacher("A"), new KindergardenTeacher("B")}
		);
		kindergarden.addChildren(new Child[]{new Child("a"), new Child("b"), new Child("c")});
		kindergarden.addAnimal(new Fish("Dori"));
		kindergarden.addAnimal(new Dog("Bolt"));
		kindergarden.addAnimal(new Cat("Gazorpazorpfield"));

		for (int i = 0; i < 10; i++) {
			for (Child child : kindergarden.getChildren()) {
				child.simulate();
			}
			for (Animal animal : kindergarden.getAnimals()) {
				animal.simulate();
			}
			for (KindergardenTeacher kT : kindergarden.getKindergardenTeachers()) {
				kT.simulate();
			}
		}
	}
}