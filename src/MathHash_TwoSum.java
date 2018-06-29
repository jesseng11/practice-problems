import java.io.*;
import java.util.*;

public class MathHash_TwoSum {
  public static void main(String[] args) {
    int A[] = {1, 4, 45, 6, 10, 8, 8};
    int sum = 16;
    twoSum(A, sum);
  }
  
  public static void twoSum(int[] arr, int sum) {
    HashSet<Integer> set = new HashSet<Integer>();
    
    for(int i = 0; i < arr.length; i++) {
      int neededNum = sum - arr[i];
      
      if(neededNum >= 0 && set.contains(neededNum))
        System.out.println("Pair with given sum " +
                            sum + " is (" + arr[i] +
                            ", " + neededNum + ")");
      
      set.add(arr[i]);
    }
  }
}

