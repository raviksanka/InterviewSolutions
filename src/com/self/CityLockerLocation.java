package test;

/*
 * This file is used to calculate locker location 
 *            and find shortest path to traverse between co-ordinates.
 */
public class CityLockerLocation {
	static int[][] getLockerDistanceGrid(int cityLength, int cityWidth,
			int[] lockerXCoordinates, int[] lockerYCoordinates) {

		int[][] city = new int[cityWidth][cityLength];
		// initialize city to biggest numbers
		for (int i = 0; i < city[0].length; i++)// x
			for (int j = 0; j < city.length; j++)// y
				city[j][i] = Integer.MAX_VALUE;
		// mark the locker's distance. it also remembers the location of lockers
		for (int i = 0; i < lockerXCoordinates.length; i++)
			city[lockerYCoordinates[i] - 1][lockerXCoordinates[i] - 1] = 0;
		// calculate for each locker
		for (int i = 0; i < lockerXCoordinates.length; i++) {
			calcDistance(city, lockerYCoordinates[i], lockerXCoordinates[i]);
		}
		return city;
	}

	static void calcDistance(int[][] city, int y, int x) {
		y = y - 1;
		x = x - 1;
		for (int i = 0; i < city[0].length; i++)// x
			for (int j = 0; j < city.length; j++) {// y
				if (city[j][i] != 0) {
					int old = city[j][i];
					int newV = Math.abs(j - y) + Math.abs(i - x);
					if (newV < old)
						city[j][i] = newV;
				}
			}
	}

	static String toString(int[][] a) {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < a.length; j++) {// y
			for (int i = 0; i < a[0].length; i++)// x
				sb.append(a[j][i]);
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] x = { 1 };
		int[] y = { 1 };
		int[][] result = getLockerDistanceGrid(3, 5, x, y);
		System.out.println(toString(result));
		int[] x2 = { 2, 4 };
		int[] y2 = { 3, 7 };
		result = getLockerDistanceGrid(5, 7, x2, y2);
		System.out.println(toString(result));
	}
  
}
