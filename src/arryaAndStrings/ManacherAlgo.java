package arryaAndStrings;

import java.util.Arrays;

public class ManacherAlgo {
	private String stringModification(String name) {
		StringBuilder sb = new StringBuilder();
		int index = 0;
		sb.append("*");
		while (index < name.length()) {
			sb.append(name.charAt(index));
			sb.append("$");
			index++;
		}
		sb.append("*");
		return sb.toString();
	}

	private void longestPalindromeSubString(String name) {
		name = stringModification(name);
		int maximumLenght=0;
		int length[] = new int[name.length()];
		int rightBound = 1;
		int temp;
		int mainPalindromeIndex = 1;
		int mirror = 1;
		for (int i = 1; i < name.length()-1; i++) {
			mirror = (2 * mainPalindromeIndex) - i;
			if (i < rightBound) {
				length[i] = Math.min(length[mirror], (rightBound - i));
			}
			while (name.charAt(i - (length[i] + 1)) == name.charAt(i + (length[i] + 1))) {
				length[i]++;
			}
			if ((length[i] + i) > rightBound) {
				mainPalindromeIndex = i;
				rightBound = length[i] + i;
			}
		}
		maximumLenght = Arrays.stream(length).max().getAsInt();
		System.out.println(maximumLenght);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//remove values of special char inserted should be done 
		String name = "raghu";
		ManacherAlgo ma = new ManacherAlgo();
		ma.longestPalindromeSubString(name);
	}

}
