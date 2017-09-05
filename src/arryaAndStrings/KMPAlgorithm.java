package arryaAndStrings;

public class KMPAlgorithm {
	public int[] computePrefixArray(String pattern) {
		int prefixArray[] = new int[pattern.length()];
		int j = 0;
		prefixArray[0] = 0;
		for (int i = 1; i < pattern.length();) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				prefixArray[i] = j + 1;
				i++;
				j++;
			} else {
				if (j != 0) {
					j = prefixArray[j - 1];
				} else {
					prefixArray[i] = 0;
					i++;
				}
			}
		}
		return prefixArray;

	}

	public void implementKMPAlgo(String text, String pattern) {
		int prefixArray[] = computePrefixArray(pattern);
		int i = 0, j = 0;
		while (i < text.length() && j < pattern.length()) {
			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = prefixArray[j - 1];
				} else {
					i++;
				}
			}
		}
		if (j == pattern.length()) {
			System.out.println("pattern match");
		} else {
			System.out.println("Mismatch of patterns");
		}
	}

	public static void main(String args[]) {
		String text = "abcdshajkfjdhf";
		String pattern = "hajs";
		KMPAlgorithm KMP = new KMPAlgorithm();
		KMP.implementKMPAlgo(text, pattern);

	}
}
