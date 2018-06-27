import java.io.*;
import java.util.*;

public class FirstRepeating {
  public static void main(String[] args) {
    int arr[] = {10, 5, 3, 4, 5, 3, 6};
    System.out.println(getFirstRepeating(arr));

  }
  
  public static int getFirstRepeating(int[] arr) {
    HashSet<Integer> set = new HashSet<Integer>();
    
    int firstRepeat = -1;
    
    for(int i = arr.length-1; i > -1; i--) {
      if(set.contains(arr[i])) {
        firstRepeat = arr[i]; 
      }
      else {
        set.add(arr[i]); 
      }
    }
    
    return firstRepeat;
  }
}

