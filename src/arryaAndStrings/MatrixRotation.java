package arryaAndStrings;

public class MatrixRotation {
	public static void main(String args[]) {
		int row = 4;
		int column = 4;
		int temp = 0;
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },{ 13, 14, 15, 16 } };
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print("	" + matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < row; i++) {
			temp = matrix[0][i];
			matrix[0][i] = matrix[row - i - 1][0];
			matrix[row - i - 1][0] = matrix[row - 1][row - i - 1];
			matrix[row - 1][row - i - 1] = matrix[i][row - 1];
			matrix[i][row - 1] = temp;
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print("	" + matrix[i][j]);
			}
			System.out.println();
		}

	}
}
