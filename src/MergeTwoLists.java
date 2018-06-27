import java.io.*;
import java.util.*;

public class MergeTwoLists {
  public static void main(String[] args) {
    int a[] = { 10, 5, 15 };
    int b[] = { 20, 3, 2, 12, 13 };

    // Final merge list
    ArrayList<Integer> result = sortedMerge(a, b);

    System.out.print( "Sorted merged list :");
    for (int i = 0; i < result.size(); i++)
        System.out.print(" " + result.get(i));   
  }
  
  //Time Complexity : O (nlogn + mlogm + (n + m))
  //Space Complexity : O ( (n + m) )
  public static ArrayList<Integer> sortedMerge(int[] a, int [] b) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    
    Arrays.sort(a);
    Arrays.sort(b);
    
    int i = 0;
    int j = 0;
    
    while(i < a.length && j < b.length) {
      if(a[i] == b[j]) {
        result.add(a[i]);
        i++;
        j++;
      }
      else if(a[i] < b[j]) {
        result.add(a[i]);
        i++;
      }
      else {
        result.add(b[j]);
        j++;
      }
    }
    
    while(i < a.length) {
      if(result.size() == 0 || a[i] != result.get(result.size()-1)) {
        result.add(a[i]); 
      }
      
      i++;
    }
    while(j < b.length) {
      if(result.size() == 0 || b[j] != result.get(result.size()-1)) {
        result.add(b[j]); 
      }
      
      j++;
    }
    
    return result;
  }
}

