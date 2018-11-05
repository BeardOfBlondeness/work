package week2;

import java.util.ArrayList;

public class MultiAnagram extends AnagramCheck{

	private String strs[];
	private ArrayList<String[]> indexes;
	
	public MultiAnagram(String str) {
		strs = str.split(" ");
		indexes = new ArrayList<String[]>();
		MultiCheck();
	}
	
	public void MultiCheck() {
		for(int i = 0; i < strs.length; i++) {
			for(int j = 0; j < strs.length; j++) {
				if(i!=j) {
					str1 = strs[i];
					str2 = strs[j];
					if(check()) {
						String temp[] = new String[2];
						temp[0] = str1;
						temp[1] = str2;
						indexes.add(temp);
					}
				}
			}
		}
	}
	
	public String toString() {
		String ret = "";
		for(int i = 0; i < indexes.size(); i++) {
			ret += indexes.get(i)[0] + " and " + indexes.get(i)[1] + " are anagrams! \n";
		}
		return ret;
	}
	
	public static void main(String[] args) {
		MultiAnagram n = new MultiAnagram("bee eep eeb pee");
		System.out.println(n.toString());
	}
}
