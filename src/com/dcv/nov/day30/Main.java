package src.com.dcv.nov.day30;

public class Main {
	public static void main(String[] args) {
		Building ak = new Building("Arbeiterkammer Feldkirch");
		Room room = new Room(ak, 'C', 3, 4);
		// System.out.println(room.getFullLocation());

		Course codingCampus = new Course("Coding Campus", room);
		Participant p1 = new Participant("Lukas");
		Participant p2 = new Participant("Dan");
		Participant p3 = new Participant("Mihael");
		Trainer t1 = new Trainer("Daniel");
		Trainer t2 = new Trainer("Gyula");
		Trainer t3 = new Trainer("Vielleich da Cracky");

		codingCampus.setTrainer(t1);
		codingCampus.setTrainer(t2);
		codingCampus.setTrainer(t3);
		codingCampus.setParticipant(p1);
		codingCampus.setParticipant(p2);
		codingCampus.setParticipant(p3);

		System.out.println(codingCampus.toString());

	}
	
}
