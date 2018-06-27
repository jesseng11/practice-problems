import java.io.*;
import java.util.*;

public class LargestSumContiguousSubarray {
  public static void main(String[] args) {
    int[] arr = {-1, -3, 4, -1, -2, 1, 5, -3};
    
    System.out.println(maxSubarraySum(arr));
    System.out.println(maxSubarrayWithNeg(arr));
  }
  
  public static int maxSubarraySum(int[] arr) {
    int maxSum = 0;
    int currSum = 0;
    
    for(int i = 0; i < arr.length; i++) {
      currSum = currSum + arr[i];
      
      if(currSum < 0)
        currSum = 0;
      
      else if(maxSum < currSum)
        maxSum = currSum;
    }
    
    return maxSum;
  }
  
  public static int maxSubarrayWithNeg(int[] arr) {
    int maxSum = arr[0];
    int currSum = arr[0];
    
    for(int i = 1; i < arr.length; i++) {
      currSum = Math.max(arr[i], currSum+arr[i]);
      maxSum = Math.max(maxSum, currSum);
    }
    
    return maxSum;
  }
}

