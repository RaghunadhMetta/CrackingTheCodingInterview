package arryaAndStrings;

import java.lang.reflect.Array;

//assume all small letters and no special characters
//use hashmap and finally check for count with the same logic used here

public class OneEditAwayStrings {
	public static boolean areOneEditAway(String name1, String name2) {

		int count = 0;
		int differenceInLength = name1.length() - name2.length();
		if (differenceInLength > 1 || differenceInLength < -1) {
			return false;
		}
		int bufferArray[] = new int[26];
		for (int i = 0; i < name1.length(); i++) {
			bufferArray[name1.charAt(i) - 'a']++;
		}
		for (int i = 0; i < name2.length(); i++) {
			if (bufferArray[name2.charAt(i) - 'a'] > 0) {
				bufferArray[name2.charAt(i) - 'a']--;
			} else {
				bufferArray[name2.charAt(i) - 'a']++;
			}
		}
		for (int i = 0; i < bufferArray.length; i++) {
			count = count + bufferArray[i];
		}
		if ((differenceInLength == 0 && count == 2)
				|| (((differenceInLength == 1) || (differenceInLength == -1)) && count == 1)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name1 = "r";
		String name2 = "gr";
		System.out.println('r' - 'a');
		boolean result = areOneEditAway(name1, name2);
		System.out.println(result);
	}

}
