package uk.ac.reading.michaelpearcey.buildingconsole;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BuildingInterface {

     Scanner s;			// scanner used for input from user
	
    private char[][] drawing;
    Building myBuilding;	// building in which rooms are shown
    /**
     * return as String definintion of bOpt'th building
     * @param bOpt
     */
    public String buildingString (int bOpt) {
    	if (bOpt == 1)
    		return "11 11;0 0 4 4 2 4;6 0 10 10 6 5;0 6 4 10 2 6";
    	else
    		return "40 12;0 0 15 4 8 4;15 0 30 4 22 4;0 6 10 11 6 6";
    }
    
    public void doDisplay() {
    	drawing = new char[myBuilding.getWidth()][myBuilding.getHeight()];
 	   for(int i = 0; i < myBuilding.getHeight(); i++) {
		   for(int j = 0; j < myBuilding.getWidth(); j++) {
			   drawing[j][i] = ' ';
		   }
	   }
    	fillDrawing();
    	drawBuildings();
    }
    
    private void fillDrawing() {
    	myBuilding.showBuilding(this);
    }
    
    public void showWall(int xa, int ya, int xb, int yb) {
    	if(xa==xb) {
    		for(int i = ya; i < yb; i++) {
    			drawing[xa][i] = '|';
    		}
    	} else {
    		for(int i = xa; i < xb; i++) {
    			drawing[i][ya] = '-';
    		}
    	}
    }
    /**
     * specific what is shown at position x,y
     * @param x
     * @param y
     * @param ch
     */
   public void showIt(int x, int y, char ch) {
         /// store in 2D array cnar ch at the appropriate location
	   drawing[x][y] = ch;
   }
   
   public void animate() {
   	while (!myBuilding.isStopped() ) {				
   		myBuilding.movePerson();
   		doDisplay();
       	try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
   	}	
   }

   
   private void drawBuildings() {
	   for(int i = 0; i < myBuilding.getHeight(); i++) {
		   for(int j = 0; j < myBuilding.getWidth(); j++) {
			   System.out.print(drawing[j][i]);
		   }
		   System.out.print("\n");
	   }
   }
    /**
    	 * constructor for BuildingInterface
    	 * sets up scanner used for input and the arena
    	 * then has main loop allowing user to enter commands
     */
    public BuildingInterface() {
    	  s = new Scanner(System.in);	// set up scanner for user input
        int bno = 1;			// inityially building 1 selected

        myBuilding = new Building(buildingString(bno));// create building
    	
        char ch = ' ';
        do {
           	System.out.print("(N)ew buidling (I)nfo, e(X)it, (D)raw, (M)ove person, (A)nimate> ");
        	ch = s.next().charAt(0);
        	s.nextLine();
        	switch (ch) {
       		case 'N' :
        		case 'n' :
        				bno = 3 - bno;  // change 1 to 2 or 2 to 1
        				myBuilding.setBuilding(buildingString(bno));
        				break;
        		case 'I' :
        		case 'i' :
    					System.out.print(myBuilding.toString());
           				break;
        		case 'D':
        		case 'd':
        			doDisplay();
        			break;
        		case 'M':
        		case 'm':
        			myBuilding.movePerson();
        			break;
        		case 'A':
        		case 'a':
        			animate();
        			break;
         		case 'x' : 	ch = 'X';	// when X detected program ends
        				break;
		 
        	}
    	} while (ch != 'X');			// test if end
 
       s.close();					// close scanner
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuildingInterface b = new BuildingInterface();	
// just call the interface
	}
}
