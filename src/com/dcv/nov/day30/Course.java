package src.com.dcv.nov.day30;

import java.util.Vector;

public class Course {
	private String name;
	private Room room;
	private Vector<Participant> participants = new Vector<Participant>();
	private Vector<Trainer> trainers = new Vector<Trainer>();

	Course(String name, Room room) {
		this.name = name;
		this.room = room;
	}

	public void setParticipant(Participant p) {
		participants.add(p);
	}

	public void setTrainer(Trainer t) {
		trainers.add(t);
	}

	@Override
	public String toString() {
		String string = "Course name: " + name +
						"\nRoom: " + room.getFullLocation() + "\n" +
						"Trainers: " + trainersToString(trainers) + "\n" +
						"Trainers: " + participantsToString(participants) + "\n";
		return string;
	}

	private String participantsToString(Vector<Participant> participants) {
		String p = "";
		
		for(Participant participant : participants) {
			p += participant.getName() + ", ";
		}
		return p;
	}

	private String trainersToString(Vector<Trainer> trainers) {
		String t = "";
		
		for(Trainer trainer : trainers) {
			t += trainer.getName() + ", ";
		}
		return t;
	}
}
