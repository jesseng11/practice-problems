import java.io.*;
import java.util.*;

public class String_FirstNonRepeatingChar {
  public static void main(String[] args) {
    String str = "geeksforgeeks";
    //int index = indexOfFirstNonRepeating(str);
    int index = firstNonRepeating(str);
    
    System.out.println(str.charAt(index));
  }
  
  //time O(n)
  public static int indexOfFirstNonRepeating(String str) {
    int[] count = new int[256];
    
    for(char c: str.toCharArray())
      count[c]++;
    
    int index = -1; 
    for(int i = 0; i < str.length(); i++) {
      if(count[str.charAt(i)] == 1) {
        index = i;
        break;
      }
    }
    
    return index;
  }
  
  //O(n) but much better approach in practice cuz you only iterate through string once and then the hashmap once
  static Integer firstNonRepeating(String str) {
    HashMap<Character, CountIndex> map = new HashMap<Character, CountIndex>();
    
    for(int i = 0; i < str.length(); i++) {
      if(map.containsKey(str.charAt(i)))
        map.get(str.charAt(i)).count++;
      else
        map.put(str.charAt(i), new CountIndex(i));
    }
    
    int index = Integer.MAX_VALUE;
    
    for(CountIndex value: map.values()) {
      if(value.count == 1 && value.index < index)
        index = value.index;
    }
    
    if (index >= str.length())
      return null;
    
    return index;
  }
}

class CountIndex {
  public int count;
  public int index;
  
  public CountIndex(int index) {
    this.index = index;
    this.count = 1;
  }
}
