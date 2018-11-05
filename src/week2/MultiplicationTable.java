package week2;

public class MultiplicationTable {

	private int maxNum;				// up to maxNum*maxNum
	private int[][] TableData;			// 2D array to store these
	
	/**
	 * create table for 1*1 up to maxN*maxN
	 * @param maxN
	 */
	MultiplicationTable (int maxN) {	
		// create array of right size, then call makeTable to fill it
		maxNum = maxN;
		TableData = new int[maxN][maxN];
		makeTable();
	}
	
	/**
	 * function to populate the table
	 */
	private void makeTable() {
// write code to populate the table (hint nested for loops)
		for(int i = 0; i < maxNum; i++) {
			for(int j = 0; j < maxNum; j++) {
				TableData[i][j] = (i+1)*(j+1);
			}
		}
	}
	
	/**
	 * return string with the table
	 */
	public String toString() {
		String res = "RJMs Multiplication Table"+"\n";	// title for string
		// write code to add data from 2D array to res
		for(int i = 0; i < maxNum; i++) {
			for(int j = 0; j < maxNum; j++) {
				res += TableData[i][j] + "\t";
			}
			res += "\n\n\n\n";
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplicationTable mt = new MultiplicationTable(10);
		System.out.print(mt.toString());
	}

}
