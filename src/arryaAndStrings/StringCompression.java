package arryaAndStrings;

public class StringCompression {
	public static void compressString(String string) {
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (int i = 0; i < string.length() - 1; i++) {

			if (string.charAt(i) == string.charAt(i + 1)) {
				count++;
			} else {

				sb.append(string.charAt(i)).append(count);
				count = 1;
			}

		}
		if (string.charAt(string.length() - 1) == string.charAt(string.length() - 2)) {
			count++;
		}
		sb.append(string.charAt(string.length() - 1)).append(count);
		if (sb.length() > string.length()) {
			System.out.println(string);
		} else {
			System.out.println(sb.toString());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "raghu";
		compressString(name);
	}

}
