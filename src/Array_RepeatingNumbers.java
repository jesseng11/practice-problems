import java.io.*;
import java.util.*;

//Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times. Find these repeating numbers
public class Array_RepeatingNumbers {
  public static void main(String[] args) {
    int arr[] = {4, 2, 4, 5, 2, 3, 1};
    printAllRepeat(arr);
  }
  
  //time O(n) space O(n)
  public static void printAllRepeating(int[] nums) {
    int[] count = new int[nums.length];
    
    for(int i = 0; i < nums.length; i++) {
      if(count[nums[i]] == 1)
        System.out.println(nums[i] + " ");
      else
        count[nums[i]]++;
    }
  }
  
  //time O(n) space O(1)
  public static void printAllRepeat(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
      if(nums[Math.abs(nums[i])] < 0)
        System.out.println(Math.abs(nums[i]) + " ");
      else
        nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
    }
  }
}

