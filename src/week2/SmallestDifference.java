package week2;

import javax.swing.JOptionPane;

public class SmallestDifference {

	private int[] numbers;			// array of integers to analyse
	// you may want to add more private variables
	
	/**
	 * create class : 
	 * @param instr	- string with series of numbers separated by space
	 */
	SmallestDifference (String instr) {
		StringSplitter S = new StringSplitter (instr, " ");
		numbers = S.getIntegers();
	}
	/**
	 * method to search through array and find pairs of adjacent numbers
	 * which are closest in value; note the difference and where in array
	 */
	public int findSmallest() {
		// you write this
		int smallestDifference = Math.abs(numbers[0] - numbers[1]);
		for(int i = 1; i < numbers.length; i++) {
			int tempDiff = Math.abs(numbers[i]-numbers[i-1]);
			if(tempDiff < smallestDifference)
				smallestDifference = tempDiff;
		}
		return smallestDifference;
    }
	/**
	 * return as string the result of analysis
	 */
	public String toString() {
		return "Smallest difference is " + findSmallest();	// you extend this string
	}
	
	public static void main(String[] args) {
		String userIn = JOptionPane.showInputDialog(null, "Enter series of numbers separated by space > ");
		SmallestDifference sd = new SmallestDifference(userIn);
		sd.findSmallest();
		JOptionPane.showMessageDialog(null, sd.toString());

	}

}
