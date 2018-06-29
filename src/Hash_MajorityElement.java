import java.io.*;
import java.util.*;

public class Hash_MajorityElement {
  public static void main(String[] args) {
    int[] arr = new int[]{2,2,2,2,5,5,2,3,3};

    System.out.println(findMajority(arr));
  }
  
  //O(n) time and space
  public static int findMajority(int[] arr) {
    int majorityCount = arr.length/2;
    
    HashMap<Integer, Integer> numCount = new HashMap<Integer, Integer>();
    
    for(int i = 0; i < arr.length; i++) {
      if(numCount.containsKey(arr[i])) {
        int count = numCount.get(arr[i]) + 1;
        
        if(count > majorityCount)
          return arr[i];
        
        else
          numCount.put(arr[i], count);
      }
      else {
        numCount.put(arr[i], 1); 
      }
    }
    
    return -1;
  }
}

