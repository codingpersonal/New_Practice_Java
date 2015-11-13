package ShipTravel;
public class ShipTravel {

	static int MAX_ROW_SIZE = 5;
	static int MAX_COL_SIZE = 5;
	static int[][] block = new int[][]{ 
		{1,2,3,4,5}, 
		{6,7,8,9,10},
		{11,12,13,14,15},
		{16,17,18,19,20}, 
		{21,22,23,24,25} 
	};
	
	public static void main(String[] args) {
		int x = 2;
		int y = 0;
		System.out.println("The max points that can be attainted are:"+ calcMaxPoints(x,y));
	}
	
	public static int calcMaxPoints(int x, int y) {
		System.out.println("Calling recursion");
		if((x == MAX_ROW_SIZE) || y == MAX_COL_SIZE || y < 0) {
			return 0;
		}
		else {
			int count_left = calcMaxPoints(x + 1, y - 1);
			int count_up = calcMaxPoints(x + 1, y);
			int count_right = calcMaxPoints(x + 1, y + 1);
			int max_count = Math.max(count_up, Math.max(count_left, count_right));
			return max_count + block[x][y];	
		}
	}
}
