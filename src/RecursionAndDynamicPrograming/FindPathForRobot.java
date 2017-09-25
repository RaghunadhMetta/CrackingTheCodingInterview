package RecursionAndDynamicPrograming;

import java.util.ArrayList;

public class FindPathForRobot {
	class Coordinates {
		int X_Coordinate;
		int Y_Coordinate;

		public Coordinates(int x_Coordinate, int y_Coordinate) {
			super();
			X_Coordinate = x_Coordinate;
			Y_Coordinate = y_Coordinate;
		}

	}

	public boolean calcPathRecursiveCall(int[][] grid, int row, int column, ArrayList<Coordinates> path,
			ArrayList<Coordinates> obstructions) {
		
		if ((row < 0 || column < 0) || grid[row][column] == -1) {
			return false;
		}
		Coordinates coordinate = new Coordinates(row, column);
		if (obstructions.contains(coordinate)) {
			return false;
		}
		if (row == 0 && column == 0) {
			path.add(coordinate);
			return true;
		}

		if ((calcPathRecursiveCall(grid, row - 1, column, path, obstructions)
				|| calcPathRecursiveCall(grid, row, column - 1, path, obstructions))) {
			path.add(coordinate);
			return true;
		}
		return false;

	}

	public ArrayList<Coordinates> findPath(int[][] grid) {
		ArrayList<Coordinates> path = new ArrayList<>();
		ArrayList<Coordinates> obstructions = new ArrayList<>();
		if (calcPathRecursiveCall(grid, grid.length - 1, grid[0].length - 1, path, obstructions)) {
			return path;
		}
		return null;
	}

	public static void main(String[] args) {
		int grid[][] = { { 1, 1, 1, 1 }, { 1, 1, -1, 1 }, { -1, 1, 1, -1 }, { 1, 1, 1, 1 } };
		FindPathForRobot robot = new FindPathForRobot();
		ArrayList<Coordinates> path = robot.findPath(grid);
		if (path == null) {
			System.out.println("No Path found");
		} else {
			for (Coordinates c : path) {
				System.out.println(c.X_Coordinate + "," + c.Y_Coordinate);
			}
		}
	}
}
