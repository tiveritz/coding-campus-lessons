package src.com.dcv.nov.day34;

/*
Erstellt ein Objekt “Zoo” , dieses Objekt beinhaltet eine Vielzahl an Gehegen, welche
wiederum eine bestimmte Anzahl an Tieren besitzt.
z.B. Ein Zoo hat 50 Gehege, im ersten Gehege befinden sich 4 Löwen
Versucht Objekte zu modellieren und die Objekte mit Eigenschaften zu füllen, welche
sinnvoll wären.
z.B. Ein Zoo hat einen Standort und eventuell einen Vorsitzenden
Ein Gehege besteht aus einer bestimmten Absperrung (Holzzaun, Maschendraht,
Glas)
Ein Löwe sollte nicht in einer Klasse Löwe abgebildet werden, sondern einem Tier,
dieses hat dann wiederum eine Gattung oder sowas ähnliches.
Am Ende benötigen wir die Anzahl der Tiere je Gehege, aber auch über den ganzen Zoo.
Ich möchte auch wissen wie viele Wassertiere wir haben, aber auch wie viele verschiedene
Arten.
*/

public class Main {
	public static void main(String[] args) {
		Zoo zoo = new Zoo("Awesome Zoo", "The knight who say ni");
		Enclosure lionCage = new Enclosure(zoo, "high metal fence");
		Enclosure tigerCage = new Enclosure(zoo, "metal fence");
		Enclosure antarctisTank = new Enclosure(zoo, "big cold water tank");
		Enclosure meshFenceCover = new Enclosure(zoo, "5m cover thingy");

		for (int i = 0; i < 5; i++) {
			new Animal(lionCage, "lion", "lion" + i, new Food(zoo, "Meat", 3, "kg"));
			new Animal(tigerCage, "tiger", "tiger" + i, new Food(zoo, "Meat", 2, "kg"));
			new Animal(antarctisTank, "pinguine", "pinguin" + i, new Food(zoo, "Fish", 6, "small fishes"));
			new Animal(meshFenceCover, "hummingbird", "hummingbird" + i, new Food(zoo, "Sugarwater", 50, "ml"));
		}
		System.out.println("\nprint zoo structure --------------");
		System.out.println(zoo.getStructure());
		System.out.println("\nprint number of animals ----------");
		System.out.println(zoo.getNumberOfAnimals());
		System.out.println("\nprint food demand ----------------");
		zoo.printFoodDemand();
	}	
}
