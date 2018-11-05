package uk.ac.reading.michaelpearcey.buildingconsole;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Building {

	private ArrayList<Room> rooms;
	private Point size;
	private Person p;
	private int ranRoom;
	private boolean stopped = false;
	
	public Building(String bS) {
		setBuilding(bS);
	}

	public void setBuilding(String bS) {
		if(rooms==null)
			rooms = new ArrayList<Room>();
		else
			rooms.clear();
		String bSplit[] = bS.split(";");
		String sizeS[] = new String[2];
		sizeS = bSplit[0].split(" ");
		size = new Point();
		size.setLocation(Integer.parseInt(sizeS[0]), Integer.parseInt(sizeS[1]));
		for(int i = 1; i < bSplit.length; i++) {
			rooms.add(new Room(bSplit[i]));
		}
	
		Random r = new Random();
		ranRoom = r.nextInt(rooms.size());
		Point personPos = rooms.get(ranRoom).ranPos();
		p = new Person(personPos.x, personPos.y);
		Point doorLoc = new Point();
		doorLoc.setLocation(rooms.get(ranRoom).getDoor().x, rooms.get(ranRoom).getDoor().y);
		p.setDoorLoc(doorLoc);
		stopped = false;
	}	
	
	/**
	 * show all building’s rooms and occupants in the interface
	 * @param bi	the interface
	 */
	public void showBuilding (BuildingInterface bi) {
		/// call the showPerson method of the occupant
		for(int i = 0; i < rooms.size(); i++) {
			rooms.get(i).showRoom(bi);
		}
		p.showPerson(bi);
	}
	
	public boolean isStopped() {
		return stopped;
	}
	
	public void movePerson() {
		if(!p.movePerson()) {
			System.out.println("The person has reached the dor!");
			stopped = true;
		}
	}

	public int getWidth() {
		return size.x;
	}

	public int getHeight() {
		return size.y;
	}
	
	public int getRoom() {
		if(ranRoom>-1)
			return ranRoom;
		else 
			return -1;
	}

	public String toString() {
		String ret = "";
		ret += "The building is of size: " + size.x + "," + size.y + "\nAnd is filled with rooms consisting of: \n";
		for(int i = 0; i < rooms.size(); i++) {
			ret += rooms.get(i).toString() + "\n";
		}
		ret+="\nThe person is at: " + p.getX() + "," + p.getY() + " In room " + getRoom();
		return ret;
	}

	public static void main(String[] args) {
		Building b = new Building("11 11;0 0 4 4 2 4;6 0 10 10 6 5;0 6 4 10 2 6");  // create 
		System.out.println(b.toString());	
	}
}
