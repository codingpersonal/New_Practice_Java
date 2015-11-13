package ShipTravel;

import java.util.HashMap;
import java.util.Map;

public class ShipTravel_DP {
	static int MAX_ROW_SIZE = 5;
	static int MAX_COL_SIZE = 5;
	static int[][] block = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
			{ 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };
	static Map<Pair<Integer, Integer>, Integer> coordinateToDis = new HashMap<>();

	public static void main(String[] args) {
		int x = 2;
		int y = 0;
		System.out.println("The max points that can be attainted are:" + calcMaxPoints(x, y));
	}

	//the recursion funtion will return the max points that can be gained from location x,y
	public static int calcMaxPoints(int x, int y) {
		Pair <Integer,Integer> p = new Pair<Integer, Integer>(x, y);
		
		//If the path from x,y is already stored, return that path then.
		if(coordinateToDis.containsKey(p)) {
			return coordinateToDis.get(p);
		}
		//else find the path from x,y from recursion
		else {
			System.out.println("Calling recursion");
			if((x == MAX_ROW_SIZE) || y == MAX_COL_SIZE || y < 0) {
				return 0;
			}
			else {
				//get the paths from left, down and right locations and find the max from it.
				int count_left = calcMaxPoints(x + 1, y - 1);
				int count_up = calcMaxPoints(x + 1, y);
				int count_right = calcMaxPoints(x + 1, y + 1);
				int max_count = Math.max(count_up, Math.max(count_left, count_right));
				
					//Adding the entry in the map for Dynamic programming
					coordinateToDis.put(p, max_count + block[x][y]);
					
					// The path to be returned is the max found till now and then adding the current value
					return max_count + block[x][y];	
				}
		}
	}
}
