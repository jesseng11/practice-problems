
public class DP_CoinChange {
	public static void main(String args[]) {
		System.out.println(makeChangeDP(100));
	}
	
	public static int makeChangeRecursive(int n) {
		int[] denoms = {25, 10, 5, 1};
		return makeChangeRecursive(n, denoms, 0);
	}
	public static int makeChangeRecursive(int amount, int[] denoms, int index) {
		if(index >= denoms.length - 1)
			return 1; //last denom
		
		int denomAmount = denoms[index];
		int ways = 0;
		
		for(int i = 0; i * denomAmount <= denomAmount; i++) {
			int amountRemaining = amount - i * denomAmount;
			ways += makeChangeRecursive(amountRemaining, denoms, index + 1);
		}
		
		return ways;
	}
	
	//use a 2D array of integers to store the previously computed values
	//Time Complexity: O(mn)
	public static int makeChangeDP(int n) {
		int[] denoms = {25, 10, 5, 1};
		int[][] map = new int[n+1][denoms.length];
		return makeChangeDP(n, denoms, 0, map);
	}
	
	public static int makeChangeDP(int amount, int[] denoms, int index, int[][]map) {
		if(map[amount][index] > 0)
			return map[amount][index];
		
		if(index >= denoms.length - 1)
			return 1; //one denom remaining
		
		int denomAmount = denoms[index];
		int ways = 0;
		
		for(int i = 0; i * denomAmount <= amount; i++) {
			int amountRemaining = amount - 1 * denomAmount;
			ways += makeChangeDP(amountRemaining, denoms, index+1, map);
		}
		
		map[amount][index] = ways;
		
		return ways;
	}
}
