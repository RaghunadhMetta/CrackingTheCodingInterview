package arryaAndStrings;

import java.util.HashMap;

public class BoyerMooreAlgo {
	public HashMap<Character, Integer> computeBadMatchTable(String pattern) {
		int length = pattern.length();
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < pattern.length() - 1; i++) {
			map.put(pattern.charAt(i), length - i - 1);
		}
		map.put(pattern.charAt(length - 1), length);
		map.put('*', length);
		return map;

	}

	public void checkPatternBoyerMooreAlgo(String name, String pattern) {
		HashMap<Character, Integer> map = computeBadMatchTable(pattern);
		int patternIndex = pattern.length() - 1;
		int clock = 0;
		int nameIndex = pattern.length() - 1;
		while (nameIndex < name.length() && patternIndex >= 0) {
			if (name.charAt(nameIndex) == pattern.charAt(patternIndex)) {
				patternIndex--;
				nameIndex--;
				clock++;
			} else {
				nameIndex = nameIndex + clock;
				nameIndex = nameIndex + map.get(name.charAt(nameIndex));
				patternIndex = pattern.length() - 1;
			}
		}
		if(patternIndex<0) {
			System.out.println("pattern matched");
		}
		else if(nameIndex>=name.length()) {
			System.out.println("pattern not found");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "dksjbdjhsfaabbbccccdefgabsldjhvcbsdjb";
		String pattern = "aabbbccccdefga";
		BoyerMooreAlgo BMAlgo = new BoyerMooreAlgo();
		BMAlgo.checkPatternBoyerMooreAlgo(name, pattern);
	}

}
