import java.util.*;

public class DP_MinimumPathSum {
	public static void main(String[] args) {
		int[][] grid = {
				{2, 3, 5, 1, 2},
				{1, 2, 1, 3, 3},
				{0, 6, 2, 1, 1}
		};
		
		System.out.println(mathPathSumDP(grid));
	}
	
	//DFS recursive. Too expensive
	public static int minPathSumRec(int[][] grid) {
		return dfs(0,0,grid);
	}
	
	public static int dfs(int i, int j, int[][] grid) {
		if(i == grid.length-1 && j == grid[0].length-1)
			return grid[i][j];
		
		if(i < grid.length - 1 && j < grid[0].length - 1) {
			int r1 = grid[i][j] + dfs(i+1, j, grid);
			int r2 = grid[i][j] + dfs(i, j+1, grid);
			return Math.min(r1, r2);
		}
		
		if(i < grid.length - 1) 
			return grid[i][j] + dfs(i+1, j, grid);
		
		if(j < grid[0].length - 1)
			return grid[i][j] + dfs(i, j+1, grid);
		
		return 0;
	}
	
	//DP solution
	public static int mathPathSumDP(int[][] grid) {
		if(grid == null || grid.length == 0)
			return 0;
		
		int m = grid.length;
		int n = grid[0].length;
		
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];

		for(int i = 1; i < m; i++)
			dp[i][0] = dp[i-1][0] + grid[i][0];
		
		for(int i = 1; i < n; i++)
			dp[0][i] = dp[0][i-1] + grid[0][i];
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(dp[i-1][j] > dp[i][j-1]) {
					dp[i][j] = dp[i][j-1] + grid[i][j];
				}
				else {
					dp[i][j] = dp[i-1][j] + grid[i][j];
				}
			}
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		return dp[m-1][n-1];
	}
}
