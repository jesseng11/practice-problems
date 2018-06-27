import java.io.*;
import java.util.*;

public class LongestUniqueSubstring {
  public static void main(String[] args) {
    longestUniqueSubstring("javaconceptoftheday");
  }
  
  public static void longestUniqueSubstring(String str) {
    if(str == null)
      return;
    
    char[] charArr = str.toCharArray();
    
    String longestSubstring = null;
    int longestLength = 0;
    
    //use linkedhashmap instead of hashmap cuz it keeps insertion order
    LinkedHashMap<Character, Integer> charPos = new LinkedHashMap<Character, Integer>();
    
    for(int i = 0; i < charArr.length; i++) {
      char curr = charArr[i];
      
      if(!charPos.containsKey(curr))
        charPos.put(curr, i);
      
      else {
        i = charPos.get(curr);
        charPos.clear(); 
      }
      
      if(charPos.size() > longestLength) {
        longestSubstring = charPos.keySet().toString();
        longestLength = charPos.size();
      }
    }
    
    System.out.println(longestSubstring);
    System.out.println(longestLength);
    
  }
}

