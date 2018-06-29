import java.io.*;
import java.util.*;

public class Math_MissingNumberSingleAndMultiple {
  public static void main(String[] args) {
    //test edge cases
    int[] arr = new int[] {0,1,2,3,4,5,6,7,8};
    System.out.println(findMissing(arr));
    int[] arr2 = new int[] {1,2,3,4,5,6,7,8,9};
    System.out.println(findMissing(arr2));
    
    int[] arr3 = new int[] {0,1,2,4,5,7,8,9};
    ArrayList<Integer> missing = findMultipleMissing(arr3, 10);
    for(Integer result: missing)
      System.out.print(result + " ");
  }
  
  //O(n)
  //but if the array is huge, there could be interger overflow
  public static int findMissing(int[] numbers) {
    //sum of numbers including one missing number
    int total = (numbers.length) * (numbers.length+1) / 2;
    
    int sum = 0;
    
    for(int i = 0; i < numbers.length; i++) {
      sum += numbers[i]; 
    }
    
    return total-sum;
  }
  
  public static ArrayList<Integer> findMultipleMissing(int[] numbers, int N) {
    ArrayList<Integer> missingNums = new ArrayList<Integer>();
    int index = 0;
    
    for(int i = 0; i < N; i++) {
      if(index < numbers.length) {
        if(numbers[index] != i) {
          missingNums.add(i);
          i++;
        }
        
        index++;
      }
    }
    
    return missingNums;
  }
  
  
  public static ArrayList<Integer> multipleMissingNums(int[] nums) {
    ArrayList<Integer> missing = new ArrayList<Integer>();
    
    for(int i = 0; i < nums.length-1; i++) {
      int diff = nums[i+1] - nums[i];
      if(diff > 1) {
        missing.add((nums[i+1] + nums[i]) / 2);
      }
    }
    
    return missing;
  }
}

