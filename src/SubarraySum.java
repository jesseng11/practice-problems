import java.io.*;
import java.util.*;

/*
 * Given an unsorted array of integers, 
 * find a subarray which adds to a given number. 
 * If there are more than one subarrays with sum 
 * as the given number, print any of them.
 */
public class SubarraySum {

  public static void main(String[] args) {
    int target = 60;
    
    int[] arr = {1, 2, 10, 20, 30, 6};
    okaySubarray(arr, target);
    
    int[] neg = {1, 2, 10, 20, -5, 55, -20};
    subarraySum(neg, target);
  }
	  
  //handle negatives
  //O(n) time and space
  public static void subarraySum(int[] arr, int target) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    int currSum = 0;
    
    for(int i = 0; i < arr.length; i++) {
      currSum += arr[i];
      
      if(currSum == target) {
        System.out.println(0 + "-" + i);
        return;
      }
      
      if(map.containsKey(currSum - target)) {
        int beginningIndex = map.get(currSum - target) + 1;
        System.out.println(beginningIndex + "-" + i);
        return;
      }
      
      map.put(currSum, i);
    }
  }
  
  //O(n) but doesn't handle negatives
  public static void okaySubarray(int[] arr, int target) {
    int currSum = arr[0];
    int start = 0;
    
    for(int i = 1; i < arr.length; i++) {
      while(currSum > target && start < i-1) {
        currSum -= arr[start];
        start++;
      }
      
      if(currSum == target) {
        int j = i - 1;
        System.out.println(start + "-" + j);
        return;
      }
      
      currSum += arr[i];
    }
    
    System.out.println("No subarray");
    return;
  }
  
  //O(n^2) and doesn't handle negatives
  public static void badSubarray(int[] arr, int target) {
    int currSum;
    
    for(int i = 0; i < arr.length; i++) {
      currSum = arr[i];
      
      for(int j = i+1; j < arr.length; j++) {
        if(currSum == target) {
          int k = j - 1;
          System.out.println(i + "-" + k);
          return;
        }
        
        if(currSum > target)
          break;
        
        currSum += arr[j];
      }
    }
    
    System.out.println("No subarray");
    return;
  }
}
