package com.michaelpearcey.hello;

import javax.swing.JOptionPane;

public class Initials {

	public static String calculateInitials(String name) {
		String initials = "";
		initials += name.charAt(0);
		for(int i = 1; i < name.length() - 1; i++) {
			if(name.charAt(i) == ' ' && name.charAt(i+1) != ' ')
				initials += name.charAt(i+1);
		}
		return initials;
	}
	
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Your initials are: " + calculateInitials(JOptionPane.showInputDialog(null, "Please input your name:")));
	}
}
