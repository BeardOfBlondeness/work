package uk.ac.reading.michaelpearcey.buildingconsole;

import java.awt.Point;
import java.util.Random;

public class Room {
	
	int roomDetails[];
	
	public Room(String room) {
		String[] roomArr = room.split(" ");
		roomDetails = new int[6];
		for(int i = 0; i < 6; i++) {
			roomDetails[i] = Integer.parseInt(roomArr[i]);
		}
	}
	
	public Point ranPos() {
		Point ret = new Point();
		Random r = new Random(); 
		int x = r.nextInt(roomDetails[2] - roomDetails[0]);
		int y = r.nextInt(roomDetails[3] - roomDetails[1]);
		ret.setLocation(x, y);
		return ret;
	}
	
	public Point getDoor() {
		Point p = new Point();
		p.setLocation(roomDetails[4], roomDetails[5]);
		return p;
	}
	
	public String toString() {
		String ret = "";
		ret += "The room is from: " + roomDetails[0] + "," + roomDetails[1] + " to " + roomDetails[2] + "," + roomDetails[3] + " and the door is at: " + roomDetails[4] + "," + roomDetails[5];
		return ret;
	}
	
	public boolean isInRoom(Point p) {
		if(p.getX() > roomDetails[0] && p.getX() < roomDetails[2] && p.getY() > roomDetails[1] && p.getY() < roomDetails[3])
			return true;
		return false;
	}
	
	public void showRoom(BuildingInterface bi) {
		bi.showWall(roomDetails[0], roomDetails[1], roomDetails[2], roomDetails[1]);
		bi.showWall(roomDetails[0], roomDetails[1], roomDetails[0], roomDetails[3]);
		bi.showWall(roomDetails[2], roomDetails[1], roomDetails[2], roomDetails[3]);
		bi.showWall(roomDetails[0], roomDetails[3], roomDetails[2], roomDetails[3]);
	}
	
	public static void main(String[] args) {
		Room r = new Room("0 1 4 4 2 2");
		System.out.println(r.toString());
		Point p = new Point();
		p.setLocation(2, 3);
		if(r.isInRoom(p))
			System.out.println("Player is in room");
		else
			System.out.println("Player is not in room");
	}
}
