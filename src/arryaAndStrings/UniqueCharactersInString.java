package arryaAndStrings;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UniqueCharactersInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// method 1: Sort the string and check adjacent
		// method 2: take a boolean buffer and make char corresponding position true
		// hashMap
		String name = "raghu nAdh";
		System.out.println(hasUniqueCharacters(name));

	}

	public static boolean hasUniqueCharacters(String name) {
		char[] nameArray = name.toCharArray();
		Arrays.sort(nameArray);
		for (int i = 0; i < nameArray.length - 1; i++) {
			if (nameArray[i] == nameArray[i + 1]) {
				return false;
			}
		}
		return true;
	}

}
