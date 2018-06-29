import java.io.*;
import java.util.*;

public class String_CharIsUnique {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("abc");
    strings.add("aabc");
    strings.add("aB b");

    for (String string : strings) {
      System.out.println(isUnique(string));
    }
  }
  
  //brute force: compare each char with each other O(n^2)
  //lil better: sort and compare O(nlogn)
  //even better: O(n) but really O(1) cuz 128
  //space complexity is O(1) cuz constant
  public static boolean isUnique(String str) {
    str = str.toLowerCase();
    str.replaceAll("\\s", "");
    
    if(str.length() > 128)
      return false;
    
    boolean[] charArr = new boolean[128];
    
    for(char c: str.toCharArray()) {
      if(charArr[c])
        return false;
      else {
        charArr[c] = true; 
      }
    }
    
    return true;
  }
}
