package src.com.dcv.jan.day46.models;

import java.util.ArrayList;


public class Room {
	private int roomNumber;
	private ArrayList<ArtPiece> artPieces;
	private ArrayList<Guard> guards;
	private ArrayList<Visitor> visitors;
	private ArrayList<Thief> thieves;

	public Room(int roomNumber) {
		this.roomNumber = roomNumber;
		this.artPieces = new ArrayList<>();
		this.guards = new ArrayList<>();
		this.visitors = new ArrayList<>();
	}

	public void removeVisitor(Visitor visitor) {
		visitors.remove(visitor);
	}

	public void addVisitor(Visitor visitor) {
		visitors.add(visitor);
	}
	
	public void removeGuard(Guard guard) {
		guards.remove(guard);
	}

	public void addGuard(Guard guard) {
		guards.add(guard);
	}

	public void removeThief(Thief thief) {
		thieves.remove(thief);
	}

	public void addThief(Thief thief) {
		thieves.add(thief);
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void printStructure() {
		System.out.println("ArtPieces:");
		for (ArtPiece artPiece : artPieces) {
			System.out.println(artPiece.getInfo());
		}
		System.out.println("\nGuards:");
		for (Guard guard : guards) {
			System.out.println(guard.getInfo());
		}
		System.out.println("\nVisitors:");
		for (Visitor visitor : visitors) {
			System.out.println(visitor.getInfo());
		}
	}

}