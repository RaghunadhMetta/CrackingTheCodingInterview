package arryaAndStrings;

public class StringPermutationOfOtherString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//string append and check  substring
		//sort the two strings and compare them, order should be  present
		
		String name1 = "raghu";
		String name2 = "raghu";
		boolean result = isPermutation(name1, name2);
		System.out.println(result);

	}

	public static boolean isPermutation(String name1, String name2) {
		//append one string and check if other string is substring or not
		int j = 0;
		String nameConcat = name1 + name1;
		for (int i = 0; i < nameConcat.length(); i++) {
			if (nameConcat.charAt(i) == name2.charAt(j)) {
				if (j != name2.length() - 1) {
					j++;
				}
				else {
					return true;
				}
			}
			else {
				j=0;
			}
		}
		return false;
	}

}
