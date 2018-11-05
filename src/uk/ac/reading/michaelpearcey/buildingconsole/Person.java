package uk.ac.reading.michaelpearcey.buildingconsole;

import java.awt.Point;

public class Person {
	
	private Point p;
	private Point doorLoc;
	
	public Person(int x, int y) {
		p = new Point();
		p.setLocation(x, y);
	}
	
	public int getX() {
		return p.x;
	}
	
	public void setDoorLoc(Point p) {
		doorLoc = p;
	}
	
	public boolean movePerson() {
		if(!(p.x == doorLoc.x && p.y == doorLoc.y)) {
			if(doorLoc.x > p.x)
				p.translate(1, 0);
			if(doorLoc.x < p.x)
				p.translate(-1, 0);
			if(doorLoc.y > p.y)
				p.translate(0, 1);
			if(doorLoc.y < p.y)
				p.translate(0, -1);
			return true;
		} else {
			return false;
		}
	}
	
	public int getY() {
		return p.y;
	}
	
	public void setX(int x) {
		p.setLocation(x, p.y);
	}
	
	public void setY(int y) {
		p.setLocation(p.x, y);
	}
	
	public void setPoint(int x, int y) {
		p.setLocation(x, y);
	}	
	
	/**
	 * show person in the given building interface
	 * @param bi
	 */
	public void showPerson(BuildingInterface bi) {
		// call the showIt method in bi
		bi.showIt(p.x, p.y, 'p');
	}

}
