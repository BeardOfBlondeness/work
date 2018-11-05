package week2;

public class AnagramCheck {

	protected String str, str1, str2;
	
	public AnagramCheck(){}
	
	public AnagramCheck(String str) {
		this.str = str;
		str1 = str.split(";")[0].toLowerCase();
		str2 = str.split(";")[1].toLowerCase();
	}
	
	public boolean check() {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		for(int i = 0; i < s1.length; i++) {
			for(int j = 0; j < s2.length; j++) {
				if(s1[i] == s2[j] && s1[i]!= ' ') {
					s1[i] = ' ';
					s2[j] = ' ';
				}
			}
		}
		boolean str1 = true;
		boolean str2 = true;
		for(int i = 0; i < s2.length; i++) {
			if(s2[i] != ' ')
				str1 = false;
		}
		for(int i = 0; i < s1.length; i++) {
			if(s1[i] != ' ')
				str2 = false;
		}
		if(str1 || str2) 
			return true;
		else
			return false;
	}
	
	public String toString() {
		String endString = " are not anagrams";
		if(check()) {
			endString = " are anagrams";
		}
		return str1 + " and " + str2 + endString;
	}
	
	public static void main(String[] args) {
		AnagramCheck c = new AnagramCheck("bad penis;bapm");
		System.out.println(c.toString());
	}
}
