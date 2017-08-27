package arryaAndStrings;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PalindromePermutationOfString {

	public static void main(String[] args) {
		int oddValueCount = 0;
		// TODO Auto-generated method stub
		// space is not considered 
		//if space is considered then remove the space then check for palindrome 
		//if not a hashmap use a buffer and keep count of all char and check for occurance of odd char
		String name = "raghurag";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		HashSet<Integer> map1 = new HashSet<Integer>();
		for (int i = 0; i < name.length(); i++) {
			if (map.containsKey(name.charAt(i))) {
				int value = map.get(name.charAt(i)) + 1;
				map.put(name.charAt(i), value);
			} else {
				map.put(name.charAt(i), 1);
			}
		}
		for (Map.Entry m : map.entrySet()) {
			int i = (int) m.getValue();
			if (i % 2 != 0) {
				oddValueCount++;
			}
		}
		if ((name.length() % 2 == 0 && oddValueCount == 0) || (name.length() % 2 != 0 && oddValueCount == 1)) {
			System.out.println("Palindrome Permutation");
		} else {
			System.out.println("Not A Palindrome Permutation");
		}
	}
}
