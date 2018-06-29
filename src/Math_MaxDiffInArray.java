import java.io.*;
import java.util.*;

/*
 * Given an array arr[], find the maximum 
 * j – i such that arr[j] > arr[i].
 */
public class Math_MaxDiffInArray {
  public static void main(String[] args) {
    int[] arr = {4,1,2,3};
    System.out.println(maxDiff(arr));
    
    int[] arr2 = {5, 10, 7, 6, 4, 3, 1};
    System.out.println(maxDiff(arr2));
  }
  
  public static int maxDiff(int[] arr) {
    if(arr.length == 0)
      return -1;
    
    int maxDiff = -1;
    int minValue = arr[0];
    
    if(arr.length > 1) {
      for(int i = 1; i < arr.length; i++) {
        if(arr[i] - minValue > maxDiff)
          maxDiff = arr[i] - minValue;
        
        if(arr[i] < minValue)
          minValue = arr[i];
      }
    }
    
    return maxDiff;
  }
}
