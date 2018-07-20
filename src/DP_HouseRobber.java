import java.util.*;

/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint 
stopping you from robbing each of them is that adjacent houses have 
security system connected and it will automatically contact the police 
if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of 
each house, determine the maximum amount of money you can rob tonight without 
alerting the police.
*/

public class DP_HouseRobber {
	public static void main(String[] args) {
		int[] arr = {6, 7, 1, 3, 8, 2, 4};
		System.out.println("max $$$: " + rob(arr));
		System.out.println(maxLoot(arr));
	}

	//O(n) time and space
	public static int rob(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		
		if(nums.length == 1)
			return nums[0];
		
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		
		for(int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
		}
		
		for(int i = 0; i < nums.length; i++)
			System.out.print(dp[i] + " ");
		System.out.println();
		
		return dp[dp.length-1];
	}
	
	//O(n) time and O(1) space
    public static int maxLoot(int hval[])
    {
    	int n = hval.length;
    	
        if (n == 0)
        return 0;
  
        int value1 = hval[0];
        if (n == 1)
            return value1;
  
        int value2 = Math.max(hval[0], hval[1]);
        if (n == 2)
            return value2;
   
        // contains maximum stolen value at the end
        int max_val = 0;
  
        // Fill remaining positions
        for (int i=2; i<n; i++)
        {
            max_val = Math.max(hval[i]+value1, value2);
            value1 = value2;
            value2 = max_val;
        }
  
        return max_val;
    }
}
