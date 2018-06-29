import java.io.*;
import java.util.*;

public class String_IsAnagram {
  public static void main(String[] args) {
    String string1 = "Hello, World!";
    String string2 = "Welcome to CoderPad.";
    String string3 = "World!Hello, ";

    System.out.println(isPermutation2(string1, string2));
    System.out.println(isPermutation2(string1, string3));
  }
  
  //assume all lowercase and no whitespace
  //O(nlogn)
  public static boolean isPermutation1(String s, String t) {
    s = s.replaceAll("\\s","");
    s.toLowerCase();
    t = t.replaceAll("\\s","");
    t.toLowerCase();
    
    char[] sArr = s.toCharArray();
    char[] tArr = t.toCharArray();
    
    Arrays.sort(sArr);
    Arrays.sort(tArr);
    
    if(Arrays.toString(sArr).equals(Arrays.toString(tArr)))
      return true;
    
    return false;
  }
  
  //O(n)
  public static boolean isPermutation2(String s, String t) {
    s = s.replaceAll("\\s","");
    s.toLowerCase();
    t = t.replaceAll("\\s","");
    t.toLowerCase();
    
    if(s.length() != t.length()) return false;
    
    int[] sCount = new int[128];
    
    for(char c: s.toCharArray()) {
       sCount[c]++;
    }
    
    for(char tChar: t.toCharArray()) {
      sCount[tChar]--;
      
      if(sCount[tChar] < 0)
        return false;
    }
    
    return true;
  }
}
