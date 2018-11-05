package com.michaelpearcey.hello;

import javax.swing.JOptionPane;

public class SCounter {
	
	/*
	 * Takes string and loops through each character checking for Ss
	 */
	public static int countS(String str) {
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 's')
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "You have: " + countS(JOptionPane.showInputDialog(null, "Please write a string")) + " Ss in your string"); // Asks for input and shows message dialog while calling coutnS
	}

}
