package com.michaelpearcey.hello;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class NameCount {
	
    public static void main(String[] args) {
    	String input = JOptionPane.showInputDialog(null, "Input a string");
    	int numPeople = countNames(input);
    	System.out.println("The number of names is: " + numPeople);
    	String allNames[] = new String[numPeople];
    	for(int i = 0; i  < numPeople; i++) {
    		allNames[i] = getName(i, input);
    	}
    	for(int i = 0; i < numPeople; i++) {
    		System.out.println(allNames[i]);
    	}
    	
    	String nameSplit[] = input.split(" ");
    	for(int i = 0; i < nameSplit.length; i++) {
    		System.out.print(nameSplit[i] + " ");
    	}
    }
    
    static int countNames(String names) {
    	int count = 0;
    	if(names.charAt(0) != ' ')
    		count++;
    	for(int i = 0; i < names.length() - 1; i++) {
    		if(names.charAt(i) == ' ')
    			count++;
    	}
    	return count;
    }
    
    public static String getName(int nameC, String names) {
    	int countSpaces = 0;
    	int startIndex = 0;
    	for(int i = 0; i < names.length(); i++) {
    		if(names.charAt(i) == ' ') {
        		if(countSpaces <= nameC)
        			countSpaces++;
        		if(countSpaces == nameC) {
        			startIndex = i;
        		} else if(countSpaces > nameC) {
        			return names.substring(startIndex, i);
        		}
    		}
    		if(i == names.length()-1)
    			return names.substring(startIndex, i+1);

    	}
    	return names.substring(0, names.length());
    }
}
